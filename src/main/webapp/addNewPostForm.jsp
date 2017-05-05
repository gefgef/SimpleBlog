<%@ page import="javax.servlet.http.*" %>
<%@ page import="com.gef.simpleblog.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles.css">
        
        <title>SimpleBlog Admin</title>
    </head>
    <body>
        <%
            String username = "";
            Cookie[] cookies = request.getCookies();
            for (int i=0; i<cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("user")) {
                    username = cookie.getValue();
                }
            }
            %>
        <body class="center">
        <h1>Hello, <%= username %>!</h1>
        <a href="logout">Logout</a>
        <a href="index.jsp">Homepage</a>
        <form action="newpost" method="post">
            <p>Add new post</p>
            <textarea rows="4" cols="50" name="post"></textarea><br>
            <input type="submit" value="Post">
        </form>
    </body>
    </body>
</html>