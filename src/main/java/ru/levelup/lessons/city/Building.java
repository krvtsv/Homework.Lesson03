package ru.levelup.lessons.city;

import org.levelup.Lesson4.RandomInt;

public class Building {
    @RandomInt(min=1,max=50)
    private Integer floors;
    @RandomInt(min=100,max=200)
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


