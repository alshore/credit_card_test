package com.clara;

import java.util.Scanner;

// Created by we4954cp on 8/31/2016.

public class CreditCard {

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Ask user for credit card number. store number as a String.
        System.out.println("Please enter the credit card number, digits only:");
        String ccNumber = stringScanner.nextLine();
        boolean isValid = isValidCreditCard(ccNumber);

        if (isValid) {
            System.out.println("This seems to be a valid credit card number");
        } else {
            System.out.println("This is **not** a valid credit card number.");
        }

        stringScanner.close();
    }

    public static boolean isValidCreditCard(String cc) {

        char[] ccArray = cc.toCharArray();
        String add = "";
        int total = 0;

        if (ccArray.length == 16 && ccArray[0] == '4') {
            for (int i = 0; i < ccArray.length; i++) {
                if (i % 2 == 0) {
                    if (ccArray[i] == '1') add += 2;
                    else if (ccArray[i] == '2') add += 4;
                    else if (ccArray[i] == '3') add += 6;
                    else if (ccArray[i] == '4') add += 8;
                    else if (ccArray[i] == '5') add += 1;
                    else if (ccArray[i] == '6') add += 3;
                    else if (ccArray[i] == '7') add += 5;
                    else if (ccArray[i] == '8') add += 7;
                    else if (ccArray[i] == '9') add += 9;
                } else add += ccArray[i];
            }
            char[] numsToAdd = add.toCharArray();
            for (int i = 0; i < numsToAdd.length; i++) {
                total += numsToAdd[i] - 48;
            }
            return total % 10 == 0;
        } else return false;
    }
}
