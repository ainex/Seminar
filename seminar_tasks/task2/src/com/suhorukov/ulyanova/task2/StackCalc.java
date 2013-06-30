package com.suhorukov.ulyanova.task2;

import com.suhorukov.ulyanova.task2.commands.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 29.06.13
 * Time: 8:15
 * To change this template use File | Settings | File Templates.
 */

public class StackCalc {

    public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        Stack<Double> st;
        st = new Stack <Double>();
        Command calcCmd;
        HashMap<String, Command> commandMap;
        commandMap = CommandFabric.setCommands("");
        System.out.println(commandMap);

        System.out.println("Enter expression for calculation:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInputString = br.readLine();

        userInputString=userInputString.trim();
        String[] strCommand = userInputString.split(" ");
        for (int i=0; i<strCommand.length; i++)  {
            if (commandMap.containsKey(strCommand[i])) {
                System.out.println(strCommand[i]);
                calcCmd = commandMap.get(strCommand[i]);
                if (strCommand[i].equals("PUSH")) i++;
                calcCmd.execute(st, strCommand[i]);
            }
            else {
                System.out.println("Ignore");
            }
        }

        System.out.println(st);
    }


}
