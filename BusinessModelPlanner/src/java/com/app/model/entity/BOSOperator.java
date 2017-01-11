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
    private int productID;
    private int operatorID;
    private String operatorName;
    private int maxValue;
    private int weight;
    private int perUnitValue;
    private int originalValue;
    private int newValue;
    private String originalProductName;

    public BOSOperator(String userid, String projectName, int productID, int operatorID, String operatorName, int weight, int maxValue, int perUnitValue, int originalValue, int newValue, String originalProductName) {
        this.userid = userid;
        this.projectName = projectName;
        this.productID = productID;
        this.operatorID = operatorID;
        this.operatorName = operatorName;
        this.maxValue = maxValue;
        this.weight = weight;
        this.perUnitValue = perUnitValue;
        this.originalValue = originalValue;
        this.newValue = newValue;
        this.originalProductName = originalProductName;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(int operatorID) {
        this.operatorID = operatorID;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPerUnitValue() {
        return perUnitValue;
    }

    public void setPerUnitValue(int perUnitValue) {
        this.perUnitValue = perUnitValue;
    }

    public int getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(int originalValue) {
        this.originalValue = originalValue;
    }

    public int getNewValue() {
        return newValue;
    }

    public void setNewValue(int newValue) {
        this.newValue = newValue;
    }

    public String getOriginalProductName() {
        return originalProductName;
    }

    public void setOriginalProductName(String originalProductName) {
        this.originalProductName = originalProductName;
    }
    
    
}
