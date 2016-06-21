package com.yawei.web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/book.xml")
public class BookXmlServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml;charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        out.println("<books>");
        out.println("<book id=\"101\">");
        out.println("<bookname>把时间当作朋友</bookname>");
        out.println("<author>李笑来</author>");
        out.println("<price>42</price>");
        out.println("<publishing>人民出版社</publishing>");
        out.println("</book>");
        out.println("<book id=\"102\">");
        out.println("<bookname>我喜欢这个功利的世界</bookname>");
        out.println("<author>咪蒙</author>");
        out.println("<price>30</price>");
        out.println("<publishing>中国邮电出版社</publishing>");
        out.println("</book>");
        out.println("<book id=\"103\">");
        out.println("<bookname>目送</bookname>");
        out.println("<author>龙应台</author>");
        out.println("<price>28</price>");
        out.println("<publishing>工业出版社</publishing>");
        out.println("</book>");
        out.println("<book id=\"104\">");
        out.println("<bookname>汪国真诗集</bookname>");
        out.println("<author>汪国真</author>");
        out.println("<price>35</price>");
        out.println("<publishing>机械出版社</publishing>");
        out.println("</book>");
        out.println("</books>");

        out.flush();
        out.close();
    }
}
