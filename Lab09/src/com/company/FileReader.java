package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
    private Scanner scanner;
    public DefaultListModel<Student> readFile(File file) throws FileNotFoundException {
        scanner = new Scanner(file);
        DefaultListModel<Student> result = new DefaultListModel<>();
        while(scanner.hasNext()){
            Student student = new Student();
            student.setId(scanner.nextInt());
            student.setSurname(scanner.next());
            student.setCourse(scanner.nextInt());
            student.setGroup(scanner.nextInt());
            result.addElement(student);
        }
        return result;
    }
}
