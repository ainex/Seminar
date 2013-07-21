package task6;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 20.07.13
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
public class Record {
    private int ID;  // - число первичный ключ
    private Date postDate; // — дата
    private String postMessage; // -- текст записи в блоге

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getPostMessage() {
        return postMessage;
    }

    public void setPostMessage(String postMessage) {
        this.postMessage = postMessage;
    }
}
