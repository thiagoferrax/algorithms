package com.trainings.algorithms.technicaltest;

import java.util.ArrayList;
import java.util.List;

interface Connection {
	public void execute(String query);
	public void close();
}

interface ConnectionPoolInterface {
	public Connection getConnection();
}


/**
 * Create a connection pool according the Connection and ConnectionPool interface already specified.
 * Atlassian Technical Test.  
 */
class ConnectionDecorator implements Connection {

	private Connection connection;
	private boolean closed = false;

	public ConnectionDecorator(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void execute(String query) {
		this.connection.execute(query);

	}

	@Override
	public void close() {
		this.connection.close();
		this.closed = true;
	}

	public boolean isClosed() {
		return closed;
	}
}

public class ConnectionPool implements ConnectionPoolInterface {
	private List<ConnectionDecorator> avaliableConnections;
	private List<ConnectionDecorator> usedConnections;

	public ConnectionPool(List<Connection> connections) {
		this.avaliableConnections =  new ArrayList<ConnectionDecorator>();
		this.usedConnections = new ArrayList<ConnectionDecorator>();
		
		for (Connection connection : connections) {
			this.avaliableConnections.add(new ConnectionDecorator(connection));
		}

	}

	@Override
	public synchronized Connection getConnection() {
		ConnectionDecorator connection = null;

		if (avaliableConnections.size() > 0) {
			connection = getAvailableConnection();
		} else {
			for (ConnectionDecorator used : usedConnections) {
				if (used.isClosed()) {
					avaliableConnections.add(used);									
				}
			}
			if (avaliableConnections.size() > 0) {
				usedConnections.removeAll(avaliableConnections);
				connection = getAvailableConnection();
			}
		}

		return connection;
	}

	private ConnectionDecorator getAvailableConnection() {
		ConnectionDecorator connection;
		connection = avaliableConnections.remove(avaliableConnections.size() - 1);
		usedConnections.add(connection);
		return connection;
	}
}