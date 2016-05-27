package com.company.Service;

import com.company.entity.User;

import java.util.List;

/**
 * Created by User on 23.05.2016.
 */
public interface UserService {

    void addUser(String email,String pass);
    void uprateUser(User user);
    void removeUser(int id);
    User getUser (int id);
    List<User> getListUser();
}
