package com.lesson.HomeworkEleven;

import java.util.*;
import java.util.concurrent.*;

public class Task3 {

    public void runThreadsForTask3() throws ExecutionException, InterruptedException {
        List<Queue<String>> listOfQueues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listOfQueues.add(generateQueue(i + 1));
        }

        long before = System.nanoTime();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<List<String>> future = executorService.submit(new ThreadForService(listOfQueues));


        System.out.println("Count of usernames is: " + future.get().size());
        long after = System.nanoTime();
        System.out.println("Покупателей обслужили за: " + (after - before) + " наносекунд");


        executorService.shutdown();

    }

    private Queue generateQueue(int numberOfQueue) {
        Queue<String> queue = new LinkedList();
        for (int i = 0; i < 100_000; i++) {
            queue.add("человек $username: " + (i + 1) + ", номер очереди: " + numberOfQueue);
        }
        return queue;
    }

    public class ThreadForService implements Callable<List<String>> {

        private List<Queue<String>> listOfQueues;

        public ThreadForService(List<Queue<String>> listOfQueues) {
            this.listOfQueues = listOfQueues;
        }

        @Override
        public List<String> call(){
            List<String> list = new ArrayList<>();

            for (int i = 0; i < listOfQueues.size(); i++) {
                while (!listOfQueues.get(i).isEmpty()) {
                    System.out.println(listOfQueues.get(i).element() + ", обслужен потоком: " + Thread.currentThread().getId());
                    list.add(listOfQueues.get(i).poll());
                }
            }
            return list;
        }
    }
}
