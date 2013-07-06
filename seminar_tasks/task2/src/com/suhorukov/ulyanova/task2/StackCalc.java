package com.suhorukov.ulyanova.task2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 29.06.13
 * Time: 8:15
 * To change this template use File | Settings | File Templates.
 */

public class StackCalc {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        BufferedReader br;
        String cmdFile="";
        if (args.length!=0) cmdFile=args[0];
            System.out.println(cmdFile);
        if ("".equals(cmdFile)) {
            System.out.println("Enter expression for calculation:");
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        else {
            br = new BufferedReader(new FileReader(cmdFile));
        }

        Controller controller = new Controller(br);

        controller.calculate();
    }

} //Class
