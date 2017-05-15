package com.gef.simpleblog;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AdminPanel", urlPatterns = {"/admin"})
public class AdminPanel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (CookieMethods.isUserCookiePresent(request)) {
            RequestDispatcher view = request.getRequestDispatcher("addNewPostForm.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("loginForm.jsp");
            view.forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (JDBCMethods.isUserExisted(request.getParameter("user"), request.getParameter("password"))) {
                Cookie cookie = new Cookie("user", request.getParameter("user"));
                cookie.setMaxAge(30*60);
                response.addCookie(cookie);
                
                RequestDispatcher view = request.getRequestDispatcher("addNewPostForm.jsp");
                view.forward(request, response);
            } else {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>SimpleBlog Admin</title>");
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">");
                out.println("</head>");
                out.println("<body class='center'>");
                out.println("<h3>Wrong password or user '" + request.getParameter("user") + "' does not exist</h3>");
                out.println("<a href='admin'>Login again</a>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (ClassNotFoundException | SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
    
}