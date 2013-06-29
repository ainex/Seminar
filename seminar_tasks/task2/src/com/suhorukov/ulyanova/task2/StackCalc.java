package com.suhorukov.ulyanova.task2;

import com.suhorukov.ulyanova.task2.commands.*;

import java.util.*;
/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 29.06.13
 * Time: 8:15
 * To change this template use File | Settings | File Templates.
 */

public class StackCalc {

    public static void main(String[] args) {
        Stack<Double> st;
        st = new Stack<Double>();
        Command pushCmd = new PushCommand();
        pushCmd.execute(st, "5.5");
        pushCmd.execute(st, "11");
        pushCmd.execute(st, "4");
        System.out.println(st);


        Command sumCmd = new SumCommand();  // (Why not SumCommand?? ) sumCmd = new SumCommand();
        sumCmd.execute(st,"");
        System.out.println(st);

        Command sqrtCmd = new SqrtCommand();
        sqrtCmd.execute(st,"");
        System.out.println(st);

        Command subCmd = new SubCommand();
        subCmd.execute(st,"");
        System.out.println(st);

        pushCmd.execute(st, "4");
        System.out.println(st);

        Command multCmd = new MultCommand();
        multCmd.execute(st,"");
        System.out.println(st);

        pushCmd.execute(st, "2");
        System.out.println(st);

        Command devCmd = new DevCommand();
        devCmd.execute(st,"");
        System.out.println(st);

    }


}
