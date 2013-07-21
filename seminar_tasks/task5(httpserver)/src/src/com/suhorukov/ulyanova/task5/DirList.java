package src.com.suhorukov.ulyanova.task5;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 13.07.13
 * Time: 8:18
 * To change this template use File | Settings | File Templates.
 */
public class DirList {


    public List<File> getDirItems (String args) {

        File path = new File(args);
        List<File> dirItemsList = new ArrayList<File>();

        for(File dirItem : path.listFiles()) {
            dirItemsList.add(dirItem);
        }


         class DirItemsComparator implements Comparator<File>{
            public int compare(File item1, File item2){

                if ((item1.isDirectory()&&item2.isDirectory()) || (item1.isFile()&&item2.isFile()) ) {
                return item1.compareTo(item2);
                } else return -1;
            }
         }


        Collections.sort(dirItemsList, new DirItemsComparator());

        return dirItemsList;
    }



}
