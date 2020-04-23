package org.levelup.Lesson8_Streams;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.levelup.Lesson8_Streams.TaskType.*;
import static org.levelup.Lesson8_Streams.UniqueKey.distinctByKey;

public class StreamApp {


    public static void main(String[] args) {

        Collection<Task> tasks = new ArrayList<>();
        tasks.add(new Task("1", "Collections", READING, LocalDate.of(2020, 04, 4), false, new HashSet<>(Arrays.asList("#java", "#programming", "#books", "#Self-learning")), LocalDate.of(2020, 04, 25)));
        tasks.add(new Task("2", "Lambdas", READING, LocalDate.of(2020, 04, 1), false, new HashSet<>(Arrays.asList("#java", "#programming", "#books", "#Homework")), LocalDate.of(2020, 04, 25)));
        tasks.add(new Task("3", "Streams", CODING, LocalDate.of(2020, 03, 10), false, new HashSet<>(Arrays.asList("#java", "#programming", "#Self-learning")), LocalDate.of(2020, 04, 25)));
        tasks.add(new Task("4", "Hibernate", WRITING, LocalDate.of(2020, 04, 4), false, new HashSet<>(Arrays.asList("#java", "#programming")), LocalDate.of(2020, 04, 25)));
        tasks.add(new Task("5", "Maven", READING, LocalDate.of(2020, 02, 8), true, new HashSet<>(Arrays.asList("#java", "#programming", "#books", "#Self-learning")), LocalDate.of(2020, 02, 18)));
        tasks.add(new Task("6", "JDBC", READING, LocalDate.of(2020, 04, 4), false, new HashSet<>(Arrays.asList("#java", "#programming","#books")), LocalDate.of(2020, 04, 25)));
        tasks.add(new Task("7", "Threads", CODING, LocalDate.of(2020, 04, 4), false, new HashSet<>(Arrays.asList("#java", "#programming")), LocalDate.of(2020, 04, 25)));
        tasks.add(new Task("8", "Interfaces", WRITING, LocalDate.of(2020, 04, 4), true, new HashSet<>(Arrays.asList("#java", "#programming")), LocalDate.of(2020, 04, 12)));
        tasks.add(new Task("9", "Anonymous Classes", READING, LocalDate.of(2020, 04, 4), false, new HashSet<>(Arrays.asList("#java", "#programming", "#books", "#Self-learning")), LocalDate.of(2020, 04, 25)));
        tasks.add(new Task("10", "Github", WRITING, LocalDate.of(2020, 03, 27), false, new HashSet<>(Arrays.asList("#java", "#programming")), LocalDate.of(2020, 04, 25)));
        tasks.add(new Task("11", "JUnit", CODING, LocalDate.of(2020, 04, 2), false, new HashSet<>(Arrays.asList("#java", "#programming")), LocalDate.of(2020, 04, 25)));
        tasks.add(new Task("12", "Generics", READING, LocalDate.of(2020, 04, 1), true, new HashSet<>(Arrays.asList("#java", "#programming", "#books", "#Homework")), LocalDate.of(2020, 04, 10)));
        tasks.add(new Task("13", "Hibernate", WRITING, LocalDate.of(2020, 05, 4), false, new HashSet<>(Arrays.asList("#java", "#programming")), LocalDate.of(2020, 05, 25)));
        tasks.add(new Task("14", "Maven", READING, LocalDate.of(2020, 05, 8), true, new HashSet<>(Arrays.asList("#java", "#programming", "#books", "#Self-learning")), LocalDate.of(2020, 05, 18)));
        tasks.add(new Task("15", "JDBC", READING, LocalDate.of(2020, 05, 4), false, new HashSet<>(Arrays.asList("#java", "#programming","#books")), LocalDate.of(2020, 05, 25)));
        tasks.add(new Task("16", "JDBC", WRITING, LocalDate.of(2020, 05, 4), false, new HashSet<>(Arrays.asList("#java", "#programming")), LocalDate.of(2020, 05, 25)));

//        1. Найти все задачи типа READING, отсортированные по дате создания.
        System.out.println("---------------1-------------");
        Collection<String> readingTasksSortedByDate = tasks
                .stream()
                .filter(task -> task.getType() == READING)
                .sorted(Comparator.comparing(Task::getCreatedOn))
                .map(task -> task.getTitle() + " created on " + task.getCreatedOn())
                .collect(Collectors.toList());

        readingTasksSortedByDate.forEach(System.out::println);

//        2. Получить список задач, которые уникальны (уникальность проверяйте по полям title и type - и сделайте это с помощью аннотаций Lombok - самим метод equals и hashCode переопределять не нужно).
//
        System.out.println("---------------2-------------");
        Collection<String> uniqueTasks = tasks
                .stream()
                .filter(distinctByKey(UniqueKey::new))
                .map(task -> task.getType()+": "+ task.getTitle()+" created on "+task.getCreatedOn())
                .collect(Collectors.toList());

        uniqueTasks.forEach(System.out::println);


//        3. Найти пять первых задач типа READING, отсортированных по дате создания
        System.out.println("---------------3-------------");
        Collection<String> readingTasksSortedByDateFirst5 = readingTasksSortedByDate
                .stream()
                .limit(5)
                .collect(Collectors.toList());

        readingTasksSortedByDateFirst5.forEach(System.out::println);

//        4. Посчитать количество задач, у которых type - CODING.
        System.out.println("---------------4-------------");
        int codingQuantity = (int) tasks.
                stream()
                .filter(task -> task.getType() == CODING)
                .count();

        System.out.println(codingQuantity);

//        5. Проверить, у всех ли задач, у которых стоит type READING, есть тег #books
        System.out.println("---------------5-------------");
        boolean containsTagBooks = tasks
                .stream()
                .filter(task -> task.getType() == READING)
                .allMatch(task -> task.getTags().contains("#books"));

        System.out.println(containsTagBooks);

//        6. Собрать все заголовки задач в единую строку (используйте разделитель ***)
        System.out.println("---------------6-------------");
        String allTitles = tasks
                .stream()
                .map(task -> task.getTitle())
                .collect(Collectors.joining("***"));

        System.out.println(allTitles);
    }


}
