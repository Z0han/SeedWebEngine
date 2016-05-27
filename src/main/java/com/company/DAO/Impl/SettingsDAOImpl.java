package com.company.DAO.Impl;

import com.company.DAO.SettingsDAO;
import com.company.entity.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by User on 27.05.2016.
 */

@Repository
public class SettingsDAOImpl implements SettingsDAO{

    @Autowired
    private EntityManager em;

    @Override
    public Settings getSettings() {
        Query query = em.createQuery("from Settings");
        return (Settings) query.getSingleResult();
    }

    @Override
    public void setSettings(Settings settings) {

    }
}
