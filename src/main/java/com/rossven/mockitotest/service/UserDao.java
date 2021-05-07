package com.rossven.mockitotest.service;

import com.rossven.mockitotest.User;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserDao {


    public List<User> setUsers() {
        return List.of(
                new User("Rossven", "111222"),
                new User("Atakan", "112233")
        );
    }


    List<User> userList = setUsers();


    public User findUserByName(String Name) {

        User usr = null;
        for(User d : userList){
            if (d.getUserName() != null && d.getUserName().equals(Name)) {
                usr=d;
                break;
            }
            else {
                usr= null;
            }
        }

        return usr;
    }

}