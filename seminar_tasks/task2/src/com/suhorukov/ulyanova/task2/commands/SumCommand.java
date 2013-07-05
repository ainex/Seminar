package com.suhorukov.ulyanova.task2.commands;

import com.suhorukov.ulyanova.task2.Command;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 29.06.13
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 */
public class SumCommand implements Command {
    public void execute(Stack<Double> v, String userInput, HashMap<String, Double> defined){

        v.push( v.pop()+v.pop() );

    }
}
