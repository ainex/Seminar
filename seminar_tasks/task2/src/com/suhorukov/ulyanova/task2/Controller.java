package com.suhorukov.ulyanova.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 06.07.13
 * Time: 0:03
 * To change this template use File | Settings | File Templates.
 */
public class Controller {
    private static String inputStrCommand;
    private static String[] strCommand;
    private static BufferedReader br;
    private static Calc stackCalc;



    public static void getCommands (String[] source) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        stackCalc = new Calc("commands.properties");
        String cmdFile="";
        if (source.length!=0) cmdFile=source[0];
        System.out.println(cmdFile);
        if ("".equals(cmdFile)) {
            System.out.println("Enter expression for calculation:");
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        else {
            br = new BufferedReader(new FileReader(cmdFile));
        }

        while ((inputStrCommand =br.readLine())!=null && inputStrCommand.length()!=0) {

            inputStrCommand = inputStrCommand.trim();
            inputStrCommand = inputStrCommand.replaceAll("\\s+"," ");
            strCommand = inputStrCommand.split(" ");
            stackCalc.calculate(strCommand);
        }

    }
}
