package com.company.Service.Impl;

import com.company.DAO.UserDAO;
import com.company.Service.UserService;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 24.05.2016.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public void addUser(String email,String pass) {
        User user = new User(email,pass);
        userDAO.addUser(user);
    }

    @Override
    public void uprateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void removeUser(int id) {
        userDAO.removeUser(id);
    }

    @Override
    public User getUser(int id) {
        User user = userDAO.getUser(id);
        return user;
    }

    @Override
    public List<User> getListUser() {
        return null;
    }
}
