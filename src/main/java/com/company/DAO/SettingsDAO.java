package com.company.DAO;

import com.company.entity.Settings;

/**
 * Created by User on 27.05.2016.
 */
public interface SettingsDAO {

    Settings getSettings();
    void setSettings(Settings settings);
}

