// Find the maximum element in a matrix and remove all
// rows and columns from the matrix that contain it

package com.epam.automation.alex_sbk;

import java.util.Scanner;


public class java_fundamentals_OptionalTask2_4 {
    public static void main(String[] args) {
        //input size of the matrix
       int size = input("Enter matrix dimension, please: ", 3, 120);
        //input range of values
        int range = input("Enter absolute value of matrix elements ", 1, 999);
        System.out.printf("Matrix: %d x %d:\nValues: from -%d to %d\n", size, size, range, range);
        //filling the array
        int[][] myArray = fillArray(size, range);
        //get max value from 2 dimensional array
        int maximum = getMaxValue(myArray);
        //boolean array according
        //should it row or column to be removed or not
        //means contain it maximum value or not
        boolean[] rows = new boolean[size];
        boolean[] columns = new boolean[size];

        //fill data about rows and columns with elements which contain max value:
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                if (myArray[i][j] == maximum) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        PrintArrayWithHighLight(myArray, rows, columns, maximum);
        System.out.printf("Max value is: %d\n", maximum);
        System.out.println("result Matrix:");
        myArray = getNewArrayWithoutColumnsAndRows(myArray,columns,rows);
        PrintArray(myArray);
    }

    //-------------------------------------------------------------------------
    private static void PrintArray(int[][] arr) {
        //just print a 2D array to console
        if ((arr.length == 0) || (arr[0].length == 0)) {
            System.out.println("All elements has been deleted....");
            return;
        }

        System.out.print("______");
        for (int i = 0; i < arr[0].length - 1; i++) {
            System.out.print("________");
        }
        System.out.print("\n");

        for (int[] ints : arr) {
            for (int j = 0; j < ints.length; j++) {
                System.out.printf("%4d", ints[j]);
                if (j < ints.length - 1) {
                    System.out.print("\t");
                }
            }

            System.out.print(" ");
            System.out.print("|\n");
        }

        System.out.print("______");
        for (int i = 0; i < arr[0].length - 1; i++) {
            System.out.print("________");
        }
        System.out.print("\n");
    }

    //-------------------------------------------------------------------------
    private static void PrintArrayWithHighLight(int[][] arr, boolean[] rows, boolean[] columns, int maximum) {
        // print a 2D array to console with highlight the elements with maximum value
        // and rows and columns which contain that value.
        // elements that remain un highlight will not be deleted.
        String color = "\u001B[0m";
        System.out.print("______");
        for (int i = 0; i < arr[0].length - 1; i++) {
            System.out.print("________");
        }
        System.out.print("\n");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == maximum) {
                    color = "\u001B[42m\u001B[31m";
                } else {
                    color = (rows[i] || columns[j]) ? "\u001B[30m\u001B[44m" : "\u001B[0m";
                }
                System.out.printf(color + "%4d" + "\u001B[0m", arr[i][j]);
                if (j < arr[i].length - 1) {
                    System.out.print(color + "\t");
                }
            }

            System.out.print(color + " ");
            System.out.print("\u001B[0m" + "|\n");
        }

        System.out.print("______");
        for (int i = 0; i < arr[0].length - 1; i++) {
            System.out.print("________");
        }
        System.out.print("\n");
    }


    //-------------------------------------------------------------------------
    private static int[][] getNewArrayWithoutColumnsAndRows(int[][] arr, boolean[] columns, boolean[] rows) {
        // go through all the elements of the original array.
        // and only if the element is not in the deleted column or row,
        // it will be added to the resulting array.
        int newColumnAmount = 0;
        int newRowsAmount = 0;
        for (int i = 0; i < columns.length; i++) {
            if (!columns[i]) {
                newColumnAmount++;
            }
            if (!rows[i]) {
                newRowsAmount++;
            }

        }
        int[][] result = new int[newRowsAmount][newColumnAmount];
        int columnCounter;
        int rowCounter = 0;
        //deleteColumns
        for (int i = 0; i < arr.length; i++) {
            columnCounter = 0;
            if (!rows[i]) {
                for (int j = 0; j < arr[i].length; j++) {

                    if (!columns[j]) {
                        result[rowCounter][columnCounter] = arr[i][j];
                        columnCounter++;
                    }
                }
                rowCounter++;
            }
        }
        return result;
    }




    //-------------------------------------------------------------------------
    private static int getMaxValue(int[][] arr) {
        // found the maximum value in 2D array
        int maxResult = arr[0][0];
        for (int[] i : arr
        ) {
            for (int j : i
            ) {
                maxResult = Math.max(maxResult, j);
            }

        }
        return maxResult;
    }

    //--------------------------------------------------------------
    private static int input(String message, int min, int max) {
        // input a value with checking the input
        // for entering the interval
        // and show a message
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.printf(message + "from %d to %d ", min, max);
            while (!sc.hasNextInt()) {
                System.out.printf("That not a number!\n" + message +
                        "from %d to %d\n ", min, max);
                sc.next(); // this is important!
            }
            num = sc.nextInt();
            if (num < min) {
                System.out.printf("The number must be equals or greater than %d! \n", min);
            }
            if (num > max) {
                System.out.printf("The number must be equals or greater than %d! \n", max);
            }
        } while ((num < min) || (num > max));

        return num;
    }

    //--------------------------------------------------------
    private static int[][] fillArray(int size, int range) {
        // creating and filling an array with
        // random numbers included in the interval

        int[][] arr;
        int minus;
        arr = new int[Math.abs(size)][Math.abs(size)];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                minus = ((int) (Math.random() * 2) == 1) ? (1) : (-1);
                arr[i][j] = (int) (Math.random() * (range + 1) * minus);
            }
        }
        return arr;
    }
}
