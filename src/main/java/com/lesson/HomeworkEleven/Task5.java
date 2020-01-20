package com.lesson.HomeworkEleven;

import java.util.*;
import java.util.concurrent.*;

public class Task5 {


    public static void runThreadsForTask5() throws InterruptedException, ExecutionException {
        List<ConcurrentLinkedQueue<String>> listOfQueues = new ArrayList<>();
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

    private static ConcurrentLinkedQueue<String> generateQueue(int numberOfQueue) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < 100_000; i++) {
            queue.add("человек $username: " + (i + 1) + ", номер очереди: " + numberOfQueue);
        }
        return queue;
    }

    public static class ThreadForService implements Callable<List<String>> {

        private List<ConcurrentLinkedQueue<String>> listOfQueues;
        List<String> listResult = Collections.synchronizedList(new ArrayList<>());


        public ThreadForService(List<ConcurrentLinkedQueue<String>> listOfQueues) {
            this.listOfQueues = listOfQueues;
        }

        @Override
        public List<String> call() throws InterruptedException {

            int numberOfQueue;

            while (allQueuesEmp()) {

                numberOfQueue = ThreadLocalRandom.current().nextInt(10);

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
            for (Queue<String> hhh : listOfQueues) {
                if (!hhh.isEmpty()) {
                    return true;
                }
            }
            return false;

        }
    }
}
