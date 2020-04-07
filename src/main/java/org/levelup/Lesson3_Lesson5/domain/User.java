package org.levelup.Lesson3_Lesson5.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(name = "last_name", length = 100,nullable = false)
    private String lastName;
    @NaturalId
    @Column(length = 50,nullable = false, unique = true)
    private String passport;

    public User() {
    }

    public User(int id, String name, String lastName, String passport) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.passport = passport;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "User: " +
                "id = " + id +
                ", name = " + name +
                ", last name = " + lastName +
                ", passport = " + passport+"\n";
    }
}
