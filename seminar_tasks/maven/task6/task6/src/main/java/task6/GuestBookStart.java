package task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 20.07.13
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class GuestBookStart {

    public static void main (String[] args) throws ClassNotFoundException, SQLException, IOException {

        GuestBook guestBook = new GuestBook();
        BufferedReader breader = new  BufferedReader(new InputStreamReader(System.in));
        String inputString;
        System.out.println("Guest book welcomes you! Use \"add <message>\" or \"list\" commands");
        while ((inputString = breader.readLine())!=null) {
            inputString.trim();
            if (inputString.startsWith("add ")){
                inputString=inputString.substring(4);
                guestBook.addRecord(inputString);
                System.out.println("Your message was added");
            } else if (inputString.startsWith("list")) {
                List<Record> records = guestBook.getRecords();
                Record record;
                StringBuilder sb = new StringBuilder();
                if (records.isEmpty()) {
                    sb.append("There are no any messages yet...Maybe you would like to add some");
                    System.out.println(sb.toString());
                }
                sb.setLength(0);
                for (Iterator it = records.iterator(); it.hasNext();) {
                    record = (Record) it.next();
                    sb.append("Message ID: ").append(record.getID());
                    sb.append(" says: ").append(record.getPostMessage());
                    sb.append(" at : ").append(record.getPostDate());
                    System.out.println(sb.toString());
                    sb.setLength(0);
                }

            } else {
                System.out.println("Unknown command. Try again using \"add <message>\" or \"list\" commands");
            }
        }
    guestBook.closeGuestBook();

    }
}
