package com.test;

import com.model.bean.User;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
/**
 * 1.9版本
 * */
import org.codehaus.jackson.map.ObjectMapper;



/**
 * Created by zhouweitao on 16/8/29.
 */
public class TestJackson {

    /**
     * 1.9版本
     */
    @Test
    public void test01() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            //User user = mapper.readValue(TestJackson.class.getClassLoader().getResource("user.json"), User.class);//user.json在src下使用
            User user = mapper.readValue(new File("user.json"), User.class);
            //System.out.println(user.toString());
            user.setGender(User.Gender.FEMALE);
            mapper.writeValue(new File("jackson-write-user.json"), user);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
