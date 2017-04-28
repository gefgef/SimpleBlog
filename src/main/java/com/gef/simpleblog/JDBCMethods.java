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
    
    public static ArrayList<String> getAllUsers() throws ClassNotFoundException, SQLException, NamingException {
        ArrayList<String> names = new ArrayList<String>();
        
        ConnectToDB();
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT NAME FROM USERS");
        while (rs.next()) {
            names.add(rs.getString("name"));
        }
        rs.close();
        statement.close();
        CloseDBConnection();
        return names;
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
    
}
