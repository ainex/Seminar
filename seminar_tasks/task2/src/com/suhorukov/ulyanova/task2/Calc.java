package com.suhorukov.ulyanova.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 05.07.13
 * Time: 9:03
 * To change this template use File | Settings | File Templates.
 */
public class Calc {

    private Command calcCmd;
    private HashMap<String, Command> commandMap;  //Contains calculator's commands
    private HashMap <String, Double> defined;    //Contains user defined variables


    public Calc(String fileName) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        this.commandMap = CommandFabric.setCommands(fileName); //fileName contains all possible calc's commands
        System.out.println(commandMap);

        this.defined = new HashMap<>();
    }

    public Stack<Double> execute (String [] strCommand, Stack<Double> st) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {

       System.out.println(commandMap);


        for (int i=0; i<strCommand.length; i++)  {
            if (commandMap.containsKey(strCommand[i])) {
                System.out.println(strCommand[i]);
                calcCmd = commandMap.get(strCommand[i]);
                if (strCommand[i].equals("PUSH")) i++;
                calcCmd.execute(st, strCommand[i], defined);
            }
        }

        System.out.println(st);
    return st;
    }


}
