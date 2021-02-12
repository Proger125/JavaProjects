package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PupilCollection<T extends Pupil> {
    private ArrayList<T> data;

    public PupilCollection(){
        data = new ArrayList<T>();
    }
    public ArrayList<T> averageScoreDecreaseSort(){
        return (ArrayList<T>) this.data.stream().sorted(Comparator.comparingDouble(Pupil::getAverageScore).reversed()).collect(Collectors.toList());
    }
    public void addToCollection(T pupil){
        data.add(pupil);
    }
    public int comparePupil(Pupil pupil){
        int counter = 0;
        for (int i = 0; i < data.size(); i++){
            if (data.get(i).equals(pupil)){
                counter++;
            }
        }
        return counter;
    }
    public Pair returnBestStudents(){
        ArrayList<Pupil> list = (ArrayList<Pupil>) data.stream().sorted((a, b) ->{
            if (!b.getAverageScore().equals(a.getAverageScore())){
                return b.getAverageScore().compareTo(a.getAverageScore());
            }else{
                return a.getSurname().compareTo(b.getSurname());
            }
        }).limit(2).collect(Collectors.toList());
        Pair pair = new Pair();
        pair.first = list.get(0);
        pair.second = list.get(1);
        return pair;
    }
    public Double calculateAverageScoreInInstitution(String institution){
        ArrayList<Pupil> list = (ArrayList<Pupil>) data.stream().filter(a -> a.getEducationalInstitution().equals(institution)).collect(Collectors.toList());
        Double score = 0.0;
        int counter = 0;
        for (Pupil pupil : list) {
            score += pupil.getAverageScore();
            counter++;
        }
        return score / counter;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < data.size(); i++){
            result += data.get(i).toString();
            result += "\n";
        }
        return result;
    }
}
