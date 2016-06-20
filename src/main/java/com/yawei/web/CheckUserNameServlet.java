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

@WebServlet("/checkusername")
public class CheckUserNameServlet extends HttpServlet{
    private Logger logger= LoggerFactory.getLogger(CheckUserNameServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.setContentType("text/html;charset='utf-8'");
        //不使用缓存
        resp.addHeader("pragma","no-cache");
        resp.addHeader("cache-control","no-cache");
        resp.addHeader("expires","0");

        String username=req.getParameter("username");
        //服务器端中文转换（和客户端配合使用）.getBytes("ISO8859-1"),"utf-8"
        username = new String(username.getBytes("ISO8859-1"),"utf-8");
        logger.debug("username:{}",username);

        PrintWriter out = resp.getWriter();
        if ("wang".equals(username)){
            out.print("no");
        }else {
            out.print("yes");
        }
        out.flush();
        out.close();
    }

}
