package com.eztcn.user.controller;

import com.eztcn.api.bean.User;
import com.eztcn.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: zouxiliang
 * @Description:
 * @Date: Created in 18:26 2017/10/23
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    //获取用户名
    @RequestMapping(value = "/getUserName", method = RequestMethod.GET)
    public String getUserName() {
        User user = userService.findById(5);
        return user.getChineseName();
    }

    //根据ID获取用户信息
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public User getUserById(@RequestParam Integer id) {
        return userService.findById(id);
    }

    //首页
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    //登录页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "templates/login.html";
    }


    /**
     * 获取sessionId
     * @param request
     * @return
     */
    @RequestMapping("/getSession")
    public Object getSession(HttpServletRequest request) {
        return request.getSession().getId();
    }
}
