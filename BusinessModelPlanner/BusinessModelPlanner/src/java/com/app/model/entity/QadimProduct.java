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
    private String productID ;
    public QadimProduct(String userID , String project_name , String productID){
        this.userID = userID ;
        this.project_name = project_name ;
        this.productID = productID ;
        
    }
    
    public String getUserID(){
        return userID ;
    }
    
    public String getProjectName(){
        return project_name ;
    }
    
    public String getProductID(){
        return productID;
        
    }
    
    public void setUserID(String userID){
        this.userID = userID ;
        
    }
    
    public void setProjectName(String projectName){
        this.project_name = projectName ;
        
    }
    public void setProductID(String productID){
        this.productID = productID ;
        
    }
    


}
