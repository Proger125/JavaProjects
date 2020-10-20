package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MatrixReader reader = new MatrixReader();
        try {
            Matrix matrix = reader.ReadMatrixFromFile("./resources/Matrix.txt");
            Matrix resultMatrix = matrix.Gauss(3);
            resultMatrix.MatrixOut();
            ArrayList<Double> list = matrix.ScalarMult();
            System.out.println("The scalar multiplications of rows and columns with min and max elements");
            for (Double aDouble : list) {
                System.out.print(aDouble + " ");
            }
        }catch (IOException exception) {
            System.out.println(exception.getMessage());
        }catch (ArithmeticException exception){
            System.out.println(exception.getMessage());
        }
    }
}
