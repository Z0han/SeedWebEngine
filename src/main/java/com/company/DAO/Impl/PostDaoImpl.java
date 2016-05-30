package com.company.DAO.Impl;

import com.company.DAO.PostDAO;
import com.company.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 20.05.2016.
 */
@Repository
public class PostDaoImpl  implements PostDAO {

    @Autowired
    private EntityManager em;

    @Override
    public void addPost(Post p) {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void updatePost(Post p) {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    @Override
    public void deletePost(int id) {
        try {
            em.getTransaction().begin();
            Post p = em.find(Post.class, id);
            em.remove(p);
            em.getTransaction().commit();
        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public List<Post> getList() {
        Query query = em.createQuery("SELECT a FROM Post a");
        return (List<Post>) query.getResultList();
    }

    @Override
    public List<Post> getList(String pattern) {
        return null;
    }

    @Override
    public Post getSinglePostById(int id) {
        Query query = em.createQuery("select p FROM Post p WHERE p.id = :id");
        query.setParameter("id", id);
        return (Post)query.getSingleResult();
    }
}
