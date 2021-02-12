package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	PupilCollection<Pupil> collection = new PupilCollection<>();
	PupilCollection<Pupil> collection1 = new PupilCollection<>();
	try{
        Reader reader = new Reader();
        collection = reader.readStudentData(new File("res/Input1.txt"));
        ArrayList<Pupil> list = collection.averageScoreDecreaseSort();
        int duplicateStudents = collection.comparePupil(new Student("Ivanov", "BSU", 100, 9.5, 1));
        System.out.println(list.toString());
        System.out.println("Same students: " + duplicateStudents);
        Pair pair = collection.returnBestStudents();
        System.out.println(pair.first);
        System.out.println(pair.second);
        Double averageScore = collection.calculateAverageScoreInInstitution("BSU");
        System.out.println(averageScore);
        Reader reader1 = new Reader();
        collection1 = reader1.readSchoolarData(new File("res/Input2.txt"));
        Pair pair1 = collection1.returnBestStudents();
        System.out.println(pair1.first);
        System.out.println(pair1.second);
    }
	catch (Exception exception){
        System.out.println("Something wrong...");
    }

    }
}
