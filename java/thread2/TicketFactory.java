package com.pool;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TicketFactory {

    private Map<String,Integer> makeTheater(){
        Map<String,Integer> map = new HashMap<>();
        map.put("YT001",50);
        map.put("YT002",50);
        map.put("YT003",60);
        map.put("YT004",80);
        map.put("JM001",150);
        map.put("JM002",150);
        map.put("JM003",150);
        map.put("JM004",150);
        map.put("CENTER",220);
        return map;
    }

    private final String todyMovie1 = "Duoge.America";

    private final String todyMovie2 = "Backing Home.China";

    public Queue<Ticket> generateTickets(){
        Queue<Ticket> queue = new LinkedList<>();
        String idPrefix = "20200613";
        Map<String,Integer> theater = makeTheater();
        int c = 1;
        for(Map.Entry<String,Integer> entry : theater.entrySet() ){
            String thea = entry.getKey();
            int x = entry.getValue();
            for(int i=0;i<x;i++){
                Ticket t = new Ticket();
                if(thea.startsWith("YT")){
                    t.setMovieName(todyMovie1);
                    t.setPrice(35.00f);
                } else {
                    t.setMovieName(todyMovie2);
                    t.setPrice(27.00f);
                }
                t.setTheaterId(thea);
                t.setTicketId(idPrefix+code1(c++));
                queue.add(t);
            }
        }
        return queue;

    }

    private String code1(int a){
        return String.format("%04d",a);
    }

}
