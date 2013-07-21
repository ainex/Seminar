package src.com.suhorukov.ulyanova.task5;

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

    public void generateHtml(String dirPath, List<File> dirItemsList) {
        File indexFile = new File (dirPath+File.separatorChar+"index.html");
        PrintWriter out =null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(indexFile)));
            out.println("<html>\n<head> \n <title> \n </title> \n </head> \n");
            out.println("<body> \n <table>");
            StringBuilder sb = new StringBuilder();
            sb.append("<tr> \n");
            sb.append("<td> ").append(indexFile.getCanonicalFile().getParent()).append("</td> \n");
            sb.append("</tr> \n");
            out.println(sb.toString());
            sb.setLength(0);
                for(Iterator it = dirItemsList.iterator(); it.hasNext();) {
                    File f = (File) it.next();
                    sb.append("<tr> \n");
                    sb.append("<td> ").append("<a href=").append(f.getPath()).append(">link</a>").append("</td> \n");
                    sb.append("<td> ").append(new Date(f.lastModified())).append("</td> \n");
                    sb.append("</tr> \n");
                    out.println(sb.toString());
                    sb.setLength(0);
                }

            out.println("</table> \n  </body> \n  </html> \n");
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }

    }


    public String generateMessageBody (List<File> dirItemsList) {

        StringBuilder messageBody = new StringBuilder();

        messageBody.append("<html>\n<head> \n <title> \n </title> \n </head> \n");
        messageBody.append("<body> \n <table>");

        messageBody.append("<tr> \n");
        messageBody.append("<td>").append("<a href=").append(dirItemsList.get(0).getParentFile().getParent())
                                    .append(">..</a>").append("</td> \n");
        messageBody.append("</tr> \n");

        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        for(Iterator it = dirItemsList.iterator(); it.hasNext();) {
            File f = (File) it.next();
            sb.append("<tr> \n");
            sb.append("<td> ").append("<a href=").append(f.getPath()).append(">").append(f.getName())
                               .append("</a>").append("</td> \n");
            if (f.isFile()) {
                sb.append("<td> ").append(new Date(f.lastModified())).append("</td> \n");
            }
            sb.append("</tr> \n");
            messageBody.append(sb.toString());
            sb.setLength(0);
        }
        messageBody.append("</table> \n  </body> \n  </html> \n");


        return messageBody.toString();
    }

}


