package io.bargenson.advent2023.day1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalibrationDocumentTest {

    @Test
    public void testGetCalibrationValue() {
        var input = """
        1abc2
        pqr3stu8vwx
        a1b2c3d4e5f
        treb7uchet
        """;
        
        var document = new CalibrationDocument(input);

        assertEquals(142, document.getCalibrationValue());
    }

    @Test
    public void testGetCalibrationValueWithNumberAsText() {
        var input = """
        two1nine
        eightwothree
        abcone2threexyz
        xtwone3four
        4nineeightseven2
        zoneight234
        7pqrstsixteen
        eightsevenvqvzlqxkbm6rqhsgqpnine7twonex
        """;
        
        var document = new CalibrationDocument(input);

        assertEquals(362, document.getCalibrationValue());
    }
}
