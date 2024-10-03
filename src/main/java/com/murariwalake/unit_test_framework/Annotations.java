package com.murariwalake.unit_test_framework;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Test {
}

@Retention(RetentionPolicy.RUNTIME)
@interface BeforeClass {}

@Retention(RetentionPolicy.RUNTIME)
@interface AfterClass {}

@Retention(RetentionPolicy.RUNTIME)
@interface BeforeEach {}

@Retention(RetentionPolicy.RUNTIME)
@interface AfterEach {}
