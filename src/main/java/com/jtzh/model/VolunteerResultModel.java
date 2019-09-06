package com.jtzh.model;

import java.util.Date;

/**
 * Author: asher
 * date: 2019/02/15
 */
public class VolunteerResultModel {

    private String month;

    private Integer cultureSport;

    private Integer theory;

    private Integer health;

    private Integer technology;

    private Integer education;

    private Integer other;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getCultureSport() {
        return cultureSport;
    }

    public void setCultureSport(Integer cultureSport) {
        this.cultureSport = cultureSport;
    }

    public Integer getTheory() {
        return theory;
    }

    public void setTheory(Integer theory) {
        this.theory = theory;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getTechnology() {
        return technology;
    }

    public void setTechnology(Integer technology) {
        this.technology = technology;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getOther() {
        return other;
    }

    public void setOther(Integer other) {
        this.other = other;
    }
}
