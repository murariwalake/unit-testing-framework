package com.murariwalake.unit_test_framework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TestRunner runner = new TestRunner();
        runner.runTests(Arrays.asList(UnitTestClass1.class, UnitTestClass2.class));
    }
}

