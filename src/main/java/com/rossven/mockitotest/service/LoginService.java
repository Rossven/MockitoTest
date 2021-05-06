package com.rossven.mockitotest.service;


import com.rossven.mockitotest.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

        @Autowired
        public UserDao userDao;

        public boolean canLogin(String userName, String userPassword) {
            User user = userDao.findUserByName(userName);
            if(user.getUserName().equals(userName) && user.getUserPassword().equals(userPassword) )
                return true;
            else
                return false;

        }
    }

