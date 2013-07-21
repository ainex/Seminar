package src.com.suhorukov.ulyanova.task5;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 17.07.13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public class RequestProcessor implements Runnable {
    Socket s;  //an endpoint for communication between two machines
    String dirPath;
    int numberOfClient;

    RequestProcessor(Socket s, String dirPath, int numberOfClient)  {
        this.s = s;
        this.dirPath=dirPath;
        this.numberOfClient = numberOfClient;
    }

    @Override
    public void run() {
        try {
            InputStream input = s.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = s.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(output);

            StringBuilder sb = new StringBuilder();
            int c;
            while((c =input.read())!=-1 && c!=10 && c!=13){
                sb.append((char)c);
            }
            //получаем команду и ее аргументы
            String data = sb.toString();
            String args[] = data.split(" ");
            String cmd = args[0].trim().toUpperCase();
            /*
            * Response message
            */
            DirList dirList = new DirList();
            IndexGen gen = new IndexGen();
            String s = gen.generateMessageBody(dirList.getDirItems(dirPath));
            //String s = "<html><title>test</title><body>Hello <b>world" + data +"</b></body></html>";
            //a Status-Line (for example HTTP/1.1 200 OK, which indicates that the client's request succeeded)
            output.write("HTTP/1.0 200 OK\r\n".getBytes());
            //headers
            output.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
            output.write(("Content-Length: " + s.length() + "\r\n").getBytes());
            //an empty line to separate headers from message body
            output.write("\r\n".getBytes());
            //Message Body
            output.write(s.getBytes());
            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
