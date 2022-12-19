package com.jpetstore.tags;

/**
 * JPetStoreTags class which define JUnit5 Tags used for filter out tests for execution in maven.
 */
public class JPetStoreTags {

    /**
     * Smoke tests known also as build verification tests or build acceptance tests
     */
    public static final String SMOKE = "SMOKE";
    /**
     * Regression tests used to ensure that previously developed and tested software still performs as expected after a change.
     */
    public static final String REGRESSION = "REGRESSION";
    /**
     * Critical tests
     */
    public static final String BUG_FIX = "BUG_FIX";
}
