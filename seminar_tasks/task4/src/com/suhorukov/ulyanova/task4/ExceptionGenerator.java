package com.suhorukov.ulyanova.task4;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 10.07.13
 * Time: 20:12
 * To change this template use File | Settings | File Templates.
 */
public interface ExceptionGenerator {
    void generateNullPointerException();
    void generateClassCastException();
    void generateNumberFormatException();
    void generateStackOverflowError();
    void generateOutOfMemoryError();
    void generateMyException(String message) throws MyException;
}