package com.yawei.web;

import com.yawei.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dict")
public class DictServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("q");

        word = new String(word.getBytes("ISO8859-1"), "utf-8");
        String url = "http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=data&version=1.1&q=" + word;
        String xmlHttp = HttpUtil.getText(url);

        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(xmlHttp);
        out.flush();
        out.close();
    }
}
