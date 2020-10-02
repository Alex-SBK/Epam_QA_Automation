package com.epam.automation.alex_sbk;

public class Java_fundamentals_MainTask4 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments found. exit..");
            return;
        }
        int summa = 0;
        int multiplication = 1;

        for (String argument : args
        ) {
            try {
                summa = summa + Integer.parseInt(argument.trim());
                multiplication = multiplication * Integer.parseInt(argument.trim());
            } catch (NumberFormatException nfe) {
                System.out.print("Try again! Not all arguments are integers!\nexit..\n");
                return;
            }
        }
        System.out.printf("Summa = %d\n", summa);
        System.out.printf("Multiplication = %d\n", multiplication);
    }
}
