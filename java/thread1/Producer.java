package com.thread2;

import java.util.Queue;

public class Producer extends Thread {

    private Queue<Integer> queue;

    private int maxsize;

    public Producer(Queue<Integer> queue,int maxsize,String name){
        this.queue = queue;
        this.maxsize = maxsize;
        this.setName(name);
    }

    @Override
    public void run(){

        while (true){
            synchronized(queue){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(this.getName() + " get the queue-lock");

                while (queue.size() == maxsize){
                    System.out.println("queue is full filled, Producer "  + this.getName() + " is waiting");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int num = (int) (Math.random() * 100);
                queue.offer(num);
                System.out.println(this.getName() + " produce a number - " + num);

                queue.notifyAll();

                System.out.println(this.getName() + " quit once");

            }
        }
    }
}
