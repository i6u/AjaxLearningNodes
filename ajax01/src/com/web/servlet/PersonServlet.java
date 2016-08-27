package com.web.servlet;

import com.model.bean.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouweitao on 16/8/28.
 */
public class PersonServlet extends HttpServlet {
    private Map<Integer, List<Person>> persons = new HashMap<Integer, List<Person>>();
    public PersonServlet() {
        System.out.println("PersonServlet Constructor");
        List<Person> ps = new ArrayList<>();
        ps.add(new Person(1,"刘邦",5000f));
        ps.add(new Person(2,"曹操",7000f));
        ps.add(new Person(3,"孙权",6000f));
        persons.put(1, ps);
        List<Person> ps1 = new ArrayList<>();
        ps1.add(new Person(11,"jobs",15000f));
        ps1.add(new Person(12,"mark",17000f));
        ps1.add(new Person(13,"jack",16000f));
        persons.put(2, ps1);
        List<Person> ps2 = new ArrayList<>();
        ps2.add(new Person(21,"马云",25000f));
        ps2.add(new Person(22,"王健林",27000f));
        ps2.add(new Person(23,"丁磊",26000f));
        persons.put(3, ps2);
    }

    public void init() throws ServletException {
        System.out.println("PersonServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml;charset=utf-8");
        Writer out = resp.getWriter();
        int did = Integer.parseInt(req.getParameter("did"));
        List<Person> ps = persons.get(did);
        StringBuffer psb = new StringBuffer();
        psb.append("<persons>");
        for (Person p : ps) {
            psb.append("<person>");
            psb.append("<id>"+ p.getId() +"</id>");
            psb.append("<name>"+ p.getName() +"</name>");
            psb.append("<salary>"+ p.getSalary() +"</salary>");
            psb.append("</person>");
        }
        psb.append("</persons>");
        out.write(psb.toString());
        out.flush();
    }
    public void destroy() {
        System.out.println("PersonServlet destroy");
    }
}
