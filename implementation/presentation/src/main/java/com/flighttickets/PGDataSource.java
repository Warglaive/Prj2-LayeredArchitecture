package com.flighttickets;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public enum PGDataSource implements DataSource {
    DATA_SOURCE;
    private static final String SERVER = "localhost";
    private static final String DB = "postgres";
    private static final String DBUSER = "postgres";
    private static final String DBPASSWORD = "123";
    private static final String CONNECTION_PROPS_FILE = "connection.properties";

    private final PGSimpleDataSource dataSource;


    PGDataSource() {
        System.out.println("PGDataSource");
        Properties props = new Properties();
        try {
            props.load(new InputStreamReader(Files.newInputStream(Paths.get(
                    CONNECTION_PROPS_FILE))));
        } catch (IOException ex) {
            Logger.getLogger(PGDataSource.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        dataSource = new PGSimpleDataSource();
        dataSource.setServerName(props.getProperty("server", SERVER));
        dataSource.setDatabaseName(props.getProperty("db", DB));
        dataSource.setUser(props.getProperty("dbuser", DBUSER));
        dataSource.setPassword(props.getProperty("dbpassword", DBPASSWORD));

    }


    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
