package com.yawei.test;

import com.google.gson.Gson;
import com.yawei.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonTestCase {
    @Test
    public void testToObject() {
        User user = new User(1, "刘能", "东北", 50);

        Gson gson = new Gson();
        String json = gson.toJson(user);
        System.out.println(json);
    }

    @Test
    public void testMapToObject() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 2);
        map.put("username", "赵四");
        map.put("address", "沈阳");
        map.put("age", 52);

        Gson gson = new Gson();
        String json = gson.toJson(map);
        System.out.println(json);
    }

    @Test
    public void testArrayToObject() {
        String[] usernames = {"tom", "jim", "lucy", "lily"};

        Gson gson = new Gson();
        String json = gson.toJson(usernames);
        System.out.println(json);
    }

    @Test
    public void testObjectArrayToJson() {
        User[] users = new User[2];
        users[0] = new User(1, "刘能", "东北", 50);
        users[1] = new User(2, "赵四", "东北", 52);

        Gson gson = new Gson();
        String json = gson.toJson(users);
        System.out.println(json);
    }

    @Test
    public void testListToJson() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "刘能", "东北", 50));
        userList.add(new User(2, "赵四", "东北", 52));

        Gson gson = new Gson();
        String json = gson.toJson(userList);
        System.out.println(json);
    }

    @Test
    public void testToJson() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "刘能", "东北", 50));
        userList.add(new User(2, "赵四", "东北", 52));

        Map<String, Object> map = new HashMap<>();
        map.put("id", 2);
        map.put("data", userList);

        Gson gson = new Gson();
        String json = gson.toJson(map);
        System.out.println(json);
    }
}
