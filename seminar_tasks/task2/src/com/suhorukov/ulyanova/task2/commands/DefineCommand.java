package com.suhorukov.ulyanova.task2.commands;

import com.suhorukov.ulyanova.task2.Command;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 06.07.13
 * Time: 0:56
 * To change this template use File | Settings | File Templates.
 */
public class DefineCommand implements Command  {
    @Override
    public void execute(Stack<Double> v, String userInput, HashMap<String, Double> defined) {

        defined.put(userInput, new Double(userInput) );
    }
}
