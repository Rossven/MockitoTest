package com.rossven.mockitotest.controller;

import com.rossven.mockitotest.User;
import com.rossven.mockitotest.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    User user = new User("Rossven","asd123");

    private LoginService loginService;

    @Autowired
    public UserController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(path = "/user",method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public String isLogin(){

        if(loginService.canLogin(user.getUserName(),user.getUserPassword())==true){
            return ("Login Succsesful"+  '\n' +user.toString());
        }
        else{
            return "Login Unsuccsesful";
        }
    }

}