package com.pool;

import java.util.Queue;

public class TicketClient implements Runnable {

    private Queue<Ticket> ware;

    private String name;

    public TicketClient(Queue<Ticket> ware,String name){
        this.ware = ware;
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            synchronized (ware){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (ware.size() == 0){
                    System.out.println(name + " information: tickets have been sold out.");
                    try {
                        ware.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Ticket t = ware.poll();
                System.out.println(name + " sold " + t.toString());
                ware.notifyAll();
            }

        }
    }
}
