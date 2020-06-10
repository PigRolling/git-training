package com.thread2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java经典的多线程问题，生产者和消费者
 */
public class ThreadRun {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int s = 3;

        Producer p = new Producer(queue,s,"producer_A");
        Consumer c1 = new Consumer(queue,s,"consumer_1");
        Consumer c2 = new Consumer(queue,s,"consumer_2");
        Consumer c3 = new Consumer(queue,s,"consumer_3");

        p.start();
        c1.start();
        c2.start();
        c3.start();
    }

}
