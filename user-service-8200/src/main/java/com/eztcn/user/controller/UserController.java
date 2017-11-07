package com.eztcn.user.controller;

import com.eztcn.api.bean.User;
import com.eztcn.user.service.UserService;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public String getUserName() {
        User user = userService.findById(5);
        return user.getChineseName();
    }

    //根据ID获取用户信息
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@RequestParam Integer id) {
        return userService.findById(id);
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
