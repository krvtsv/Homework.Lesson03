package org.levelup.Lesson8_Streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;


@Data
public class UniqueKey {

    private final String title;
    private final TaskType type;

    public UniqueKey(Task task)
    {
        this.title = task.getTitle();
        this.type = task.getType();
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t ->  seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}

