package com.lesson.HomeworkEleven.Test1;

import java.util.*;

public class Container {
    private List<Queue<String>> queueList;
    Random random = new Random();

    public Container(){
        queueList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            queueList.add(generateQueue(i+1));
        }
    }

    private Queue<String> generateQueue(int index) {
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.add("юзер " + i + " , из очереди " + index);
        }
        return queue;
    }

    public List<Queue<String>> getQueueList() {
        return queueList;
    }

    public Queue<String> getRandomQueue(){
        Queue<String> queue = queueList.get(random.nextInt(10));

        return queue;
    }
}
