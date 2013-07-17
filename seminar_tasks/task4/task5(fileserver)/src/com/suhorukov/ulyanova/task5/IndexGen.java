package com.suhorukov.ulyanova.task5;

import java.io.*;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 13.07.13
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
public class IndexGen {

    public IndexGen(String dirPath, List<File> dirItemsList) {
        File indexFile = new File (dirPath+"\\index.html");
        PrintWriter out =null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(indexFile)));
            out.println("<html>\n<head> \n <title> \n </title> \n </head> \n");
            out.println("<body> \n <table>");

            for(Iterator it = dirItemsList.iterator(); it.hasNext();) {
                File f = (File) it.next();
                StringBuilder sb = new StringBuilder();
                sb.append("<tr> \n");
                sb.append("<td> " + f.getPath() + "</td> \n");
                sb.append("<td> " + new Date(f.lastModified()) + "</td> \n");
                sb.append("</tr> \n");

                out.println(sb.toString());
            }

            out.println("</table> \n  </body> \n  </html> \n");


        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }

    }
}


