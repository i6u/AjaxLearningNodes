package com.servlet;

import com.util.Conversion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhouweitao on 16/8/31.
 */
@WebServlet(name = "XMLServlet", urlPatterns = "/xml.do")

public class XMLServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("xml.do");
        String path = request.getSession().getServletContext().getRealPath("/data");
        String xmlStr = Conversion.fileToString(path+"/users.xml", "utf-8", 1024);
        PrintWriter out = response.getWriter();
        out.write(xmlStr);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
