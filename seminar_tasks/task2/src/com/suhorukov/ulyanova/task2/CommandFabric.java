package com.suhorukov.ulyanova.task2;

import com.suhorukov.ulyanova.task2.commands.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 30.06.13
 * Time: 18:21
 * To change this template use File | Settings | File Templates.
 */
public class CommandFabric {

    public static HashMap <String, Command>  setCommands (String fileName) throws ClassNotFoundException, IllegalAccessException, IOException, InstantiationException {

        Properties p = new Properties();
        HashMap <String,  Command> commandMap =new HashMap <String, Command>();

        InputStream inputStr = CommandFabric.class.getResourceAsStream("commands.properties");
        //inputStr  java.io.BufferedInputStream
        p.load(new InputStreamReader(inputStr, "cp1251")); // .load needs Reader
        System.out.println(p.keySet());

        for (Object o: p.keySet()){
            String commandName = (String) o;
            String className = p.getProperty(commandName);
            Class cls = Class.forName(className);
            Object cmd = cls.newInstance();
            commandMap.put(commandName, (Command)cmd);
       }

        return commandMap;
    }
}
