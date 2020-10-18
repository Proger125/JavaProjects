package com.company;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MatrixReader {
    private Scanner scanner;

    public Matrix ReadMatrixFromFile(String path) throws IOException {
        Path filepath = Paths.get(path);
        scanner = new Scanner(filepath);
        int n, m;
        if (scanner.hasNextInt()){
            m = scanner.nextInt();
        }else {
            throw new IOException("First string in your file should contain the amount of rows as first parameter");
        }
        if (scanner.hasNextInt()){
            n = scanner.nextInt();
        }else{
            throw new IOException("First string in your file should contain the amount of columns as second parameter");
        }
        double[][] array = new double[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (scanner.hasNextDouble()){
                    array[i][j] = scanner.nextDouble();
                }else{
                    throw new IOException("Your file should contain " + (n * m) + " elements");
                }
            }
        }
        if (scanner.hasNext()){
            throw new IOException("Your file should contain " + (n * m) + " elements");
        }
        scanner.close();
        return new Matrix(array);
    }
}
