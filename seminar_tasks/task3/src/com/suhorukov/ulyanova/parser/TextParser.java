package com.suhorukov.ulyanova.parser;

import java.io.*;
import java.lang.String;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 04.07.13
 * Time: 23:56
 * To change this template use File | Settings | File Templates.
 */
public class TextParser {


    public static void main (String [] args) throws IOException {

        if (args.length>0){
            Reader r=null;
            StringBuilder sb = null;
            Map <String, Integer> wordMap = null;
            WordCounter word;
            int i, wCounter= 0;
            try {
                r = new InputStreamReader(new BufferedInputStream(new FileInputStream(new File(args[0]))));
                sb = new StringBuilder();
                wordMap = new HashMap<>();
                String str = "";
                wCounter = 0;

                while ((i=r.read())!=-1) {

                    if (Character.isLetterOrDigit(i)) {
                        sb.append((char) Character.toLowerCase(i));
                    } else {
                        if (sb.length() != 0) {
                            str = sb.toString();
                            if (wordMap.containsKey(str)) {
                                wordMap.put(str, wordMap.get(str) + 1);
                            } else {
                                wordMap.put(str, 1);
                            }
                            wCounter++;
                            sb.setLength(0);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (r != null) {
                    r.close();
                }
            }


            List <WordCounter> wordList =new ArrayList<>();
            for (Map.Entry <String, Integer> entry : wordMap.entrySet()) {

                wordList.add(new WordCounter (entry.getKey(), entry.getValue()));

            }

            Collections.sort(wordList);

            File outFile=null;
            try {
                outFile = new File("statistics.csv");
                System.out.println("Word analyse stat at: " + outFile.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }

            PrintWriter wr = null;
            try {
                wr = new PrintWriter (new BufferedWriter (new FileWriter (outFile)));

                for (Iterator it = wordList.iterator(); it.hasNext();) {
                    word = (WordCounter) it.next();
                    sb.setLength(0);
                    sb.append(word.getWord()+ ";");
                    sb.append(word.getFrequency()+";");
                    double num =  (word.getFrequency()*100.0/wCounter);
                    wr.write(sb.toString());
                    wr.format("%.2f",num);
                    wr.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (wr != null) {
                    wr.close();
                }
            }

        } else {
            System.out.println("file path not specified");
        }
    }
}
