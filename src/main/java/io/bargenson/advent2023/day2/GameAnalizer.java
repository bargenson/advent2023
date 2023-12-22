package io.bargenson.advent2023.day2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GameAnalizer {

    private final List<Game> games;

    public GameAnalizer(String input) {
        this.games = input.lines().map(this::buildGame).collect(Collectors.toList());
    }

    public List<Game> getAllGames() {
        return this.games;
    }
    
    public List<Integer> possibleGames(Map<Color, Integer> criteria) {
        return this.games.stream()
            .filter(game -> this.filterOnCriteria(game, criteria))
            .map(game -> game.getIdentifier())
            .collect(Collectors.toList());
    }

    private Game buildGame(String gameLine) {
        var splits = gameLine.split(":|;");
        var identifierPart = splits[0];
        List<String> drawParts = Arrays.asList(
            Arrays.copyOfRange(splits, 1, splits.length)
        );
        var identifier = extractIdentier(identifierPart);
        List<Draw> draws = drawParts.stream()
            .map(part -> buildDraw(part))
            .collect(Collectors.toList());
        return new Game(identifier, draws);
    }

    private Draw buildDraw(String drawLine) {
        return new Draw(
            extractColor(drawLine, Color.RED),
            extractColor(drawLine, Color.GREEN),
            extractColor(drawLine, Color.BLUE)
        );
    }

    private int extractColor(String string, Color color) {
        return Pattern.compile("\\d+ " + color.getText())
            .matcher(string)
            .results()
            .map(result -> Integer.parseInt(result.group().split(" ")[0]))
            .findFirst()
            .orElse(0);
    }

    private int extractIdentier(String gameLine) {
        return Pattern.compile("\\d+")
            .matcher(gameLine)
            .results()
            .map(result -> Integer.parseInt(result.group()))
            .findFirst()
            .orElseThrow();
    }

    private boolean filterOnCriteria(Game game, Map<Color, Integer> criteria) {
        return criteria.entrySet().stream().allMatch(entrySet -> {
            Color color = entrySet.getKey();
            int amount = entrySet.getValue();
            switch (color) {
                case RED: return game.confirmedRed() <= amount;
                case GREEN: return game.confirmedGreen() <= amount;
                case BLUE: return game.confirmedBlue() <= amount;
                default: throw new RuntimeException();
            }
        });
    }
}
