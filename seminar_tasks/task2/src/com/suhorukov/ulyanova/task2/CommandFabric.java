package com.suhorukov.ulyanova.task2;

import com.suhorukov.ulyanova.task2.commands.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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

    private  HashMap <String,  Command> commandMap;

    public CommandFabric(String fileName) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Properties p = new Properties();
        commandMap = new HashMap<>();
        InputStream inputStr = CommandFabric.class.getResourceAsStream(fileName);

        p.load(new InputStreamReader(inputStr, "cp1251")); // .load needs Reader
        System.out.println("commands set" + p.keySet());

        for (Object o: p.keySet()){
            String commandName = (String) o;
            String className = p.getProperty(commandName);
            Class cls = Class.forName(className);
            Object cmd = cls.newInstance();
            commandMap.put(commandName, (Command)cmd);
        }
    }

    public  HashMap <String, Command>  setCommands ()  {


        return commandMap;
    }

    public  Command  getCommand (String cmdName)  {
        Command cmd = null;
        if (commandMap.containsKey(cmdName)) {
           cmd = commandMap.get(cmdName);
        }

        return cmd;
    }
}
