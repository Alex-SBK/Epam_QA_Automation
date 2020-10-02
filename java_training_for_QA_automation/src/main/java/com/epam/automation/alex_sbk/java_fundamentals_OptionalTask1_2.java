package com.epam.automation.alex_sbk;

import java.util.Scanner;


public class java_fundamentals_OptionalTask1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.println();
        do {
            System.out.print("Enter how many elements you want: ");
            while (!sc.hasNextInt()) {
                System.out.println("That not a number!\nPlease enter an integer value! :");
                sc.next(); // this is important!
            }
            number = sc.nextInt();
            if (number <= 0) {
                System.out.println("The number must be a non-negative integer! ");
            }
        } while (number <= 0);

        int[] myArray = new int[number];
        for (int i = 0; i <= (number - 1); i++) {
            System.out.printf("Enter element №%d: ", i + 1);
            while (!sc.hasNextInt()) {
                System.out.printf("Oops!\nPlease enter valid number!" +
                        "\nEnter element\t№%d: ", i + 1);
                sc.next(); // this is important!
            }
            myArray[i] = sc.nextInt();
        }

        System.out.println("\n");
        for (int j = number - 1; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                if (getLengthOfNumber(myArray[i]) > (getLengthOfNumber(myArray[i + 1]))) {
                    swap(myArray, (i + 1), i);
                }
            }
        }

        for (int g = 0; g < number; g++) {
            System.out.print(" " + myArray[g]);
        }
        System.out.println("\n");

    }

    public static int getLengthOfNumber(int num) {
        int count = (num == 0) ? 1 : 0;
        while (num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}