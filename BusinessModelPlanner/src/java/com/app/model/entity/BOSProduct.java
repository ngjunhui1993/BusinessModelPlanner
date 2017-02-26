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

    public BOSProduct(String userID, String projectName, int productID) {
        this.userID = userID;
        this.projectName = projectName;
        this.productID = productID;
    }
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

}
