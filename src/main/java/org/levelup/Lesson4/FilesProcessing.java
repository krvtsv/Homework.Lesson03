package org.levelup.Lesson4;

import java.io.File;
import java.util.ArrayList;

public class FilesProcessing {

    public void createObjects(String packageName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        File workingDirectory = new File("src\\main\\java\\" + packageName.replace('.', '\\'));

        ArrayList<Class> classes = processFiles(workingDirectory,new ArrayList<>());

        for (Class aClass : classes) {
            Object o = aClass.newInstance();
            System.out.println(o);
        }

    }
    public ArrayList<Class> processFiles(File workingDirectory, ArrayList<Class> classes) throws ClassNotFoundException {
        File[] folderEntries = workingDirectory.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                processFiles(entry, classes);
                continue;
            }
            classes.add(Class.forName(entry.toString().substring(14, entry.toString().lastIndexOf(".")).replace('\\', '.')));
        }

        return classes;
    }
}
