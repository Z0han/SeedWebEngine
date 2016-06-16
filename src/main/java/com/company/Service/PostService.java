package com.company.Service;

import com.company.entity.Post;
import com.company.entity.User;

import java.util.List;

/**
 * Created by User on 23.05.2016.
 */
public interface PostService {

    void addPost(User user, String title, String text, int categoryId);
    void updatePost(Post p);
    void removePost(int id);
    List<Post> list ();
    List<Post> list (String pattern);
    Post getSinglePostById(int id);

}
