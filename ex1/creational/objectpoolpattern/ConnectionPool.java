package ex1.creational.objectpoolpattern;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool {
    private final Queue<DatabaseConnection> pool = new LinkedList<>();
    private final int maxSize;

    public ConnectionPool(int maxSize) {
        if(maxSize <= 0) throw new IllegalArgumentException("Pool size must be positive");
        this.maxSize = maxSize;
        for(int i = 0; i < maxSize; i++) {
            pool.add(new DatabaseConnection());
        }
    }

    public synchronized DatabaseConnection borrowConnection() {
        if(pool.isEmpty()) {
            System.out.println("No available connections. Please wait.");
            return null;
        }
        DatabaseConnection conn = pool.poll();
        System.out.println("Connection " + conn.getId() + " borrowed.");
        return conn;
    }

    public synchronized void returnConnection(DatabaseConnection conn) {
        if(conn == null) throw new IllegalArgumentException("Cannot return null connection");
        pool.offer(conn);
        System.out.println("Connection " + conn.getId() + " returned.");
    }

    public int availableConnections() {
        return pool.size();
    }
}
