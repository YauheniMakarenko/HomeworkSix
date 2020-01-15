package com.lesson.HomeworkEleven.Test1;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Container container = new Container();
        List<String> userNameList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> listOfTasks = new ArrayList<>();
        executorService.submit(new Task(container, userNameList));
        executorService.submit(new Task(container, userNameList));
        executorService.submit(new Task(container, userNameList));
        executorService.submit(new Task(container, userNameList));
        executorService.submit(new Task(container, userNameList));
        executorService.submit(new Task(container, userNameList));
        executorService.submit(new Task(container, userNameList));
        executorService.submit(new Task(container, userNameList));
        executorService.submit(new Task(container, userNameList));
        executorService.submit(new Task(container, userNameList));

        long before = System.nanoTime();
        while (!isEmptyQueues(container)){
            if (userNameList.size() == 100){
                break;
            }

            //System.out.println("current count of users is " + userNameList.size());
        }
        long after = System.nanoTime();
        System.out.println("Время: " + (after - before) + " nanoseconds");
        System.out.println("Количество юзеров: " + userNameList.size());

    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean isEmptyQueues(Container container){
        for (int i = 0; i < container.getQueueList().size(); i++) {
            if (!container.getQueueList().get(i).isEmpty()){
                return false;
            }
        }
        return true;
    }
}
