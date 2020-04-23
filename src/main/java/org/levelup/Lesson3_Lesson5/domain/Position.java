package org.levelup.Lesson3_Lesson5.domain;

import javax.persistence.*;

@Entity
@Table(name="positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100, nullable = false, unique = true)
    private String name;

    public Position() {
    }

    public Position(int id, String name){

        this.id =id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Position: " +
                "id = " + id +
                ", name = " + name;
    }
}
