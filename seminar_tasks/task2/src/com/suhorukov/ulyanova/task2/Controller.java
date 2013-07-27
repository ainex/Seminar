package com.suhorukov.ulyanova.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 06.07.13
 * Time: 0:03
 * To change this template use File | Settings | File Templates.
 */
public class Controller {
    private  String inputStrCommand;
    private  String[] cmdArray;
    private  BufferedReader br;
    private  Calc stackCalc;

    public Controller(BufferedReader reader ) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        this.br = reader;
        stackCalc = new Calc("commands.properties");
    }


    public void run () throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        while ((inputStrCommand =br.readLine())!=null && inputStrCommand.length()!=0) {
            inputStrCommand = inputStrCommand.trim();
            inputStrCommand = inputStrCommand.replaceAll("\\s+", " ");
            System.out.println("string commans: " + inputStrCommand);
            cmdArray = inputStrCommand.split(" ");

            stackCalc.calculate(cmdArray);
        }
    }
}
