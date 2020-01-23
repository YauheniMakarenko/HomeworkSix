package com.lesson.HomeworkEleven;

import java.util.concurrent.*;

public class Task6 {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(6);

    public void runThreadsForTask6() throws InterruptedException {
        while (true){
            new Thread(new Poker(cyclicBarrier)).start();
            TimeUnit.SECONDS.sleep(1);
        }

    }

    static class Poker implements Runnable {

        private CyclicBarrier cyclicBarrier;

        public Poker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("Поток: " + Thread.currentThread().getId() + " запускается");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Начинаю играть");
        }
    }
}
