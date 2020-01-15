package com.lesson.Test;


public class Main {


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println(Thread.currentThread().getName());

        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();

    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread name is: " + Thread.currentThread().getName());
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("My runnable " + Thread.currentThread().getName());
        }
    }
}


