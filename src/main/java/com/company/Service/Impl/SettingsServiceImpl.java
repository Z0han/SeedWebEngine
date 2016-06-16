package com.company.Service.Impl;

import com.company.DAO.SettingsDAO;
import com.company.Service.SettingsService;
import com.company.entity.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 27.05.2016.
 */
@Service
public class SettingsServiceImpl implements SettingsService {

    @Autowired
    private SettingsDAO settingsDAO;

    @Override
    public Settings getSettings() {
        return settingsDAO.getSettings();
    }

    @Override
    public void setSettings(String st, String sp,String sd) {
        settingsDAO.setSettings(st, sp, sd);
    }

    @Override
    public void setSettings(Settings newSettings) {

    }
}
