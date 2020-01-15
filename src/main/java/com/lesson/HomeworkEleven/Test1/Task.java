package com.lesson.HomeworkEleven.Test1;

import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    List<Queue<String>> queueList;
    List<String> userNameList;
    Random random = new Random();
    Container container;
    Queue<String> queue;
    String username;

    public Task(Container container, List<String> userNameList) {
        this.container = container;
        this.queueList = container.getQueueList();
        this.userNameList = userNameList;
        queue = container.getRandomQueue();
    }

    @Override
    public void run() {
        if (queue.isEmpty()) {
            return;
        }
        String poll;
        username = queue.element();
        synchronized (queue) {
            System.out.println(queue.element() + " обслужен потоком " + Thread.currentThread().getId());
            poll = queue.poll();
        }
        synchronized (userNameList) {
            userNameList.add(poll);
        }
    }


//    @Override
//    public Integer call() throws Exception {
//        System.out.println("TUT");
//        synchronized (queue){
//            System.out.println(queue.element() + "_done_by_thread_" + Thread.currentThread().getId());
//            userNameList.add(queue.poll());
//        }
//        return null;
//    }
}
