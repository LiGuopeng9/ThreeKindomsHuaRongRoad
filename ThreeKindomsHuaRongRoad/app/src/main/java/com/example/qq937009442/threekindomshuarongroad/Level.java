package com.example.qq937009442.threekindomshuarongroad;

public class Level {
    private String levelName;
    private final int image;
    private int num;

    public Level(String levelName, int image, int num) {
        this.levelName = levelName;
        this.image = image;
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getImage() {
        return image;
    }
}
