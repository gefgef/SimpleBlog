package com.gef.simpleblog;

//import java.util.Date;

public class BlogEntry {
    
    private int id;
    //private Date date;
    private String author;
    private String post;
    
    
    //GETTERS
    
    public int getId() {
        return id;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getPost() {
        return post;
    }
    
    // SETTERS
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setPost(String post) {
        this.post = post;
    }
    
}
