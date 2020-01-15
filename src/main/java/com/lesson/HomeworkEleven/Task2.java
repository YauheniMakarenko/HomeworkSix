package com.lesson.HomeworkEleven;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task2 {
    private Queue<String> queue = new LinkedList<>();
    private Random random = new Random();


    public void runThreadForTask2() {
        new Thread(new ProducerRunnable()).start();
        new Thread(new ConsumerRunnable()).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Размер очереди: " + queue.size());
    }

    public class ProducerRunnable implements Runnable {

        @Override
        public void run() {
            int size = random.nextInt(100);
            for (int i = 0; i < size; i++) {
                queue.add("Закидываем " + (i + 1) + " элемент");
            }
        }
    }

    public class ConsumerRunnable implements Runnable {

        @Override
        public void run() {
            while (!queue.isEmpty()) {
                System.out.println(queue.poll());
                System.out.println("Выгружаем");
            }
        }
    }

}
