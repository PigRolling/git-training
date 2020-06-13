package com.pool;

import com.sun.deploy.security.ValidationState;

import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Sell {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test1(){
        TicketFactory factory = new TicketFactory();
        Queue<Ticket> ware = factory.generateTickets();
        TicketClient client1 = new TicketClient(ware,"Taobao");
        TicketClient client2 = new TicketClient(ware,"JD");
        TicketClient client3 = new TicketClient(ware,"CatEye");
        Thread th1 = new Thread(client1);
        th1.start();
        Thread th2 = new Thread(client2);
        th2.start();
        Thread th3 = new Thread(client3);
        th3.start();
    }

    public static void test2(){
        TicketFactory factory = new TicketFactory();
        Queue<Ticket> ware = factory.generateTickets();
        String[] clients = {"Taobao","JD","CatEye"};
        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,10,10, TimeUnit.SECONDS,queue);
        for(int i = 0;i<3;i++){
            executor.execute(new TicketClient(ware,clients[i]));
        }
        executor.shutdown();
    }
}
