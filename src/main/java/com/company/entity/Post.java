package com.company.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by User on 12.05.2016.
 */


@Entity
@Table(name = "posts")
public class Post implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "author_id")
    private int authorId;

    private String title;

    private String text;

    @Column(name = "author_nickname")
    private String authorNickName;

    @Column(name = "date_posted")
    private Date datePosted;


    public Post() {}

    public Post(int authorId, String title, String text, String nick) {
        this.authorId = authorId;
        this.title = title;
        this.text = text;
        this.datePosted = new Date();
        this.authorNickName = nick;
    }


    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public int getId () {
        return id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthorNickName() {
        return authorNickName;
    }

    public void setAuthorNickName(String authorNickName) {
        this.authorNickName = authorNickName;
    }
}
