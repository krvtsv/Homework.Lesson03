package org.levelup.Lesson3.jdbc;

import org.levelup.Lesson3.domain.Position;
import org.levelup.Lesson3.domain.User;
import org.levelup.Lesson3.domain.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class UsersJdbcService implements UserService {
    public User createUser(String passport, String name, String lastName) throws SQLException {

        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into users (name,last_name,passport) values (?,?,?)");
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setString(3, passport);
            int rowChanged = statement.executeUpdate();
            System.out.println(rowChanged + " user(s) have been added");
            return findByPassport(passport);
        }
    }

    public User findByPassport(String passport) throws SQLException {
        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement("select * from users where passport = ?");
            selectStatement.setString(1, passport);
            ResultSet resultSet = selectStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("id");
            String userName = resultSet.getString("name");
            String userLastName = resultSet.getString("last_name");
            String userPassport = resultSet.getString("passport");
            return new User(id, userName, userLastName, userPassport);
        }
    }

    public Collection<User> findByNameAndLastName(String name, String lastName) throws SQLException {
        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from users where name = ? and last_name = ?");
            statement.setString(1, name);
            statement.setString(2, lastName);
            ResultSet resultSet = statement.executeQuery();
            return extractUsers(resultSet);
        }
    }

    public Collection<User> findByLastName(String lastName) throws SQLException {
        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from users where last_name = ?");
            statement.setString(1, lastName);
            ResultSet resultSet = statement.executeQuery();
            return extractUsers(resultSet);
        }
    }

    public void deleteUserByPassport(String passport)throws SQLException {

        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from users where passport = ?");
            statement.setString(1, passport);
            int rowDeleted = statement.executeUpdate();
            System.out.println(rowDeleted + " user(s) have been deleted");
        }
    }

    public User updateUser(String passport, String name, String lastName) throws SQLException {
        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update users set name = ?, last_name=? where passport = ?");
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setString(3, passport);
            int rowChanged = statement.executeUpdate();
            System.out.println(rowChanged + " user(s) have been updated");
            return findByPassport(passport);
    }}

    private Collection<User> extractUsers(ResultSet resultSet) throws SQLException {
        Collection<User> users = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String userName = resultSet.getString("name");
            String userLastName = resultSet.getString("last_name");
            String userPassport = resultSet.getString("passport");
            users.add(new User(id, userName, userLastName, userPassport));
        }
        return users;
    }
}
