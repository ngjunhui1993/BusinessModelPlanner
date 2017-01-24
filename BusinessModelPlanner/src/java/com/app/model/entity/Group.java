/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model.entity;

/**
 *
 * @author jiaohui.lee.2014
 */
public class Group {
    private String course;
    private String section;
    private String instructorEmail;
    private String password;

    public Group(String course, String section, String instructorEmail, String password) {
        this.course = course;
        this.section = section;
        this.instructorEmail = instructorEmail;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getCourse() {
        return course;
    }

    public String getSection() {
        return section;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
