package io.bargenson.advent2023.day2;

public enum Color {
    RED("red"),
    BLUE("blue"),
    GREEN("green");

    private String text;

    Color(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
