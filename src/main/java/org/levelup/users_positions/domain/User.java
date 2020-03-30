package org.levelup.users_positions.domain;

public class User {
    private int id;
    private String name;
    private String lastName;
    private String passport;

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

    @Override
    public String toString() {
        return "User: " +
                "id = " + id +
                ", name = " + name +
                ", last name = " + lastName +
                ", passport = " + passport;
    }
}
