package com.thread2;

import java.util.Queue;

public class Consumer extends Thread {

    private Queue<Integer> queue;

    private int maxsize;

    public Consumer(Queue<Integer> queue, int maxsize, String name){
        this.queue = queue;
        this.maxsize = maxsize;
        this.setName(name);
    }

    @Override
    public void run(){
        while (true){
            synchronized (queue){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(this.getName() + " get the queue-lock");
                //使用if做条件判断时，会在queue.poll()时引起NullPointException
                while(queue.isEmpty()){
                    System.out.println("queue is empty, Consumer " + this.getName() + " is waiting");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int num = queue.poll();
                System.out.println(this.getName() + " consume a number - " + num);
                queue.notifyAll();
                System.out.println(this.getName() + " quit once");
            }
        }
    }
}
