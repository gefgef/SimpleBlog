package com.gef.simpleblog;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>TestServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Servlet TestServlet at " + request.getContextPath() + "</h2>");
        out.println("<form method=\"post\" action=\"TestServlet\"><input type=\"text\" name=\"string\">");
        out.println("<input type=\"submit\" value=\"Calculate\"></form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int number = Parser.parseAndSum(request.getParameter("string"));
        out.println("<p>Sum of " + request.getParameter("string") + " = " + number + "</p>");
    }


}
