package com.murariwalake.unit_test_framework;

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
    public void testAssertEqual() {
        Assertions.assertEqual(5, 5); // Should pass
    }

    @Test
    public void testAssertEqualFailure() {
        Assertions.assertEqual(5, 3); // Should fail
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
