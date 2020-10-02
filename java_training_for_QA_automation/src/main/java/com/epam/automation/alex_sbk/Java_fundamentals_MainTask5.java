// Enter a number from 1 to 12. Output to the console the name
// of the month corresponding to the given date.
// Check the correctness of entering numbers.
package com.epam.automation.alex_sbk;

import java.util.Scanner;

public class Java_fundamentals_MainTask5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.println("Please enter number of month!");
            while (!sc.hasNextInt()) {
                System.out.println("That not a number!\nPlease enter number of month!");
                sc.next(); // this is important!
            }
            number = sc.nextInt();
            if ((number <= 0) || (number > 12)) {
                System.out.println("The number must be a non-negative integer and no greater than 12!");
            }
        } while ((number <= 0) || (number > 12));

        sc.close();

        String[] mouths = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December",
        };

        System.out.printf("Month №%d is %s \n", number, mouths[number - 1]);

    }
}
