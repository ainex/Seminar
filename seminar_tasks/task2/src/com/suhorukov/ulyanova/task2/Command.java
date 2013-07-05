package com.suhorukov.ulyanova.task2;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 29.06.13
 * Time: 8:23
 * To change this template use File | Settings | File Templates.
 */
public interface Command {
    void execute(Stack<Double> v, String userInput, HashMap<String, Double> defined);
}
