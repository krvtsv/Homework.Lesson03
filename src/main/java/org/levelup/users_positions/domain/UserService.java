package org.levelup.users_positions.domain;

import java.sql.SQLException;

public interface UserService {
    User createUser(String passport, String name, String lastName) throws SQLException;
    User findByPassport(String passport) throws SQLException;
    User findByNameAndLastName(String name, String lastName) throws SQLException;
    User findByLastName(String lastName) throws SQLException;
    void deleteUserByPassport(String passport) throws SQLException;
    User updateUser(String passport, String name, String lastName) throws SQLException;


}
