package com.lesson.HomeworkEleven;

import java.util.*;
import java.util.concurrent.*;

public class Task5 {


    public static void runThreadsForTask5() throws InterruptedException, ExecutionException {
        List<Queue<String>> listOfQueues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listOfQueues.add(generateQueue(i + 1));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<ThreadForService> listThread = new ArrayList();
        for (int i = 0; i < 10; i++) {
            listThread.add(new ThreadForService(listOfQueues));
        }
        long before = System.currentTimeMillis();
        List<Future<List<String>>> listResult = executorService.invokeAll(listThread);

        executorService.shutdown();

        int count = 0;
        for (int i = 0; i < listResult.size(); i++) {
            count += listResult.get(i).get().size();
        }

        System.out.println("Количество юзеров: " + count);
        long after = System.currentTimeMillis();
        System.out.println("Покупателей обслужили за: " + (after - before) + " миллисекунд");

    }

    private static Queue<String> generateQueue(int numberOfQueue) {
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < 100_000; i++) {
            queue.add("человек $username: " + (i + 1) + ", номер очереди: " + numberOfQueue);
        }
        return queue;
    }

    public static class ThreadForService implements Callable<List<String>> {

        private List<Queue<String>> listOfQueues;
        private List<String> listResult = new ArrayList<>();


        public ThreadForService(List<Queue<String>> listOfQueues) {
            this.listOfQueues = listOfQueues;
        }

        @Override
        public List<String> call() throws InterruptedException {
            Random random = new Random();
            int numberOfQueue;

            while (!allQueuesEmp()) {

                numberOfQueue = random.nextInt(10);

                String poll = listOfQueues.get(numberOfQueue).poll();
                if (poll != null) {
                    listResult.add(poll);
                    System.out.println(poll + " обслужен потоком: " + Thread.currentThread().getId());
                }
                //TimeUnit.SECONDS.sleep(2);
            }
            return listResult;
        }

        private boolean allQueuesEmp() {
            for (Queue<String> queue : listOfQueues) {
                if (!queue.isEmpty()) {
                    return false;
                }
            }
            return true;

        }
    }
}
