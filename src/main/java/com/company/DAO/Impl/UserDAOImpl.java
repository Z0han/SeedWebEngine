package com.company.DAO.Impl;

import com.company.DAO.UserDAO;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by User on 23.05.2016.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager em;

    @Override
    public void addUser(User user) {
        try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public User getUserById(int idUser) {
        Query query = em.createQuery("select u from User u WHERE u.id = :idUser");
        query.setParameter("idUser", idUser);
        return (User) query.getSingleResult();
    }

    @Override
    public User getUserByEmail(String email) {
        Query query = em.createQuery("select u from User u WHERE u.userEmail = :email");
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }

    @Override
    public void removeUser(int id) {
        try {
            em.getTransaction().begin();
            em.remove(id);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public List<User> getUserList() {
        Query query = em.createQuery("from User ");
        return (List<User>) query.getResultList();
    }
}
