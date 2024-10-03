package com.murariwalake.unit_test_framework;

class Assertions {
    public static void assertTrue(boolean condition) {
        assertEqual(true, condition);
    }

    public static void assertEqual(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("Test failed: expected " + expected + " but got " + actual);
        }
    }

    public static void assertFalse(boolean condition) {
        assertEqual(false, condition);
    }
}
