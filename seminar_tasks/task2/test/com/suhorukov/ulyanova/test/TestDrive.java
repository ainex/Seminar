package com.suhorukov.ulyanova.test;

import com.suhorukov.ulyanova.task2.Calc;
import com.suhorukov.ulyanova.task2.Command;
import com.suhorukov.ulyanova.task2.CommandFabric;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Stack;


/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 03.07.13
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
public class TestDrive extends TestCase {
    private HashMap<String, Command> commandMap;
    private Stack<Double> st;
    private Command calcCmd;
    private HashMap <String, Double> def;
    private CommandFabric fabric;
    private String[] strCommand;

    public void setUp() throws Exception {

    }

    public void testPush () throws Exception {
        fabric = new CommandFabric("commands.properties");

        commandMap = fabric.setCommands();
        st = new Stack <>();
        def = new HashMap<>();

        calcCmd = commandMap.get("PUSH");
        calcCmd.execute(st, "10", def);
        assertEquals(st.peek(), 10.0, 1e-9);
    }

    public void testRoots () throws Exception {

        Calc stackCalc = new Calc("commands.properties");
        //3*x^2 + 2*x -2
        /* X1 = (-b + sqrt(b*b – 4ac)) / 2a
        X2 = (-b - sqrt(b*b – 4ac)) / 2a
        http://www.wolframalpha.com/input/?i=3*x%5E2+%2B+2*x+-2&x=-846&y=-373 */
        strCommand = "DEFINE a 3 DEFINE b 2 DEFINE c -2".split(" ");
        stackCalc.calculate(strCommand);
        strCommand = "PUSH b PUSH b * PUSH 4 PUSH a PUSH c * * -".split(" ");
        stackCalc.calculate(strCommand);
        strCommand = "SQRT PUSH -1 PUSH b * + PUSH 2 PUSH a * /".split(" ");
        stackCalc.calculate(strCommand);
        strCommand = "PUSH b PUSH b * PUSH 4 PUSH a PUSH c * * -".split(" ");
        stackCalc.calculate(strCommand);
        strCommand = "SQRT PUSH -1 * PUSH -1 PUSH b * + PUSH 2 PUSH a * /".split(" ");
        stackCalc.calculate(strCommand);
        /*assertEquals(st.peek(), -1.2153, 1e-4);
        st.pop();
        assertEquals(st.peek(), 0.54858, 1e-4);  */
    }
}
