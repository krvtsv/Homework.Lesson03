package org.levelup.Lesson3_Lesson5.jdbc;

import org.levelup.Lesson3_Lesson5.domain.Position;
import org.levelup.Lesson3_Lesson5.domain.PositionService;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class PositionJdbcService implements PositionService {

    public Position createPosition(String name) throws SQLException {

        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into positions (name) values (?)");
            statement.setString(1, name);
            int rowChanged = statement.executeUpdate();
            System.out.println(rowChanged + " position(s) have been added");
            return findPositionByName(name);
        }
    }

    public void deletePositionById(int id) throws SQLException {

        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from positions where id = ?");
            statement.setInt(1, id);
            int rowDeleted = statement.executeUpdate();
            System.out.println(rowDeleted + " position(s) have been deleted");
        }
    }

    public void deletePositionByName(String name) throws SQLException {

        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from positions where name = ?");
            statement.setString(1, name);
            int rowDeleted = statement.executeUpdate();
            System.out.println(rowDeleted + " position(s) have been deleted");
        }
    }

    public Collection<Position> findAllPositionWhichNameLike(String name) throws SQLException {
        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from positions where name like ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            return extractPositions(resultSet);
        }
    }

    public Position findPositionById(int id) throws SQLException {
        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from positions where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int positionId = resultSet.getInt("id");
            String positionName = resultSet.getString("name");
            return new Position(positionId, positionName);
        }
    }

    public Collection<Position> findAllPositions() throws SQLException {
        try (Connection connection = JdbcUtils.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from positions");
            return extractPositions(resultSet);
        }
    }

    private Collection<Position> extractPositions(ResultSet resultSet) throws SQLException {
        Collection<Position> positions = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            positions.add(new Position(id, name));
        }
        return positions;
    }


    public Position findPositionByName(String name) throws SQLException {
        try (Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement("select * from positions where name = ?");
            selectStatement.setString(1, name);
            ResultSet resultSet = selectStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("id");
            String positionName = resultSet.getString("name");
            return new Position(id, positionName);
        }
    }
}