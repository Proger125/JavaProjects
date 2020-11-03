package com.company;

public class Human implements Comparable<Human>{
    private String name;
    private int age;
    Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Human o) {
        return Integer.valueOf(age).compareTo(o.age);
    }
    public String toString(){
        return this.name;
    }
}
