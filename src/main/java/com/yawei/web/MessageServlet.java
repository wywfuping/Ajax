package com.yawei.web;

import com.google.gson.Gson;
import com.yawei.entity.Message;
import com.yawei.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/message")
public class MessageServlet extends HttpServlet{

    private Logger logger= LoggerFactory.getLogger(MessageServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> messageList = new MessageService().findAll();
        req.setAttribute("messageList",messageList);
        logger.debug("{}",messageList);
        int maxId=0;
        if(!messageList.isEmpty()){
            maxId=messageList.get(0).getId();
        }
        req.setAttribute("maxId",maxId);
        req.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maxId = req.getParameter("maxId");

        List<Message> messageList = new MessageService().findMsgById(maxId);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(new Gson().toJson(messageList));
        out.flush();
        out.close();
    }
}
