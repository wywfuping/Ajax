package com.yawei.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part= req.getPart("file");
        String fileName = getFileName(part);
        System.out.println("fileName"+fileName);
    }

    private String getFileName(Part part){
        String handleVal=part.getHeader("Content-Disposition");

        handleVal = handleVal.substring(handleVal.indexOf("filename=\""));
        handleVal= handleVal.substring(handleVal.indexOf("\"")+1,handleVal.length()-1);
        return handleVal;
    }
}
