package com.example.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EntertainmentServlet", urlPatterns = "/EntertainmentServlet")
public class EntertainmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String filePath = "C:\\Users\\LinkevichArtem\\Desktop\\entertainments.xml";

        EntertainmentService entertainmentService = new EntertainmentService(filePath);


        request.setAttribute("entertainmentService", entertainmentService);
        request.getRequestDispatcher("entertainments.jsp").forward(request, resp);
    }
}