package com.suhorukov.ulyanova.task5;

import java.io.File;
import java.io.IOException;
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
        dirPath = (args.length != 0 ? args[0] : ".");
        dirItemsList = dirList.getDirItems(dirPath);

        for( Iterator it = dirItemsList.iterator(); it.hasNext();) {
            File f = (File) it.next();
            System.out.println(f.getCanonicalPath());
        }

        IndexGen indexGen = new IndexGen(dirPath, dirItemsList);
    }
}
