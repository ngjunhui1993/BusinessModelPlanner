/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model.entity;

/**
 *
 * @author junhui.ng.2014
 */
public class QadimProduct {
    private String  userID ;
    private String project_name;
    private int productID ;
    private String product_name;

    public QadimProduct(String userID, String project_name, int productID, String product_name) {
        this.userID = userID;
        this.project_name = project_name;
        this.productID = productID;
        this.product_name = product_name;
    }
    
    
    public String getUserID(){
        return userID ;
    }
    
    public String getProjectName(){
        return project_name ;
    }
    
    public int getProductID(){
        return productID;
        
    }

    public String getProductName() {
        return product_name;
    }
    
    public void setUserID(String userID){
        this.userID = userID ;
        
    }
    
    public void setProjectName(String projectName){
        this.project_name = projectName ;
        
    }
    public void setProductID(int productID){
        this.productID = productID ;
        
    }

    public void setProductName(String product_name) {
        this.product_name = product_name;
    }
    


}
