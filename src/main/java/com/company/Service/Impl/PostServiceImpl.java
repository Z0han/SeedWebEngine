package com.company.Service.Impl;

import com.company.DAO.PostDAO;
import com.company.Service.CategoryService;
import com.company.Service.PostService;
import com.company.entity.Post;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 23.05.2016.
 */
@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private CategoryService categoryService;

    @Override
    public void addPost(User user, String title, String text, int categoryId) {
        postDAO.addPost(new Post(user, title, text, categoryService.getCategoryById(categoryId)));
    }

    @Override
    public void updatePost(Post p) {

    }

    @Override
    public void removePost(int id) {
        postDAO.deletePost(id);
    }

    @Override
    public List<Post> list() {
        return postDAO.getList();
    }

    @Override
    public List<Post> list(String pattern) {
        return null;
    }

    @Override
    public Post getSinglePostById(int id) {
        return postDAO.getSinglePostById(id);
    }
}
