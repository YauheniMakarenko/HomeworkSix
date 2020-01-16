package com.lesson.HomeworkEleven;


import java.math.BigInteger;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task5 {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static List<String> listResult = Collections.synchronizedList(new ArrayList<>());


    public static void runThreadsForTask5() throws InterruptedException {
        List<Queue<String>> listOfQueues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listOfQueues.add(generateQueue(i + 1));
        }

        long before = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<ThreadForService> listThread = new ArrayList();
        for (int i = 0; i < 10; i++) {
            listThread.add(new ThreadForService(listOfQueues));
        }
        executorService.invokeAll(listThread);


        System.out.println("Количество юзеров: " + "1) AtomicInteger: " + atomicInteger + ", 2) listResult: " + listResult.size());
        long after = System.nanoTime();
        System.out.println("Покупателей обслужили за: " + (after - before) + " наносекунд");
        executorService.shutdown();
    }

    private static Queue<String> generateQueue(int numberOfQueue) {
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < 100_000; i++) {
            queue.add("человек $username: " + (i + 1) + ", номер очереди: " + numberOfQueue);
        }
        return queue;
    }

    public static class ThreadForService implements Callable<List<String>> {

        private List<Queue<String>> listOfQueues;


        public ThreadForService(List<Queue<String>> listOfQueues) {
            this.listOfQueues = listOfQueues;
        }

        @Override
        public List<String> call() throws InterruptedException {

            int numberOfQueue = ThreadLocalRandom.current().nextInt(10);

            while (allQueuesEmp()) {

                if (!listOfQueues.get(numberOfQueue).isEmpty()) {
                    synchronized (listOfQueues.get(numberOfQueue)) {
                        System.out.println(listOfQueues.get(numberOfQueue).element() + " обслужен потоком: " + Thread.currentThread().getId());
                        listResult.add(listOfQueues.get(numberOfQueue).poll());
                    }
                    atomicInteger.getAndIncrement();
                    //TimeUnit.SECONDS.sleep(1);
                }
                numberOfQueue = ThreadLocalRandom.current().nextInt(10);
            }
            return null;
        }

        private boolean allQueuesEmp() {
            synchronized (listOfQueues) {
                for (Queue<String> hhh : listOfQueues) {
                    if (!hhh.isEmpty()) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}


/*
 while (!(listOfQueues.get(0).size() == 0 && listOfQueues.get(1).size() == 0 && listOfQueues.get(2).size() == 0 && listOfQueues.get(3).size() == 0 &&
         listOfQueues.get(4).size() == 0 && listOfQueues.get(5).size() == 0 && listOfQueues.get(6).size() == 0 && listOfQueues.get(7).size() == 0 &&
         listOfQueues.get(8).size() == 0 && listOfQueues.get(9).size() == 0)) {

         }*/
