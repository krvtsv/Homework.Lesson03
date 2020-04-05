package ru.levelup.lessons.city;

public class Building {
    private Integer floors;
    private Integer lifeSpan;
    private String material;

    public Building() {
        this.floors = 10;
        this.lifeSpan = 120;
        this.material = "brick";
    }

    @Override
    public String toString() {
        return "Building{" +
                "floors=" + floors +
                ", lifeSpan=" + lifeSpan +
                ", material='" + material + '\'' +
                '}';
    }
}


