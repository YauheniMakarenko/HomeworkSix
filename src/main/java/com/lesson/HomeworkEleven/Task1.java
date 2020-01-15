package com.lesson.HomeworkEleven;

import java.util.concurrent.TimeUnit;

public class Task1 {

    public void runThreadForTask1(){
        new Thread(new ThreadRunnable()).start();
    }

    public static class ThreadRunnable implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("Прошло 5 секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
