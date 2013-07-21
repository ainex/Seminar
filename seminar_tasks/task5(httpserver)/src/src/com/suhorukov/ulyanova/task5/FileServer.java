package src.com.suhorukov.ulyanova.task5;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 13.07.13
 * Time: 8:13
 * To change this template use File | Settings | File Templates.
 */
public class FileServer {
    public static void main (String[] args) throws IOException {

        DirList  dirList = new DirList();
        List<File> dirItemsList;
        String dirPath;
        int portNumber;
        dirPath = (args.length != 0 ? args[0] : ".");
        dirItemsList = dirList.getDirItems(dirPath);

        for( Iterator it = dirItemsList.iterator(); it.hasNext();) {
            File f = (File) it.next();
            System.out.println(f.getCanonicalPath());
        }

        IndexGen indexGen = new IndexGen();
        indexGen.generateHtml(dirPath, dirItemsList);

        //get port number from args[1], set default 2048 if empty
        portNumber = args.length > 1 ? Integer.parseInt(args[1]) : 2048;

        ServerSocket serverSocket = new ServerSocket(portNumber,0,InetAddress.getByName("localhost"));
        int numberOfClient = 0;

        while(true){
            Socket clientSocket = serverSocket.accept();
            numberOfClient++;
            System.out.println("Get connection from:"+clientSocket.getInetAddress()
                                +":"+clientSocket.getPort() + " Number " + numberOfClient);

            Thread t = new Thread(new RequestProcessor(clientSocket, dirPath, numberOfClient));
            System.out.println("Run...");
            t.start();
        }
    }
}
