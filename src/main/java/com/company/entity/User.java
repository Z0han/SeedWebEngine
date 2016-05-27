package com.company.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by User on 12.05.2016.
 */

@Entity
@Table(name = "users")
public class User implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "user_password")
    private String userPass;

    @Column(name = "registered_date")
    private Date registeredData;

    @Column(name = "user_role")
    private String role;

    public User() {}

    public User(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
        this.registeredData = new Date() ;
        this.role = "USER_ROLE";
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Date getRegisteredData() {
        return registeredData;
    }

    public void setRegisteredData(Date registeredData) {
        this.registeredData = registeredData;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
