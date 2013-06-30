package com.suhorukov.ulyanova.task2.commands;

import com.suhorukov.ulyanova.task2.Command;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 30.06.13
 * Time: 20:10
 * To change this template use File | Settings | File Templates.
 */
public class PrintCommand implements Command {

    public void execute (Stack<Double> v, String userInput) {
        System.out.println(v.peek());
    }

}
