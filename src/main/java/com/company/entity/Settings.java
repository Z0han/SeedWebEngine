package com.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by User on 27.05.2016.
 */

@Entity
@Table(name = "settings")
public class Settings implements Serializable{

    @Id
    private int id;

    @Column(name = "site_title")
    private String siteTitle;

    @Column(name = "theme_pattern_type")
    private String themePatternType;


    public Settings() {}

    public String getSiteTitle() {
        return siteTitle;
    }

    public void setSiteTitle(String siteTitle) {
        this.siteTitle = siteTitle;
    }

    public String getThemePatternType() {
        return themePatternType;
    }

    public void setThemePatternType(String themePatternType) {
        this.themePatternType = themePatternType;
    }
}
