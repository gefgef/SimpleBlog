package com.gef.simpleblog;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AdminPanel.do", urlPatterns = {"/admin"})
public class AdminPanel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SimpleBlog Admin</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet MainServlet at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");*/
        RequestDispatcher view = request.getRequestDispatcher("loginForm.jsp");
        view.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SimpleBlog Admin</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet MainServlet at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
