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

    private Command calcCmd; //concrete commands
    private final HashMap<String, Command> commandMap;  //Contains all available calculator's commands
    private HashMap <String, Double> defined;    //Contains user defined variables like x = 10.5
    private Stack<Double> st;

    public Calc(String fileName) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        this.calcCmd = null;
        this.commandMap = CommandFabric.setCommands(fileName); //fileName contains all possible calc's commands
        this.st = new Stack<>();
        this.defined = new HashMap<>();
    }

    public void calculate (String[] strCommand) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {

        for (int i=0; i<strCommand.length; i++)  {
            if (commandMap.containsKey(strCommand[i])) {
                calcCmd = commandMap.get(strCommand[i]);
                if (strCommand[i].equals("PUSH")) {
                    i++;

                }
                /*if (strCommand[i].equals("DEFINE")) {
                    i++;
                    calcCmd.execute(st, strCommand[i+1], defined);
                } */

                calcCmd.execute(st, strCommand[i], defined);
            }
        }

        System.out.println(st);

    }


}
