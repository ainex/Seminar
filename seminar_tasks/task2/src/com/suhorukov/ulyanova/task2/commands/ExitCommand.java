package com.suhorukov.ulyanova.task2.commands;

import com.suhorukov.ulyanova.task2.Command;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 03.07.13
 * Time: 19:35
 * To change this template use File | Settings | File Templates.
 */
public class ExitCommand implements Command {

    @Override
    public void execute (Stack<Double> v, String userInput, HashMap<String, Double> defined){
     System.exit(0);
    }
}
