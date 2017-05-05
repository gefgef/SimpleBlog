package com.gef.simpleblog;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AddNewPost.do", urlPatterns = {"/newpost"})
public class AddNewPost extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (CookieMethods.isUserCookiePresent(request)) {
            String username = CookieMethods.getUserName(request);
            String post = request.getParameter("post");
            try {
                JDBCMethods.addNewPost(username, post);
            } catch (ClassNotFoundException | SQLException | NamingException e) {
                e.printStackTrace();
            } 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>SimpleBlog Admin</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">");
            out.println("</head>");
            out.println("<body class='center'>");
            out.println("<h3>Your post has been successfully added!</h3>");
            out.println("<a href='admin'>Return to Admin Panel</a>");
            out.println("<a href='index.jsp'>Homepage</a>");
            out.println("</body>");
            out.println("</html>");
        } else {
            //TODO: login page
        }
    }

    

}
