package com.suhorukov.ulyanova.parser;

import java.io.*;
import java.lang.String;


/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 04.07.13
 * Time: 23:56
 * To change this template use File | Settings | File Templates.
 */
public class TextParser {

    public static void main (String [] args) throws IOException {
        File file = new File("C:\\Users\\ainex\\Google Диск\\PROG\\Java\\IdeaProjects\\seminar_tasks\\tasks3\\src\\com\\suhorukov\\ulyanova\\parser\\text_file.txt");
        Reader r = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
        //InputStreamReader is a bridge from byte streams to character streams
        String str;
        int i;
        char ch;
        while ((i=r.read())!=-1) {
            ch = (char) i;
            System.out.print(ch);

        }
        r.close();
    }
}
