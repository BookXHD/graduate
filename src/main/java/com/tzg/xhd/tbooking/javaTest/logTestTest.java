package com.tzg.xhd.tbooking.javaTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class logTestTest {
    @org.junit.Test

    public void main() throws Exception {
        final Logger logger = LoggerFactory.getLogger(logTest.class);
        logger.trace("trace:logback is ok");
        logger.debug("debug:logback is ok");
        logger.info("info::logback is ok");
        logger.warn("warn::logback is ok");
        logger.error("error::logback is ok");
    }
}