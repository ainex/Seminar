package com.suhorukov.ulyanova.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
    private CommandFabric commandFabric;

    public Calc(String fileName) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        this.calcCmd = null;
        this.commandFabric = new CommandFabric(fileName);
        /* fileName contains all possible calc's commands */
        this.commandMap = commandFabric.setCommands();
        this.st = new Stack<>();
        this.defined = new HashMap<>();
    }

    public Calc() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        this("commands.properties") ;
    }

    public void calculate (String [] strCommand) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        String [] subStrCommand = new String[10];

        for (int i=0, j=0; i<strCommand.length; i++)  {

            calcCmd = commandFabric.getCommand(strCommand[i]);
            if (calcCmd !=null){
                j=0;
                while (((i+1)<strCommand.length )&&(commandFabric.getCommand(strCommand[i+1]) == null))  {
                    i++;
                    subStrCommand[j]=strCommand[i];
                   j++;
                }

            }

            try {
                calcCmd.execute(st, subStrCommand, defined);
            } catch (Exception e) {
                System.out.println("Incorrect data input");
                e.printStackTrace();
            }
        }

        System.out.println(st);   //Prints stack after each line command

    }


}
