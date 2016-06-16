package com.company.DAO;

import com.company.entity.Category;
import com.company.entity.Post;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 12.05.2016.
 */
public interface PostDAO {

    void addPost(Post p);
    void updatePost(Post p);
    void deletePost(int id);
    List<Post> getList();
    List<Post> getList(String pattern);
    Post getSinglePostById(int id);
    List<Post> getListPostByCategory(Category category);

}
