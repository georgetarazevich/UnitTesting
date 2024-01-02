package com.sbtesting.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
    private static Logger log = Logger.getLogger(BaseTest.class.getName());

    @BeforeSuite
    public void setUpSuite() {
        log.info("\n\nStarting suite ... \n");
    }
}
