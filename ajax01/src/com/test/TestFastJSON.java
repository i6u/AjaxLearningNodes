package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.com.util.Conversion;
import com.model.bean.Gender;
import com.model.bean.JSONTest;
import com.model.bean.Person;
import com.model.bean.Regions;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * Created by zhouweitao on 16/8/29.
 */
public class TestFastJSON {

    @Test
    public void fastJSON01() {
        //序列化
        Person person = new Person(1, "jobs", 123.12f, Gender.MAN);
        //JavaBean-->JSON
        String s = JSON.toJSONString(person);
        System.out.println(s);
        //SerializerFeature,序列化器特性
        String s1 = JSON.toJSONString(person, SerializerFeature.PrettyFormat, SerializerFeature.UseSingleQuotes);
        System.out.println(s1);
        //日期格式化
        String d1 = JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat);
        System.out.println(d1);
        String d2 = JSON.toJSONStringWithDateFormat(new Date(), "yyyy/MM/dd HH:mm:ss");
        System.out.println(d2);
        //序列化时写入类信息
        String s2 = JSON.toJSONString(person, SerializerFeature.WriteClassName);
        System.out.println(s2);
        Person p1 = (Person) JSON.parse(s2);//序列化时写入类信息,反序列化就会自动找到类,强转不会出错
        System.out.println(p1);
        //浏览器和设备兼容
        String s3 = JSON.toJSONString(person, SerializerFeature.BrowserCompatible);
        System.out.println(s3);
    }

    @Test
    public void fastJSON02() {
        //反序列化
        String txt = "{\"gender\":\"MAN\",\"id\":1,\"name\":\"jobs\",\"salary\":123.12000274658203}";
        //指定Class信息
        Person p1 = JSON.parseObject(txt, Person.class);
        System.out.println(p1.getGender());
        //集合类型反序列化
        String txt1 = Conversion.fileToString("web/data/a.json", null, 512);
        List<Regions> regionsList = JSON.parseArray(txt1, Regions.class);
        System.out.println(regionsList.get(27).toString());
        //泛型的反序列化
        String txt2 = "{1:{\"name\":\"fastJson\",age:8}}";
        Map<Integer, JSONTest> map = JSON.parseObject(txt2, new TypeReference<Map<Integer, JSONTest>>() {});
        System.out.println(map.get(1));

    }

    @Test
    public void fast01() {
        long startTime = System.currentTimeMillis();   //获取开始时间
        Conversion.fileToString("web/data/regions.json", "utf-8", 512);
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    @Test
    public void fast02() {
        List<Regions> regionses;
        String txt = Conversion.fileToString("web/data/regions.json", "utf-8", 64);
        long start = System.currentTimeMillis();
        regionses = JSON.parseArray(txt, Regions.class);
        long end = System.currentTimeMillis();
        System.out.println(regionses.size());
        System.out.println("程序运行时间： " + (end - start) + "ms");
    }

    @Test
    public void jackson01() {
        List<Regions> list = null;
        String txt = Conversion.fileToString("web/data/regions.json", "utf-8", 64);
        long start = System.currentTimeMillis();
        ObjectMapper mapper = new ObjectMapper();
        try {
            list = mapper.readValue(txt, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(list.size());
        System.out.println(list.get(2));
        System.out.println("程序运行时间： " + (end - start) + "ms");
    }

    @Test
    public void stringToFile() {
        String txt = Conversion.fileToString("web/data/regions.json", "utf-8", 512);
        System.out.println(Conversion.StringToFile(txt, "/Users/zhouweitao/Desktop/data/a.json", 1024));
    }
}
