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
        String inFilePath, outFilePath;
        File inFile = new File(args[0]);
        File outFile;
        Reader r = new InputStreamReader(new BufferedInputStream(new FileInputStream(inFile)));
        PrintWriter wr;
        StringBuilder sb = new StringBuilder();
        Map <String, Integer> wordMap = new HashMap<>();
        List <WordCounter> wordList =new ArrayList<>();
        WordCounter word;
        //InputStreamReader is a bridge from byte streams to character streams
        String str = "";
        int i, wCounter=0;

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
        r.close();
        System.out.println(wordMap);
        System.out.println(wCounter);

        for (Map.Entry <String, Integer> entry : wordMap.entrySet()) {

            wordList.add(new WordCounter (entry.getKey(), entry.getValue()));

        }

        Collections.sort(wordList);

        inFilePath = inFile.getPath();
        outFilePath = inFilePath.replaceFirst(inFile.getName(), "statistics.csv");
        System.out.println(outFilePath);
        outFile = new File (outFilePath);
        if (!outFile.createNewFile()) {
            outFile.delete();
            outFile.createNewFile();
        }

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
        wr.close();
    }
}
