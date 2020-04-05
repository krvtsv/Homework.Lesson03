package org.levelup.Lesson4;

import java.io.File;
import java.util.ArrayList;
import org.levelup.Lesson4.FilesProcessing;

public class ReflectionApp {


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        FilesProcessing filesProcessing = new FilesProcessing();
        filesProcessing.createObjects("ru.levelup.lessons");
    }


}
