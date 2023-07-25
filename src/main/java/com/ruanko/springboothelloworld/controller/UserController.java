package com.ruanko.springboothelloworld.controller;

import com.ruanko.springboothelloworld.entity.User;
import com.ruanko.springboothelloworld.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String show(){return "login";}

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String username, String password, Model model){
        User user = userService.loginIn(username, password);
        if(user != null){
            return "success";
        }
        else{
            model.addAttribute("msg","账号密码错误");
            return "login";
        }
    }

    @RequestMapping("/signup")
    public String regist(){
        return "signup";
    }
    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    public String signup(String username,String password){
        userService.signUp(username,password);
        return "success2";
    }
}
