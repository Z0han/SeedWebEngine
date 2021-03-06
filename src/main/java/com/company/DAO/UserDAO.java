package com.company.DAO;

import com.company.entity.User;

import java.util.List;

/**
 * Created by User on 12.05.2016.
 */
public interface UserDAO {

    void addUser(User user);
    void removeUser(int id);
    void updateUser(User user);
    User getUserById(int id);
    User getUserByEmail(String s);
    List<User> getUserList();

}
