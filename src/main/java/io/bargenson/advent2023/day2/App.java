package io.bargenson.advent2023.day2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.bargenson.advent2023.commons.InputFetcher;

public class App {

    private static final String INPUT_FILE_PATH = "https://gist.githubusercontent.com/bargenson/b8b29e83ee4633b6337ae6aedb81ae48/raw/2c9858999f8816946f5a4f7f1b96d5d42d3cb74b/advent2023-day2";

    public static void main(String[] args) throws IOException, InterruptedException {
        var criteria = Map.of(
            Color.RED, 12,
            Color.GREEN, 13,
            Color.BLUE, 14
        );
        String input = new InputFetcher().fetch(INPUT_FILE_PATH);

        GameAnalizer gameAnalizer = new GameAnalizer(input);

        List<Integer> possibleGames = gameAnalizer.possibleGames(criteria);
        System.out.println("Result part 1: " + possibleGames.stream().reduce(Integer::sum).get());

        List<Game> allGames = gameAnalizer.getAllGames();
        int sumOfPower = allGames.stream().map(game -> game.getPower()).reduce(Integer::sum).get();
        System.out.println("Result part 2: " + sumOfPower);
    }
}
