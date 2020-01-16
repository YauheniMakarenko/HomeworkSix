package com.lesson.HomeworkEleven;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task2 {

    private Random random = new Random();
    private QueueForTask2 queueForTask2 = new QueueForTask2();


    public void runThreadForTask2() {
        new Thread(new ProducerRunnable(queueForTask2)).start();
        new Thread(new ConsumerRunnable(queueForTask2)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Размер очереди: " + queueForTask2.getQueue().size());
    }

    public class ProducerRunnable implements Runnable {

        private QueueForTask2 queue;

        public ProducerRunnable(QueueForTask2 queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            int size = random.nextInt(100);
            for (int i = 0; i < size; i++) {
                queue.addElement("Закидываем " + (i + 1) + " элемент");
            }
        }
    }

    public class ConsumerRunnable implements Runnable {

        private QueueForTask2 queue;

        public ConsumerRunnable(QueueForTask2 queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (!queue.getQueue().isEmpty()) {
                System.out.println(queue.getQueue().poll());
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
