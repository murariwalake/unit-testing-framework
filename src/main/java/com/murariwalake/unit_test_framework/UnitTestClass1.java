package com.murariwalake.unit_test_framework;

public class UnitTestClass1 {

    @BeforeClass
    public void globalSetup() {
        System.out.println("Running @BeforeClass for UnitTestClass1");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Executing before each.");
    }

    @Test
    public void testMethod1() {
        Assertions.assertTrue(true); // Should pass
    }

    @Test
    public void testMethod2() {
        Assertions.assertFalse(false); // Should pass
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Executing after each");
    }

    @AfterClass
    public void globalTeardown() {
        System.out.println("Running @AfterClass for UnitTestClass1");
    }
}
