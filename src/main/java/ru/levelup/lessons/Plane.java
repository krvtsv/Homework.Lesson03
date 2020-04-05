package ru.levelup.lessons;

public class Plane {

    private String manufacturer;
    private String model;
    private Integer seats;

    public Plane() {
        this.manufacturer = "Boeing";
        this.model = "737";
        this.seats = 149;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", seats=" + seats +
                '}';
    }
}
