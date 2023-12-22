package io.bargenson.advent2023.day1;

import java.io.IOException;

import io.bargenson.advent2023.commons.InputFetcher;

public class App {

    private static final String INPUT_FILE_PATH = "https://gist.githubusercontent.com/bargenson/e68614646fa264aa71e379ac4c8a6183/raw/93be1f48da7d6adacab42caacefef32b5755a3ce/advent2023-day1";

    public static void main( String[] args ) throws InterruptedException, IOException {
        String input = new InputFetcher().fetch(INPUT_FILE_PATH);
        int result = new CalibrationDocument(input).getCalibrationValue();
        System.out.println("Result: " + result);
    }
}
