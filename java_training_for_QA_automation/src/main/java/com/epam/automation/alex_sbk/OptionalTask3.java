package com.epam.automation.alex_sbk;

import java.util.Scanner;

public class OptionalTask3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.println();
        do {
            System.out.print("Enter how many elements do you want: ");
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

        //calculating average length
        int sum = 0;
        for (int value : myArray
        ) {
            sum += getLengthOfNumber(value);
        }

        int average = sum / number;
        System.out.printf("\n----\nThe average length is: %d\n", average);
        System.out.println("\nLengths of next numbers are greater than average value:\n");
        for (int value : myArray
        ) {
            if (getLengthOfNumber(value) > average) {
                System.out.printf("Number is: %d, " +
                        "number length is: %d\n", value, getLengthOfNumber(value));
            }
        }


    }

    public static int getLengthOfNumber(int num) {
        int count = (num == 0) ? 1 : 0;
        while (num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }

}
