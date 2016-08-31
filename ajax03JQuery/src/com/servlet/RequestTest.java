package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Created by zhouweitao on 16/8/31.
 * 测试
 */
@WebServlet(name = "RequestTest",urlPatterns = "/requestTest.do")
public class RequestTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String arg = request.getParameter("arg");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String msg = null;
        if (arg == null) {
            msg = "load,请求参数为空,get请求";
        } else {
            msg = "load,请求参数为"+arg+",post请求";
        }
        out.write(msg);
        //out.print(msg);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
