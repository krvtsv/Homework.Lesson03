package org.levelup.users_positions;

import org.levelup.users_positions.domain.Position;
import org.levelup.users_positions.jdbc.PositionJdbcService;


import java.sql.SQLException;
import java.util.Collection;

public class TestApplication {

    public static void main(String[] args) throws SQLException {
        PositionJdbcService service = new PositionJdbcService();

       System.out.println(service.createPosition("Test_Position"));

        service.deletePositionById(25);

        service.deletePositionByName("Test_Position");

        Collection<Position> likePositions = service.findAllPositionWhichNameLike("Dev%");
        for (Position position : likePositions) {
            System.out.println(position.getId() + " " + position.getName());
        }

        System.out.println(service.findPositionById(1));

        Collection<Position> allPositions = service.findAllPositions();
        for (Position position : allPositions) {
            System.out.println(position.getId() + " " + position.getName());
        }

        System.out.println(service.findPositionByName("prog"));
    }
}
