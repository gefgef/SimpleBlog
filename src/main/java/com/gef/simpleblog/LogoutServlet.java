package com.gef.simpleblog;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  

        Cookie cookie = new Cookie("user", "");
        cookie.setMaxAge(0);  
        response.addCookie(cookie);
        
        RequestDispatcher view = request.getRequestDispatcher("loginForm.jsp");
        view.forward(request, response);
    }

}
