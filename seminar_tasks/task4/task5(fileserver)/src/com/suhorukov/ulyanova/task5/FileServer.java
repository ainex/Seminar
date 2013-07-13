package com.suhorukov.ulyanova.task5;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 13.07.13
 * Time: 8:13
 * To change this template use File | Settings | File Templates.
 */
public class FileServer {
    public static void main (String[] args) {
        System.out.println(args[0]);
        DirList  dirList = new DirList();
        dirList.dir(args);
    }
}
