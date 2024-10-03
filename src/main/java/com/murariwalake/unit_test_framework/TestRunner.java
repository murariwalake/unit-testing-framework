package com.murariwalake.unit_test_framework;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;

class TestRunner {

    private int passedTests = 0;
    private int failedTests = 0;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public void runTests(List<Class<?>> testClasses) {
        // Log the test session start
        System.out.println("=========================================");
        System.out.println("TEST SESSION STARTED AT: " + dtf.format(LocalDateTime.now()));
        System.out.println("=========================================\n");

        // Loop through all the test classes
        for (Class<?> testClass : testClasses) {
            System.out.println("Running tests for class: " + testClass.getSimpleName() + "\n");
            runTestClass(testClass);
        }

        // Log the test session end
        System.out.println("\n=========================================");
        System.out.println("TEST SESSION COMPLETED AT: " + dtf.format(LocalDateTime.now()));
        System.out.println("=========================================");
        System.out.println("TOTAL TESTS: " + (passedTests + failedTests));
        System.out.println("PASSED: " + passedTests);
        System.out.println("FAILED: " + failedTests);
        System.out.println("=========================================");
    }

    private void runTestClass(Class<?> testClass) {
        Method beforeClassMethod = null;
        Method afterClassMethod = null;
        Method beforeEachMethod = null;
        Method afterEachMethod = null;

        // Identify methods annotated with @BeforeClass and @AfterClass
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeClass.class)) {
                beforeClassMethod = method;
            }
            if (method.isAnnotationPresent(AfterClass.class)) {
                afterClassMethod = method;
            }
        }

        // Run @BeforeClass method once before all tests
        if (beforeClassMethod != null) {
            try {
                beforeClassMethod.invoke(testClass.getDeclaredConstructor().newInstance());
                System.out.println("[INFO] @BeforeClass: " + beforeClassMethod.getName() + " executed." + "\n");
            } catch (Exception e) {
                System.out.println("[ERROR] @BeforeClass execution failed: " + e.getCause().getMessage()+ "\n");
            }
        }

        // Identify methods annotated with @BeforeEach, @AfterEach, and run @Test methods
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeEach.class)) {
                beforeEachMethod = method;
            }
            if (method.isAnnotationPresent(AfterEach.class)) {
                afterEachMethod = method;
            }
        }

        // Run each test method annotated with @Test
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    if (beforeEachMethod != null) {
                        beforeEachMethod.invoke(testClass.getDeclaredConstructor().newInstance());
                        System.out.println("[INFO] @BeforeEach: " + beforeEachMethod.getName() + " executed.");
                    }

                    method.invoke(testClass.getDeclaredConstructor().newInstance());
                    passedTests++;
                    System.out.println("[PASS] " + method.getName());

                } catch (Exception e) {
                    failedTests++;
                    System.out.println("[FAIL] " + method.getName() + " failed: " + e.getCause().getMessage());
                }

                if (afterEachMethod != null) {
                    try {
                        afterEachMethod.invoke(testClass.getDeclaredConstructor().newInstance());
                        System.out.println("[INFO] @AfterEach: " + afterEachMethod.getName() + " executed." + "\n");
                    } catch (Exception e) {
                        System.out.println("[ERROR] @AfterEach execution failed: " + e.getCause().getMessage() + "\n");
                    }
                }
            }
        }

        // Run @AfterClass method once after all tests
        if (afterClassMethod != null) {
            try {
                afterClassMethod.invoke(testClass.getDeclaredConstructor().newInstance());
                System.out.println("[INFO] @AfterClass: " + afterClassMethod.getName() + " executed." + "\n");
            } catch (Exception e) {
                System.out.println("[ERROR] @AfterClass execution failed: " + e.getCause().getMessage() + "\n");
            }
        }
    }
}



