package task6;

import com.sun.prism.impl.Disposer;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 20.07.13
 * Time: 12:33
 * To change this template use File | Settings | File Templates.
 */
public interface GuestBookController {

    void addRecord(String message);
    List<Record> getRecords();  //Record {id, postDate, message}
}
