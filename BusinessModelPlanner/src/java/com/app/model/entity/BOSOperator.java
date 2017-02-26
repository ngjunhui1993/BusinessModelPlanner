/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model.entity;

/**
 *
 * @author Dell
 */
public class BOSOperator {
    private String userid;
    private String projectName;
    private int factorid;
    private String factorName;
    private int weight;
    private int grid;
    private int perUnitValue;
    private int originalValue;
    private int newValue;

    public BOSOperator(String userid, String projectName, int factorid, String factorName, int weight, int grid, int perUnitValue, int originalValue, int newValue) {
        this.userid = userid;
        this.projectName = projectName;
        this.factorid = factorid;
        this.factorName = factorName;
        this.weight = weight;
        this.grid = grid;
        this.perUnitValue = perUnitValue;
        this.originalValue = originalValue;
        this.newValue = newValue;
    }

    public String getUserid() {
        return userid;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getFactorid() {
        return factorid;
    }

    public String getFactorName() {
        return factorName;
    }

    public int getWeight() {
        return weight;
    }

    public int getGrid() {
        return grid;
    }

    public int getPerUnitValue() {
        return perUnitValue;
    }

    public int getOriginalValue() {
        return originalValue;
    }

    public int getNewValue() {
        return newValue;
    }

    
}