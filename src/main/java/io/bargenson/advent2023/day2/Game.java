package io.bargenson.advent2023.day2;

import java.util.List;

public class Game {

    private final Integer identifier;
    private final List<Draw> draws;
    
    public Game(Integer identifier, List<Draw> draws) {
        this.identifier = identifier;
        this.draws = draws;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public List<Draw> getDraws() {
        return draws;
    }

    public int confirmedRed() {
        return draws.stream().map(draw -> draw.getRed()).max(Integer::compareTo).orElse(0);
    }

    public int confirmedGreen() {
        return draws.stream().map(draw -> draw.getGreen()).max(Integer::compareTo).orElse(0);
    }

    public int confirmedBlue() {
        return draws.stream().map(draw -> draw.getBlue()).max(Integer::compareTo).orElse(0);
    }

    @Override
    public String toString() {
        return "Game [identifier=" + identifier + ", draws=" + draws + "]";
    }

    public int getPower() {
        return this.confirmedBlue() * this.confirmedRed() * this.confirmedGreen();
    }
}
