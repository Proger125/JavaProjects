package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MatrixReader reader = new MatrixReader();
        try {
            Matrix matrix = reader.ReadMatrixFromFile("./resources/Matrix.txt");
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
