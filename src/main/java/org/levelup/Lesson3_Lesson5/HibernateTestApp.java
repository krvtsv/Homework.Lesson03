package org.levelup.Lesson3_Lesson5;

import org.hibernate.SessionFactory;
import org.levelup.Lesson3_Lesson5.Hibernate.JobSessionFactoryConfiguration;
import org.levelup.Lesson3_Lesson5.Hibernate.PositionHibernateService;
import org.levelup.Lesson3_Lesson5.Hibernate.UserHibernateService;
import org.levelup.Lesson3_Lesson5.domain.Position;
import org.levelup.Lesson3_Lesson5.domain.User;

import java.util.Collection;


public class HibernateTestApp {

    public static void main(String[] args) {
        SessionFactory factory = new JobSessionFactoryConfiguration().configure();
        UserHibernateService userService = new UserHibernateService(factory);
        PositionHibernateService positionService = new PositionHibernateService(factory);

        System.out.println(positionService.createPosition("Test_Position"));

        positionService.deletePositionById(21);

        positionService.deletePositionByName("Test_Position");

        Collection<Position> likePositions = positionService.findAllPositionWhichNameLike("Dev%");
        for (Position position : likePositions) {
            System.out.println(position.getId() + " " + position.getName());
        }

        System.out.println(positionService.findPositionById(1));

        Collection<Position> allPositions = positionService.findAllPositions();
        for (Position position : allPositions) {
            System.out.println(position.getId() + " " + position.getName());
        }

        System.out.println(positionService.findPositionByName("prog"));


        // test User Service

        System.out.println(userService.createUser("7895 097654","Svetlana","Kozlova"));

        System.out.println(userService.findByPassport("6785 383624"));

        System.out.println(userService.findByLastName("Kozlova"));
        System.out.println(userService.findByNameAndLastName("Oleg","Olegov"));

        System.out.println(userService.updateUser("0972 445672", "Ivan", "Ivanov"));

        userService.deleteUserByPassport("Kozlova");
        factory.close();

    }
}
