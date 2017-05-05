<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles.css">
        
        <title>SimpleBlog Admin</title>
    </head>
    <body class="center">
        <h1>Please login</h1>
        <form action="admin" method="post">
            Username: <input type="text" name="user"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
