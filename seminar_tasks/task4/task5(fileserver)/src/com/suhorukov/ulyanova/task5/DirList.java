package com.suhorukov.ulyanova.task5;

import java.io.File;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 13.07.13
 * Time: 8:18
 * To change this template use File | Settings | File Templates.
 */
public class DirList {

    public  void dir(String[] args) {
        File path = new File(args[0]);
        String[] list;
        list = path.list();

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }
}
