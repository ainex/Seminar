package com.suhorukov.ulyanova.task2.commands;

import com.suhorukov.ulyanova.task2.Command;

import java.util.HashMap;
import java.util.Map;
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
    public void execute(Stack<Double> v, String userInput, Map<String, Double> defined) {
        String [] forDef;
        forDef=userInput.split(" ");
        defined.put(forDef[0], new Double(forDef[1]));
        System.out.println(defined);
    }
}
