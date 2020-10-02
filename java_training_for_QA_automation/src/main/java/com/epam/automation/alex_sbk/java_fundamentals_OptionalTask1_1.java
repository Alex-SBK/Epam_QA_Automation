package com.epam.automation.alex_sbk;

import java.util.Scanner;


public class java_fundamentals_OptionalTask1_1 {
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
            if (number <= 0)  {
                System.out.println("The number must be a non-negative integer! ");
            }
        } while (number <= 0);

        int[] myArray = new int[number];
        for (int i = 0; i <= (number - 1); i++) {
            System.out.printf("Enter element #%d: ",i+1);
            while (!sc.hasNextInt()) {
                System.out.printf("Oops!\nPlease enter valid number!" +
                        "\nEnter element\t№%d: ",i+1);
                sc.next(); // this is important!
            }
            myArray[i] = sc.nextInt();
        }
        int shortest = myArray[0];
        int longest = myArray[0];

        for (int i = 1; i < (number - 1); i++) {
            if (getLengthOfNumber(myArray[i]) < getLengthOfNumber(shortest)) {
                shortest = myArray[i];
            }
            if (getLengthOfNumber(myArray[i]) > getLengthOfNumber(longest)) {
                longest = myArray[i];
            }
        }
        System.out.printf("\n----\nThe shortest number is\t%d\n",shortest);
        System.out.printf("The longest number is\t%d\n----\n",longest);
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

