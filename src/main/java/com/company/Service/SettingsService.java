package com.company.Service;

import com.company.entity.Settings;

/**
 * Created by User on 27.05.2016.
 */
public interface SettingsService {

    Settings getSettings();
    void setSettings(Settings s);
}
