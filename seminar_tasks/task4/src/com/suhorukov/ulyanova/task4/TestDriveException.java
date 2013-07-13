package com.suhorukov.ulyanova.task4;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 10.07.13
 * Time: 20:10
 * To change this template use File | Settings | File Templates.
 */
public class TestDriveException {

    public static class ExceptionImp implements ExceptionGenerator  {
        private int i = 100000;
        @Override
        public void generateNullPointerException() {
            String [] str =new String [2];
            System.out.println(str[0].length());
        }

        @Override
        public void generateClassCastException() {

            Object o = new Object();
            String str;
            str = (String) o;
            // (string) HashSet throw Object
        }

        @Override
        public void generateNumberFormatException() {
            double d;
            d=new Double("llo");

        }

        @Override
        public void generateStackOverflowError() {

            i=i*i;
             generateStackOverflowError();


        }

        @Override
        public void generateOutOfMemoryError() {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void generateMyException(String message) throws MyException {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    public static void main (String [] args) {


      ExceptionImp exceptionImp = new ExceptionImp();

        try {
          exceptionImp.generateNullPointerException();
        }

        catch (Exception ex) {
            System.out.println("Exception: "+ex.getStackTrace());
            ex.printStackTrace(System.out);
       }


        try {
            exceptionImp.generateNumberFormatException();
        }

        catch (Exception ex) {
            System.out.println("Exception: "+ex.getStackTrace());
            ex.printStackTrace(System.out);
        }



        try {
            exceptionImp.generateClassCastException();
        }

        catch (Exception ex) {
            System.out.println("Exception: "+ex.getStackTrace());
            ex.printStackTrace(System.out);
        }

        try {
            exceptionImp.generateStackOverflowError();
        }

        catch (Exception ex) {
            System.out.println("Exception: "+ex.getStackTrace());
            ex.printStackTrace(System.out);
        }
    }
}
