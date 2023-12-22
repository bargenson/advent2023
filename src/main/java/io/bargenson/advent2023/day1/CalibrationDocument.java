package io.bargenson.advent2023.day1;

import java.util.Map;
import java.util.Optional;

/**
 * CalibrationDocument
 */
public class CalibrationDocument {

    private static final Map<String, Integer> NUMBER_MAPPING = Map.of(
        "one", 1,
        "two", 2,
        "three", 3,
        "four", 4,
        "five", 5,
        "six", 6,
        "seven", 7,
        "eight", 8,
        "nine", 9
    );
    private final String input;

    public CalibrationDocument(String input) {
        this.input = input;
    }

    public int getCalibrationValue() {
        return input.lines()
            .map(line -> {
                int firstNumber = findFirstNumber(line);
                int lastNumber = findLastNumber(line);
                return concatNumbers(firstNumber, lastNumber);
            })
            .reduce(0, Integer::sum);
    }

    private int findLastNumber(String line) {
        return findLastNumber(line, 0).orElseThrow();
    }

    private int findFirstNumber(String line) {
        return findFirstNumber(line, 0).orElseThrow();
    }

    private Integer concatNumbers(Integer num1, Integer num2) {
        return Integer.parseInt(num1 + "" + num2);
    }

    private Optional<Integer> findLastNumber(String line, int processedChars) {
        int processingChars = processedChars + 1;
        String substring = line.substring(line.length() - processingChars, line.length());
        return Optional.ofNullable(
            detectNumber(substring).orElseGet(
                () -> findLastNumber(line, processingChars).get()
            )
        );
    }

    private Optional<Integer> findFirstNumber(String line, int processedChars) {
        int processingChars = processedChars + 1;
        String substring = line.substring(0, processingChars);
        return Optional.ofNullable(
            detectNumber(substring).orElseGet(
                () -> findFirstNumber(line, processingChars).get()
            )
        );
    }

    private Optional<Integer> detectNumber(String value) {
        Integer result = NUMBER_MAPPING.entrySet().stream()
            .filter(entry -> value.contains(entry.getKey()))
            .findFirst()
            .map(entry -> NUMBER_MAPPING.get(entry.getKey()))
            .orElseGet(() -> value.chars()
                .filter(Character::isDigit)
                .mapToObj(c -> String.valueOf((char) c))
                .map(c -> Integer.valueOf(c))
                .findFirst()
                .orElse(null)
            );
        return Optional.ofNullable(result);
    }
}