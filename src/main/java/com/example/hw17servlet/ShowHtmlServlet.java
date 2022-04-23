package com.example.hw17servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowHtmlServlet", value = "/ShowHtmlServlet")
public class ShowHtmlServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Now that you'r an HTML5 ninja,it's time for you to show us what you can do.Have a look at the html files we created throughout the course as\n" +
                "reference.Now go and try making your own website with just HTML5! Once you are done, share your website with the slack community and\n" +
                "fellow students of this course! I will also be checking the #html channel with any new submissions. You can send your files as a message or wait\n" +
                "until later on in the course where I show  you how to put it online for free.\n" +
                "I will be picking my favourite ones and showcasing them in a future video in the course.\n" +
                "    Good luck!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p>" + message + "</p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}