package com.suhorukov.ulyanova.task1;

import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 29.06.13
 * Time: 7:53
 * To change this template use File | Settings | File Templates.
 */
public class GuessNumber {

    static int x; //static variable
    public static void main (String args[]) {
        int triesNumber=6;
        System.out.println("Guess number from 0 to 100");

        Random random = new Random();
        int number = random.nextInt(101);
        System.out.println("I set" + number);
        Scanner scanner = new Scanner(System.in);
        int i;
        while (triesNumber>0) {
            System.out.println("Enter your number:");
            i = scanner.nextInt();
            if (i==number) {
                System.out.println("You guess!");
                break;
            }
            if (i>number) {
                System.out.println("My number is less");
            }
            else {
                System.out.println("My number is bigger");
                }
            triesNumber--;

        }
    }
}