package com.protel.emre.util;

import com.protel.emre.util.ClockUtil;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Tester class of utility class ClockUtil
 *
 * @author Emre Ozdemir
 * @version 1.0
 * @since 2018-10-22
 */
public class ClockUtilTest {

    private static final String NEW_LINE = System.getProperty("line.separator");

    /**
     * Test the conversion method when time parameter is null
     */
    @Test
    public void testNullTime() {
        ClockUtil util = new ClockUtil(Optional.ofNullable(null));
    }

    /**
     * Test when an invalid hour setted as parameter, expected Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHour() {
        ClockUtil util = new ClockUtil(Optional.of("25:15:21"));
    }

    /**
     * Test when an invalid time setted as parameter, expected Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTime() {
        ClockUtil util = new ClockUtil(Optional.of("A2:21:AA"));
    }

    /**
     * Test when an invalid minute setted as parameter, expected Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMinute() {
        ClockUtil util = new ClockUtil(Optional.of("15:85:21"));
    }

    /**
     * Test when an invalid second setted as parameter, expected Exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSecond() {
        ClockUtil util = new ClockUtil(Optional.of("15:21:90"));
    }

    /**
     * Test when an valid time setted as parameter, expected to be true
     */
    @Test
    public void testValidHours() {
        ClockUtil util = new ClockUtil(Optional.of("15:15:21"));
        assertEquals("Y" +
                NEW_LINE +
                "RRRO" +
                NEW_LINE +
                "OOOO" +
                NEW_LINE +
                "YYROOOOOOOO" +
                NEW_LINE +
                "OOOO" +
                NEW_LINE, util.getBerlinFormat());
    }

    /**
     * Test when an valid time setted as parameter, expected to be true
     */
    @Test
    public void testValidHours2() {
        ClockUtil util = new ClockUtil(Optional.of("07:15:20"));
        assertEquals("O" +
                NEW_LINE +
                "ROOO" +
                NEW_LINE +
                "RROO" +
                NEW_LINE +
                "YYROOOOOOOO" +
                NEW_LINE +
                "OOOO" +
                NEW_LINE, util.getBerlinFormat());
    }
}
