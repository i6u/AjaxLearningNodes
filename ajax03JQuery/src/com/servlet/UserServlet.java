package com.servlet;

import com.alibaba.fastjson.JSON;
import com.bean.User;
import com.util.Conversion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by zhouweitao on 16/8/31.
 */
@javax.servlet.annotation.WebServlet(name = "UserServlet", urlPatterns = "/users.do")
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.printf("user.do");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String sid = request.getParameter("id");
        if (sid == null) {
            out.write("<script>alert('没有指定用户ID');</script>");
            out.close();
            return;
        }
        int uid = Integer.parseInt(sid);
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF");
        String JSON = Conversion.fileToString(path + "/data/users.json", null, 1024);
        //List<User> users = JSON.parseArray(JSON, User.class);
        //String str = users.get(uid).toString();
        out.write(JSON);
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
