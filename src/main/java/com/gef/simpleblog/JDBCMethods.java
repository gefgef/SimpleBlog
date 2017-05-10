package com.gef.simpleblog;

import java.sql.*;
import java.util.ArrayList;
import javax.naming.NamingException;


public class JDBCMethods {
    private static final String JDBC_DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:testdatabase.db"; //TODO: Find a way to specify relative path to DB
    private static final String USER = "";
    private static final String PASS = "";
    
    private static Connection connection = null;
    private static Statement statement = null;
    
    public static void ConnectToDB() throws ClassNotFoundException, SQLException, NamingException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL);
    }
    
    public static void CloseDBConnection() throws ClassNotFoundException, SQLException {
        connection.close();
    }
    
    public static ArrayList<BlogEntry> getAllEntries() throws ClassNotFoundException, SQLException, NamingException {
        ArrayList<BlogEntry> entries = new ArrayList<>();
        ConnectToDB();
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT ROWID, AUTHOR, TEXT FROM BLOG");
        while (rs.next()) {
            BlogEntry entry = new BlogEntry();
            entry.setId(rs.getInt("ROWID"));
            entry.setAuthor(rs.getString("AUTHOR"));
            entry.setPost(rs.getString("TEXT"));
            entries.add(entry);
        }
        CloseDBConnection();
        return entries;
    }
    
    public static boolean isUserExisted(String user, String password) throws ClassNotFoundException, SQLException, NamingException {
        ConnectToDB();
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT USER, PASSWORD FROM USERS");
        while (rs.next()) {
            if (rs.getString("USER").equals(user) && rs.getString("PASSWORD").equals(password)) {
                CloseDBConnection();
                return true;
            }
        }
        CloseDBConnection();
        return false;
    }

    public static void addNewPost(String username, String post) throws ClassNotFoundException, SQLException, NamingException {
        ConnectToDB();
        statement = connection.createStatement();
        statement.executeQuery("INSERT INTO BLOG(AUTHOR, TEXT) VALUES('" + username + "','" + post + "')");
        CloseDBConnection();
    }
}
