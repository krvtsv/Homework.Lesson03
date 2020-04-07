package org.levelup.Lesson4;

import java.io.File;
import java.util.ArrayList;

public class FilesProcessing {

    public void createObjects(String packageName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        File workingDirectory = new File("src\\main\\java\\" + packageName.replace('.', '\\'));

        ArrayList<Class> classes = processFiles(workingDirectory, new ArrayList<>());

        for (Class aClass : classes) {
            if (aClass.getSuperclass() == Object.class) {
                Object o = aClass.newInstance();
                System.out.println(o);
            }
        }

    }

    public ArrayList<Class> processFiles(File workingDirectory, ArrayList<Class> classes) throws ClassNotFoundException {
        File[] folderEntries = workingDirectory.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                processFiles(entry, classes);
                continue;
            }
            if (getFileExtension(entry).equals("java"))
                classes.add(Class.forName(entry.toString().substring(14, entry.toString().lastIndexOf(".")).replace('\\', '.')));
        }

        return classes;
    }

    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }
}
