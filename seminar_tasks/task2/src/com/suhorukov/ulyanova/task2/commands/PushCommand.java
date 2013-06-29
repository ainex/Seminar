package com.suhorukov.ulyanova.task2.commands;

import com.suhorukov.ulyanova.task2.Command;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 29.06.13
 * Time: 8:25
 * To change this template use File | Settings | File Templates.
 */
public class PushCommand implements Command {
    @Override
    public void execute(Stack<Double> v, String userInput) {

        v.push(new Double(userInput) );
    }
}
