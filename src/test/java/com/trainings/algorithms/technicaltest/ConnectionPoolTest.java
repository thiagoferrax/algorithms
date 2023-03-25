package com.trainings.algorithms.technicaltest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

class MyConnection implements Connection {

    @Override
    public void execute(String query) {
        System.out.println("Executing... " + query);
    }

    @Override
    public void close() {
        System.out.println("Closing... ");
    }

}

public class ConnectionPoolTest {

    @Test
    public void whenPassingAnEmptyConnectionListShouldReturnNullConnection() {
        ConnectionPool connectionPool = new ConnectionPool(new ArrayList<>());

        Assert.assertNull(connectionPool.getConnection());
    }

    @Test
    public void whenPassingANotEmptyConnectionListShouldReturnAnAvailableConnection() {
        ArrayList<Connection> connections = new ArrayList<>();

        connections.add(new MyConnection());
        connections.add(new MyConnection());

        ConnectionPool connectionPool = new ConnectionPool(connections);

        Assert.assertNotNull(connectionPool.getConnection());
        Assert.assertNotNull(connectionPool.getConnection());
    }


    @Test
    public void whenThereAreNoMoreAvailableConnectionInThePoolItShouldReturnNull() {
        ArrayList<Connection> connections = new ArrayList<>();

        connections.add(new MyConnection());
        connections.add(new MyConnection());

        ConnectionPool connectionPool = new ConnectionPool(connections);
        connectionPool.getConnection();
        connectionPool.getConnection();

        Assert.assertNull(connectionPool.getConnection());
    }

    @Test
    public void whenAnUsedConnectionIsClosedAndAllOthersAreBeingUsedItShouldReturnAnAvailableConnection() {
        ArrayList<Connection> connections = new ArrayList<>();
        connections.add(new MyConnection());
        connections.add(new MyConnection());
        connections.add(new MyConnection());

        ConnectionPool connectionPool = new ConnectionPool(connections);


        Connection c1 = connectionPool.getConnection();
        c1.execute("select id, name, email from users");

        Connection c2 = connectionPool.getConnection();
        c2.execute("select name from groups");

        Connection c3 = connectionPool.getConnection();
        c3.execute("select id, name from applications");
        c3.close();

        Assert.assertNotNull(connectionPool.getConnection());
    }
}
