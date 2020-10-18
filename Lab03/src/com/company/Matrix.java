package com.company;

public class Matrix {
    // fields
    private double[][] data;
    private int m;
    private int n;
    private boolean isSquare;


    // properties
    public int GetM(){
        return m;
    }
    public void SetM(int value){
        this.m = value;
    }
    public int GetN(){
        return n;
    }
    public void SetN(int value){
        this.m = value;
    }
    public double GetElement(int i, int j){
        return data[i][j];
    }
    public void SetElement(int i, int j, double value){
        data[i][j] = value;
    }
    public boolean IsMatrixSquare(){
        return isSquare;
    }


    // methods
    public Matrix(){
        m = 0;
        n = 0;
        data = new double[m][n];
        isSquare = true;
    }
    public Matrix(int row, int col){
        m = row;
        n = col;
        data = new double[m][n];
        if (m == n){
            isSquare = true;
        }else{
            isSquare = false;
        }
    }
    public Matrix(double[][] array){
        m = array.length;
        n = array[0].length;
        data = array;
        if (n == m){
            isSquare = true;
        }else{
            isSquare = false;
        }
    }
    public Matrix(Matrix matrix){
        m = matrix.GetM();
        n = matrix.GetN();
        data = matrix.data;
        isSquare = matrix.IsMatrixSquare();
    }

}
