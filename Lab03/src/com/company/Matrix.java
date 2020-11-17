package com.company;

import java.util.ArrayList;

public class Matrix {
    // fields
    private final double[][] data;
    private int m;
    private int n;
    private final boolean isSquare;


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
        this.n = value;
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
        isSquare = m == n;
    }
    public Matrix(double[][] array){
        m = array.length;
        n = array[0].length;
        data = array;
        isSquare = n == m;
    }
    public Matrix(Matrix matrix){
        m = matrix.GetM();
        n = matrix.GetN();
        data = matrix.data;
        isSquare = matrix.IsMatrixSquare();
    }
    public Matrix gauss(int amountOfAnswerVectors) throws ArrayIndexOutOfBoundsException, ArithmeticException{
        if (amountOfAnswerVectors > this.m){
            throw new ArrayIndexOutOfBoundsException("The number of answer vectors is incorrect");
        }

        int size = this.m; // размерность матрицы левой части

        // прямой ход
        for (int k = 0; k < size; k++){
            double diagonalElement = data[k][k];
            if (diagonalElement == 0){
                throw new ArithmeticException("The determinant of your matrix = 0");
            }
            for (int i = 0; i < size + amountOfAnswerVectors; i++){
                data[k][i] = data[k][i] / diagonalElement;
            }
            for (int i = k + 1; i < size; i++){
                double K = data[i][k] / data[k][k];
                for (int j = 0; j < size + amountOfAnswerVectors; j++){
                    data[i][j] = data[i][j] - data[k][j] * K;
                }
            }
        }

        // обратный ход
        for (int k = size - 1; k > -1; k--){
            double diagonalElement = data[k][k];
            for (int i = size - 1 + amountOfAnswerVectors; i > -1; i--){
                data[k][i] = data[k][i] / diagonalElement;
            }
            for (int i = k - 1; i > -1; i--){
                double K = data[i][k] / diagonalElement;
                for (int j = size - 1 + amountOfAnswerVectors; j > -1; j--){
                    data[i][j] = data[i][j] - data[k][j] * K;
                }
            }
        }
        Matrix resultMatrix = new Matrix(this.m, amountOfAnswerVectors);
        for (int i = 0; i < resultMatrix.m; i++){
            for (int j = 0; j < resultMatrix.n; j++){
                resultMatrix.SetElement(i,j, data[i][this.n - amountOfAnswerVectors + j]);
            }
        }
        return resultMatrix;
    }
    public void MatrixOut(){
        for (int i = 0; i < this.m; i++){
            for (int j = 0; j < this.n; j++){
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
    public ArrayList<Double> ScalarMult(){
        if (isSquare){
            ArrayList<Integer> indexRows = MinElementsRows();
            ArrayList<Integer> indexCols = MaxElementsCols();
            ArrayList<Double> resultList = new ArrayList<Double>();
            for (Integer indexRow : indexRows) {
                for (Integer indexCol : indexCols) {
                    double result = 0.0;
                    for (int i = 0; i < m; i++) {
                        result += data[indexRow][i] * data[i][indexCol];
                    }
                    resultList.add(result);
                }
            }

            return  resultList;
        }else{
            throw new ArithmeticException("Your matrix should me square!!!");
        }

    }
    private ArrayList<Integer> MinElementsRows(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        double minElement = data[0][0];
        for (double[] datum : data) {
            for (int j = 0; j < data[0].length; j++) {
                if (datum[j] < minElement) {
                    minElement = datum[j];
                }
            }
        }
        list = AddToArrayListIfEqualTo(minElement);
        return list;
    }
    private ArrayList<Integer> MaxElementsCols(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        double maxElement = data[0][0];
        for (double[] datum : data) {
            for (int j = 0; j < data[0].length; j++) {
                if (datum[j] > maxElement) {
                    maxElement = datum[j];
                }
            }
        }
        list = AddToArrayListIfEqualTo(maxElement);
        return list;
    }
    private ArrayList<Integer> AddToArrayListIfEqualTo(double element){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (double[] datum : data) {
            for (int j = 0; j < data[0].length; j++) {
                if (datum[j] == element) {
                    list.add(j);
                }
            }
        }
        return list;
    }
}
