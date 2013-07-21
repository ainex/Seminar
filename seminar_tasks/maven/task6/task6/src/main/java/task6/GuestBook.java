package task6;

import com.sun.prism.impl.Disposer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 20.07.13
 * Time: 10:53
 * To change this template use File | Settings | File Templates.
 */
public class GuestBook implements GuestBookController {

    Connection connection;
    Statement st;
    PreparedStatement prepStForMessageAdd;
    ResultSet requestResults;

    public GuestBook() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        this.connection = DriverManager.getConnection("jdbc:h2:mem:posts", "user1", "password1");
        this.st = connection.createStatement();
        st.execute("CREATE TABLE posts (ID int auto_increment, postDate DATE, postMessage TEXT)");

    }

    @Override
    public void addRecord(String message) {

        String sqlMessageAdd;
        sqlMessageAdd = "INSERT INTO posts (postDate,postMessage) VALUES (?,?)";
        Date date = new Date();
        java.sql.Date dateSQL = new java.sql.Date(date.getTime());
        try {
            prepStForMessageAdd = connection.prepareStatement(sqlMessageAdd);
            prepStForMessageAdd.setDate(1, dateSQL);
            prepStForMessageAdd.setString(2, message);
            prepStForMessageAdd.execute();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public List<Record> getRecords() {
        List<Record> recordsList = new ArrayList<Record>();

        try {
            requestResults = st.executeQuery("SELECT * FROM posts");
            while (requestResults.next()) {
                Record record = new Record();
                int id = requestResults.getInt("ID");
                Date date = requestResults.getDate("postDate");
                String message = requestResults.getString("postMessage");
                record.setID(id);
                record.setPostDate(date);
                record.setPostMessage(message);
                recordsList.add(record);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recordsList;
    }

    public void closeGuestBook () {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
