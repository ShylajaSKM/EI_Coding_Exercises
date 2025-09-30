package ex1.creational.objectpoolpattern;

import java.util.concurrent.atomic.AtomicInteger;

public class DatabaseConnection {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private boolean active;

    public DatabaseConnection() {
        this.id = count.incrementAndGet();
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void close() {
        active = false;
        System.out.println("Connection " + id + " closed.");
    }

    public void executeQuery(String query) {
        if(!active) {
            throw new IllegalStateException("Connection is closed!");
        }
        System.out.println("Executing query on connection " + id + ": " + query);
    }
}
