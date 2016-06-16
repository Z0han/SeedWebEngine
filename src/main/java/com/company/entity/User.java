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
    private int id;

    @Column(name = "username")
    private String userEmail;

    @Column(name = "user_password")
    private String userPass;

    @Column(name = "registered_date")
    private Date registeredData;

    @Column(name = "user_role")
    private String role;

    @Column(name = "nickname")
    private String nickname;

    public User() {}

    public User(String userEmail, String userPass, String nick) {
        this.userEmail = userEmail;
        this.userPass = userPass;
        this.registeredData = new Date() ;
        this.role = "USER";
        this.nickname = nick;
    }

    public int getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
