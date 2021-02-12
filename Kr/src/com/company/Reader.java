package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    private Scanner scanner;
    public PupilCollection<Pupil> readStudentData(File file) throws FileNotFoundException {
        scanner = new Scanner(file);
        PupilCollection<Pupil> collection = new PupilCollection<>();
        while(scanner.hasNext()){
            String surname = scanner.next();
            String institution = scanner.next();
            double institutionRating = scanner.nextDouble();
            int course = scanner.nextInt();
            double averageScore = scanner.nextDouble();
            Pupil pupil = new Student(surname, institution, institutionRating, averageScore, course);
            collection.addToCollection(pupil);
        }
        return collection;
    }
    public PupilCollection<Pupil> readSchoolarData(File file) throws FileNotFoundException {
        scanner = new Scanner(file);
        PupilCollection<Pupil> collection = new PupilCollection<>();
        while(scanner.hasNext()){
            String surname = scanner.next();
            String institution = scanner.next();
            double institutionRating = scanner.nextDouble();
            double averageScore = scanner.nextDouble();
            int schoolarClass = scanner.nextInt();
            Behavior behavior = Behavior.valueOf(scanner.next());

            Pupil pupil = new Schoolar(surname, institution, institutionRating, averageScore, schoolarClass, behavior);
            collection.addToCollection(pupil);
        }
        return collection;
    }
}
