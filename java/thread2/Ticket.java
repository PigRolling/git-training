package com.pool;

public class Ticket {

    private String movieName;

    private String ticketId;

    private String theaterId;

    private float price;

    @Override
    public String toString() {
        return "Ticket{" +
                "movieName='" + movieName + '\'' +
                ", ticketId='" + ticketId + '\'' +
                ", theaterId='" + theaterId + '\'' +
                ", price=" + price +
                '}';
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public float getPrice() {
        return price;
    }
}
