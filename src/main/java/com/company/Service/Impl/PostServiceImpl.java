package com.company.Service.Impl;

import com.company.DAO.PostDAO;
import com.company.Service.PostService;
import com.company.entity.Post;
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

    @Override
    public void addPost(int authorid, String title, String text) {
        Post post = new Post(authorid, title, text);
        postDAO.addPost(post);
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
}