package io.bargenson.advent2023.day2;

public class Draw {

    private final int red;
    private final int green;
    private final int blue;

    public Draw(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
    
    @Override
    public String toString() {
        return "Draw [red=" + red + ", green=" + green + ", blue=" + blue + "]";
    }
}
