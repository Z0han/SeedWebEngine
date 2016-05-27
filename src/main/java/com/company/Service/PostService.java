package com.company.Service;

import com.company.entity.Post;

import java.util.List;

/**
 * Created by User on 23.05.2016.
 */
public interface PostService {

    void addPost(int authorid, String title, String text);
    void updatePost(Post p);
    void removePost(int id);
    List<Post> list ();
    List<Post> list (String pattern);

}
