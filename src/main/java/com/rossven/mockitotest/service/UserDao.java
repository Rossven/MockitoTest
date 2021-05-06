package com.rossven.mockitotest.service;

import com.rossven.mockitotest.User;
import org.springframework.stereotype.Service;

@Service
public class UserDao {

    //Database init
    User user = new User("Rossven","asd123");

    public User findUserByName(String userName){

        if (user.getUserName().equals("Rossven")){
            return user;
        }
        else
            return user;
    }

}