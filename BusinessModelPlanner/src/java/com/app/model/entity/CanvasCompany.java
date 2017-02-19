/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model.entity;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class CanvasCompany {
    private String company;
    private String choice;
    private String description;
    private ArrayList<String> choices;

    public CanvasCompany(String company, String choice, String description) {
        this.company = company;
        this.choice = choice;
        this.description = description;
    }
    
    public CanvasCompany(String company, ArrayList<String> choices, String description) {
        this.company = company;
        this.choices = choices;
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public String getChoice() {
        return choice;
    }

    public String getDescription() {
        return description;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
