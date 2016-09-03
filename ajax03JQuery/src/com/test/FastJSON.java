package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bean.User;
import com.util.Conversion;
import org.junit.Test;

import java.util.List;

/**
 * Created by zhouweitao on 16/9/1.
 */
public class FastJSON {
    @Test
    public void test01() {
        String strs = Conversion.fileToString("web/data/users.json", null, 1024);
        List<User> users = JSONArray.parseArray(strs, User.class);
        String jsons = JSON.toJSONString(users);
        System.out.println(jsons);

    }
}
