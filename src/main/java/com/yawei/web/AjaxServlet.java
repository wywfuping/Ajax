package com.yawei.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet{

    private Logger logger = LoggerFactory.getLogger(AjaxServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doget...");
        PrintWriter out = resp.getWriter();
        out.print("do get");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String address = req.getParameter("address");

        logger.debug("username:{},address:{}",username,address);

        PrintWriter out = resp.getWriter();
        out.print("do post");
        out.flush();
        out.close();
    }
}
