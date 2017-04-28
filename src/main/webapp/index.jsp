<%@ page import="java.util.*" %>
<%@ page import="com.gef.simpleblog.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles.css">
        
        <title>SimpleBlog</title>
    </head>
    <body class="center">
        <h1>SimpleBlog</h1>
        <%
            //try {
            ArrayList<BlogEntry> entries = JDBCMethods.getAllEntries();
            for (BlogEntry entry : entries) {
                out.println("<div class='entry'><p style='font-weight:bold'}>"+ entry.getAuthor() + " wrote: </p>");
                out.println("<p>" + entry.getPost() + "</p></div>");
            }
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
            %>
        <a href="admin">Admin</>
    </body>
</html>
