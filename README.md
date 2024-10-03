# Custom Java Unit Testing Framework

## Overview

This is a minimalistic Java Unit Testing Framework developed for running unit tests in Java classes. The framework provides the following features:
- **Annotations**: Supports `@BeforeClass`, `@AfterClass`, `@BeforeEach`, `@AfterEach`, and `@Test`.
- **Test Runner**: Allows you to run tests across multiple classes.
- **Test Summary**: Displays the total number of tests, passed tests, and failed tests, along with the detailed execution results for each test method.
- **Standardized Console Output**: Provides clear logging of test execution, including success and failure messages.

## Features

- **Before and After Hooks**: Define setup and teardown logic with annotations like `@BeforeClass`, `@AfterClass`, `@BeforeEach`, and `@AfterEach`.
- **Multiple Test Classes**: Run multiple test classes in one go.
- **Clear Console Output**: A standardized format for displaying test results, including timestamps, success, and failure counts.

## Usage

### 1. Define Test Classes

You can create multiple test classes and annotate methods with the provided annotations to define setup, teardown, and test methods.

Example Test Classes:

```java
public class UnitTestClass1 {

    @BeforeClass
    public void globalSetup() {
        System.out.println("Running @BeforeClass for UnitTestClass1");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Setting up for UnitTestClass1...");
    }

    @Test
    public void testMethod1() {
        Assertions.assertTrue(true); // Should pass
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Tearing down for UnitTestClass1...");
    }

    @AfterClass
    public void globalTeardown() {
        System.out.println("Running @AfterClass for UnitTestClass1");
    }
}

public class UnitTestClass2 {

    @BeforeClass
    public void globalSetup() {
        System.out.println("Running @BeforeClass for UnitTestClass2");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Setting up for UnitTestClass2...");
    }

    @Test
    public void testMethod2() {
        Assertions.assertEqual(5, 5); // Should pass
    }

    @Test
    public void testMethod3() {
        Assertions.assertTrue(false); // Should fail
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Tearing down for UnitTestClass2...");
    }

    @AfterClass
    public void globalTeardown() {
        System.out.println("Running @AfterClass for UnitTestClass2");
    }
}
```

### 2. Run the Tests

You can run the tests by passing a list of test classes to the `TestRunner`.

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TestRunner runner = new TestRunner();
        runner.runTests(Arrays.asList(UnitTestClass1.class, UnitTestClass2.class));
    }
}
```

### 3. Console Output

When you run the tests, you will see structured output in the console that includes:
- Information about the `@BeforeClass`, `@BeforeEach`, `@AfterEach`, and `@AfterClass` methods.
- Detailed logs for each test method indicating whether it passed or failed.
- A summary with the total number of tests, passed tests, and failed tests.

Sample output:

``` 
=========================================
TEST SESSION STARTED AT: 2024/10/03 16:07:31
=========================================

Running tests for class: UnitTestClass1

Running @BeforeClass for UnitTestClass1
[INFO] @BeforeClass: globalSetup executed.

Executing before each.
[INFO] @BeforeEach: beforeEach executed.
[PASS] testMethod1
Executing after each
[INFO] @AfterEach: afterEach executed.

Executing before each.
[INFO] @BeforeEach: beforeEach executed.
[PASS] testMethod2
Executing after each
[INFO] @AfterEach: afterEach executed.

Running @AfterClass for UnitTestClass1
[INFO] @AfterClass: globalTeardown executed.

Running tests for class: UnitTestClass2

Running @BeforeClass for UnitTestClass2
[INFO] @BeforeClass: globalSetup executed.

Setting up for UnitTestClass2...
[INFO] @BeforeEach: setUp executed.
[PASS] testAssertEqual
Tearing down for UnitTestClass2...
[INFO] @AfterEach: tearDown executed.

Setting up for UnitTestClass2...
[INFO] @BeforeEach: setUp executed.
[FAIL] testAssertEqualFailure failed: Test failed: expected 5 but got 3
Tearing down for UnitTestClass2...
[INFO] @AfterEach: tearDown executed.

Setting up for UnitTestClass2...
[INFO] @BeforeEach: setUp executed.
[FAIL] testMethod3 failed: Test failed: expected true but got false
Tearing down for UnitTestClass2...
[INFO] @AfterEach: tearDown executed.

Running @AfterClass for UnitTestClass2
[INFO] @AfterClass: globalTeardown executed.


=========================================
TEST SESSION COMPLETED AT: 2024/10/03 16:07:31
=========================================
TOTAL TESTS: 5
PASSED: 3
FAILED: 2
=========================================

Process finished with exit code 0

```

### 4. Annotations

- **@BeforeClass**: Methods annotated with `@BeforeClass` will be executed **once** before all tests in the class.
- **@AfterClass**: Methods annotated with `@AfterClass` will be executed **once** after all tests in the class.
- **@BeforeEach**: Methods annotated with `@BeforeEach` will be executed **before each test method**.
- **@AfterEach**: Methods annotated with `@AfterEach` will be executed **after each test method**.
- **@Test**: Methods annotated with `@Test` are the actual test methods.

### 5. Assertions

We can use the following assertions for validation inside the test methods:
- **Assertions.assertTrue(condition)**: Asserts that a condition is true.
- **Assertions.assertFalse(condition)**: Asserts that a condition is false.
- **Assertions.assertEqual(expected, actual)**: Asserts that the expected value equals the actual value.

### 6. Extensibility

- We can add more test classes and pass them to the `TestRunner` as needed.
- The framework is designed to be minimalistic but extensible. We can add additional features like custom exception handling, parameterized tests, or more assertion methods.

---

## Installation

1. Clone this repository.
2. Open it in your preferred Java IDE (like IntelliJ IDEA or Eclipse).
3. Compile and run the `Main` class to execute the tests.