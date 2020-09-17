package com.bytedance.springboot.web.controller;

import com.bytedance.springboot.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hxl on 2020/9/16.
 */
@Controller
public class UserController {
    @RequestMapping(value = "/user")
    public ModelAndView getUser() {
        User user = new User();
        user.setId(1001);
        user.setAge(43);
        user.setName("lisi");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data", "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        modelAndView.addObject("user", user);
        modelAndView.addObject("ff", "hfgf");
        modelAndView.setViewName("show");
        return modelAndView;
    }

    @RequestMapping(value = "/user2")
    public String getUser2() {

        return "show2";
    }

    @RequestMapping(value = "/user3")
    public ModelAndView getUser3(Integer id, String name, String age) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.addObject("name", name);
        modelAndView.addObject("age", age);
        modelAndView.setViewName("show3");
        return modelAndView;
    }

    @RequestMapping(value = "/user4")
    public ModelAndView getUser4() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("lisi::" + i);
            user.setId(666);
            user.setAge(99);
            userList.add(user);
        }
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping(value = "/user5")
    public ModelAndView getUser5() {
        ModelAndView modelAndView = new ModelAndView();
        Map<Object, User> userMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("lisi::" + i);
            user.setId(666);
            user.setAge(99);
            userMap.put(i, user);
        }
        modelAndView.addObject("userMaps", userMap);
        modelAndView.setViewName("map");
        return modelAndView;
    }

    @RequestMapping(value = "/user6")
    public ModelAndView getUser6() {
        ModelAndView modelAndView = new ModelAndView();
        User[] userArray = new User[10];
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("lisi::" + i);
            user.setId(666);
            user.setAge(99);
            userArray[i] = user;
        }

        modelAndView.addObject("userArrays", userArray);
        modelAndView.setViewName("array");
        return modelAndView;
    }

    @RequestMapping(value = "/user7")
    public ModelAndView getUser7() {
        ModelAndView modelAndView = new ModelAndView();
        List<Map<Object, List<User>>> all = new ArrayList<>();

        for (int i1 = 0; i1 < 2; i1++) {
            Map<Object, List<User>> userMap = new HashMap<>();
            for (int j = 0; j < 2; j++) {
                List<User> userList = new ArrayList<>();
                for (int i2 = 0; i2 < 10; i2++) {
                    User user = new User();
                    user.setName("lisi::" + i2 + "  j=" + j + "  i1=" + i1);
                    user.setId(666);
                    user.setAge(99);
                    userList.add(user);
                }
                userMap.put(j, userList);
            }
            all.add(userMap);
        }
        modelAndView.addObject("all", all);
        modelAndView.setViewName("all");
        System.out.println("all的size::" + all.size());
        //    Map<Object, List<User>> objectListMap = all.get(0);


        for (Map<Object, List<User>> objectListMap : all) {
            for (Object o : objectListMap.keySet()) {
                System.out.println("key:" + o);
                System.out.println("value:::::::::");
                List<User> userList = objectListMap.get(o);
                for (User user : userList) {
                    System.out.println(user);
                }
            }
        }
        return modelAndView;
    }
}

