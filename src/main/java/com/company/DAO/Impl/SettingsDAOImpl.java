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
    public void setSettings(String siteTitle, String sitePattern, String siteDescription) {
        Query query = em.createQuery("select s FROM Settings s WHERE s.id = 1");
        Settings settingsFromDataBase = (Settings) query.getSingleResult();
        settingsFromDataBase.setSiteTitle(siteTitle);
        settingsFromDataBase.setThemePatternType(sitePattern);
        settingsFromDataBase.setSiteDescription(siteDescription);
        try{
            em.getTransaction().begin();
            em.merge(settingsFromDataBase);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }
}
