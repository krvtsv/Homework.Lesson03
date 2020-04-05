package ru.levelup.lessons.city;

public class Bridge {

    private Double length;
    private boolean isSwing;
    private String material;

    public Bridge() {
        this.length = 80.0;
        this.isSwing = false;
        this.material = "steel";
    }

    @Override
    public String toString() {
        return "Bridge{" +
                "length=" + length +
                ", isSwing=" + isSwing +
                ", material='" + material + '\'' +
                '}';
    }


}
