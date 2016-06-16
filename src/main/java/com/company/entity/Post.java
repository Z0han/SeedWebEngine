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
    private int id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    private String title;

    private String text;

    @Column(name = "date_posted")
    private Date datePosted;

    @OneToOne
    @JoinColumn(name = "category")
    private Category category;


    public Post() {}

    public Post(User author, String title, String text, Category category) {
        this.author = author;
        this.title = title;
        this.text = text;
        this.datePosted = new Date();
        this.category = category;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
