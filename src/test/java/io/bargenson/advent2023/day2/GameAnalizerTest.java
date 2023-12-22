package io.bargenson.advent2023.day2;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class GameAnalizerTest {

    public final static String input = """
    Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
    Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
    Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
    Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
    Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
    """;
    
    @Test
    public void testPossibleGames() {
        var criteria = Map.of(
            Color.RED, 12,
            Color.GREEN, 13,
            Color.BLUE, 14
        );

        List<Integer> possibleGames = new GameAnalizer(input).possibleGames(criteria);
        int sum = possibleGames.stream().reduce(Integer::sum).get();

        assertEquals(8, sum);
    }

    @Test
    public void testGetAllGames() {
        List<Game> games = new GameAnalizer(input).getAllGames();

        assertEquals(5, games.size());
        assertEquals(48, games.get(0).getPower());
        assertEquals(12, games.get(1).getPower());
        assertEquals(1560, games.get(2).getPower());
        assertEquals(630, games.get(3).getPower());
        assertEquals(36, games.get(4).getPower());
    }
}
