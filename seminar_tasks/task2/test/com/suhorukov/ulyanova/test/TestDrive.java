package com.suhorukov.ulyanova.test;

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

    public void setUp() throws Exception {

    }

    public void testPush () throws Exception {
        commandMap = CommandFabric.setCommands("");
        st = new Stack <>();
        def = new HashMap<>();

        calcCmd = commandMap.get("PUSH");
        calcCmd.execute(st, "10", def);
        assertEquals(st.peek(), 10.0, 1e-9);
    }


}
