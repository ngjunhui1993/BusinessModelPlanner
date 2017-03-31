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
public class BOSProduct {
    private String  userID ;
    private String projectName;
    private int productID ;
    private int originalCost;
    private int budgetRequired;

    public BOSProduct(String userID, String projectName, int productID, int originalCost, int budgetRequired) {
        this.userID = userID;
        this.projectName = projectName;
        this.productID = productID;
        this.originalCost = originalCost;
        this.budgetRequired = budgetRequired;
    }

    public String getUserID() {
        return userID;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getProductID() {
        return productID;
    }

    public int getOriginalCost() {
        return originalCost;
    }

    public int getBudgetRequired() {
        return budgetRequired;
    }

    
}
