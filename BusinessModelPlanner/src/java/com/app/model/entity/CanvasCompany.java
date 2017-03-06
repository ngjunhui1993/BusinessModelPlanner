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
    private String valueDriver;

    public CanvasCompany(String company, String choice, String description, String valueDriver) {
        this.company = company;
        this.choice = choice;
        this.description = description;
        this.valueDriver = valueDriver;
    }
    
    public CanvasCompany(String company, ArrayList<String> choices, String description, String valueDriver) {
        this.company = company;
        this.choices = choices;
        this.description = description;
        this.valueDriver = valueDriver;
    }

    public String getCompany() {
        return company;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    public void setValueDriver(String valueDriver) {
        this.valueDriver = valueDriver;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public String getValueDriver() {
        return valueDriver;
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
