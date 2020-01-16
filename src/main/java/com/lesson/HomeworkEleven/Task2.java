package com.lesson.HomeworkEleven;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task2 {

    private Random random = new Random();
    private QueueForTask2 queueForTask2 = new QueueForTask2();


    public void runThreadForTask2() {
        new Thread(new ProducerRunnable()).start();
        new Thread(new ConsumerRunnable()).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Размер очереди: " + queueForTask2.getQueue().size());
    }

    public class ProducerRunnable implements Runnable {

        @Override
        public void run() {
            int size = random.nextInt(100);
            for (int i = 0; i < size; i++) {
                queueForTask2.addElement("Закидываем " + (i + 1) + " элемент");
            }
        }
    }

    public class ConsumerRunnable implements Runnable {

        @Override
        public void run() {
            while (!queueForTask2.getQueue().isEmpty()) {
                System.out.println(queueForTask2.getQueue().poll());
                System.out.println("Выгружаем");
            }
        }
    }

    public class QueueForTask2{

        private Queue<String> queue = new LinkedList<>();

        public Queue<String> addElement(String givenString){
            queue.add(givenString);
            return queue;
        }

        public Queue<String> getQueue() {
            return queue;
        }
    }
}
