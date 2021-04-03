package org.example.number;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberFounderUtilTest {
    private static final String SUM_SIX_JSON_VALUE = "Node 1 5";

    private static final String ZERO_JSON_VALUE = "Node";

    @Test
    public void testNumberFounder(){
        int expectedNumber = 6;
        Assert.assertEquals(expectedNumber, NumberFounderUtil.findNumberInJsonValue(SUM_SIX_JSON_VALUE));
    }

    @Test
    public void testZeroNodeJsonFounder(){
        int expectedNumber = 0;
        Assert.assertEquals(expectedNumber, NumberFounderUtil.findNumberInJsonValue(ZERO_JSON_VALUE));
    }
}