package org.levelup.Lesson4;

import java.lang.reflect.Field;
import java.util.Random;

public class RandomIntAnnotationProcess {
    public static Object process(Object object) throws IllegalAccessException {
        Class<?> objClass = object.getClass();
        Field[] declaredFields = objClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            RandomInt annotation = declaredField.getAnnotation(RandomInt.class);
            if (annotation != null) {
                int max = annotation.max();
                int min = annotation.min();
                Random random =  new Random();
                int result = random.nextInt(max-min+1)+min;
                declaredField.setAccessible(true);
                declaredField.set(object, result);
            }
        }
return object;
    }
}
