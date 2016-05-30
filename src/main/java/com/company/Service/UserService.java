package com.company.Service;

import com.company.entity.User;

import java.util.List;

/**
 * Created by User on 23.05.2016.
 */
public interface UserService {

    void addUser(String email,String pass, String nick);
    void updateUser(User user);
    void removeUser(int id);
    User getUserById (int id);
    User getUserByEmail(String s);
    List<User> getListUser();
}
