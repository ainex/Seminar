package com.suhorukov.ulyanova.task2.commands;

import com.suhorukov.ulyanova.task2.Command;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 29.06.13
 * Time: 18:27
 * To change this template use File | Settings | File Templates.
 */
public class DevCommand implements Command {
    private Double dividend;
    private Double divisor;

    @Override
    public void execute (Stack<Double> v, String userInput, HashMap <String, Double> defined){
        divisor = v.pop();
        dividend = v.pop();
        v.push(dividend/divisor);
    }
}
