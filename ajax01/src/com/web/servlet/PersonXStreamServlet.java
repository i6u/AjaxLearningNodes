package com.web.servlet;

import com.model.bean.Gender;
import com.model.bean.Person;
import com.thoughtworks.xstream.XStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouweitao on 16/8/29.
 */
@WebServlet(
        name = "PersonXStreamServlet",
        urlPatterns = "/PXStream.do"//访问的url
)
public class PersonXStreamServlet extends HttpServlet {

    private Map<Integer, List<Person>> persons = new HashMap<Integer, List<Person>>();


    public PersonXStreamServlet() {
        System.out.println("PersonServlet Constructor");
        List<Person> ps = new ArrayList<>();
        ps.add(new Person(1, "刘邦", 5000.00f, Gender.MAN));
        ps.add(new Person(2, "曹操", 7000.00f, Gender.MAN));
        ps.add(new Person(3, "孙权", 6000.00f, Gender.MAN));
        persons.put(1, ps);
        List<Person> ps1 = new ArrayList<>();
        ps1.add(new Person(11, "jobs", 15000.00f, Gender.MAN));
        ps1.add(new Person(12, "mark", 17000.00f, Gender.MAN));
        ps1.add(new Person(13, "jack", 16000.00f, Gender.MAN));
        persons.put(2, ps1);
        List<Person> ps2 = new ArrayList<>();
        ps2.add(new Person(21, "马云", 25000.00f, Gender.MAN));
        ps2.add(new Person(22, "王健林", 27000.00f, Gender.MAN));
        ps2.add(new Person(23, "丁磊", 26000.00f, Gender.MAN));
        persons.put(3, ps2);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/xml;charset=utf-8");
        int did = Integer.parseInt(request.getParameter("did"));
        List<Person> person = persons.get(did);
        XStream xStream = new XStream();
        xStream.alias("person", Person.class);//修改类的节点名称
        xStream.alias("persons", List.class);//修改类的节点名称
        xStream.aliasField("username", Person.class, "name");//修改属性的节点名称
        //xStream.useAttributeFor(Person.class,"id");//把类的属性作为标签的属性
        String px = xStream.toXML(person);

        //xml转对象
        //List<Person> ls = (List<Person>) xStream.fromXML(PersonXStreamServlet.class.getClassLoader().getResourceAsStream("users.xml"));
        //for (Person l : ls) {
        //    System.out.println(l.toString()+"!");
        //}

        PrintWriter out = response.getWriter();
        out.write(px);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
