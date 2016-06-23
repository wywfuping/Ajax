package com.yawei.web;


import com.google.gson.Gson;
import com.yawei.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user.json")
public class UserJsonServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "刘能", "东北", 50));
        userList.add(new User(2, "赵四", "东北", 52));
        userList.add(new User(3, "谢广坤", "东北", 54));

        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(new Gson().toJson(userList));
        out.flush();
        out.close();
    }
}
