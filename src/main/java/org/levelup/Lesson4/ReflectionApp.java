package org.levelup.Lesson4;

public class ReflectionApp {


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        FilesProcessing filesProcessing = new FilesProcessing();
        filesProcessing.createObjects("ru.levelup.lessons");
    }


}
