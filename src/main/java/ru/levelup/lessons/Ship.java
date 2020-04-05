package ru.levelup.lessons;


public class Ship {
    private String type;
    private Double capacity;
    private Double speed;

    public Ship() {
        this.type = "Steamboat";
        this.capacity = 1500.0;
        this.speed = 25.0;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "type='" + type + '\'' +
                ", isWarship=" + capacity +
                ", speed=" + speed +
                '}';
    }
}
