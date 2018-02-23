package com.tzg.xhd.tbooking.javaTest;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class logTest {
    private final static Logger logger = LoggerFactory.getLogger(logTest.class);
    public static void main(String[] args){
        logger.trace("trace:logback is ok");
        logger.debug("debug:logback is ok");
        logger.info("info::logback is ok");
        logger.warn("warn::logback is ok");
        logger.error("error::logback is ok");
    }
}
