package org.cafesss.sssmenu;

public class Drink {
    private String name;
    private int cost;
    private char temp;
    private char size;
    private int smallImage;

    public int getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(int smallImage) {
        this.smallImage = smallImage;
    }

    public int getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(int largeImage) {
        this.largeImage = largeImage;
    }

    private int largeImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public char getTemp() {
        return temp;
    }

    public void setTemp(char temp) {
        this.temp = temp;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

}
