package com.yawei.web;


import com.yawei.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/load")
public class LoadServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url=req.getParameter("url");

        String xmlHttp= HttpUtil.getText(url);
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter out= resp.getWriter();
        out.print(xmlHttp);
        out.flush();
        out.close();
    }
}
