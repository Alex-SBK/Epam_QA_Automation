// Print a given number of random numbers
// with and without a new line
package com.epam.automation.alex_sbk;

import java.util.Scanner;

public class Java_fundamentals_MainTask3 {
    public static void main(String[] args) {
        Scanner sc;
        int num = 0;
        String answer;
        boolean breaksIsNecessary = false;

        do {
            System.out.print("Please enter valid (positive and > 0) amount of numbers! ");
            sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
            } else {
                System.out.print("That not a number! Please enter valid amount of numbers! ");
                sc.next();
            }
        } while (num <= 0);


        System.out.print("Do you need line breaks between the numbers? yes/no ");
        sc.nextLine(); // Consume newline left-over

        do {
            answer = sc.nextLine();
            switch (answer) {
                case "yes":
                    breaksIsNecessary = true;
                    break;
                case "no":
                    breaksIsNecessary = false;
                    break;
                default:
                    System.out.println("type exactly 'yes' or 'no'");
            }

        } while (!((answer.equals("yes")) || (answer.equals("no"))));

        sc.close();

        System.out.printf("\n----\nSo.. Your number is : %d \n", num);
        System.out.printf("Breaks is necessary : %s \n----\n", answer);
        String separator;
        for (int i = 0; i < num; i++) {
            separator = (breaksIsNecessary) ? "\n" : " ";
            System.out.printf("%d" + separator,(int) ( Math.random() * 1000 ));
        }

        System.out.print("\n"); //просто для красоты

    }

}