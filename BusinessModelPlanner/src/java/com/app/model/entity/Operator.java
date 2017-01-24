package com.app.model.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jiaohui.lee.2014
 */
public class Operator {
    private String userid;
    private String operatorName;
    private int productId;
    private int operatorId;
    private String comments;

    public Operator(String userid, String operatorName, int productId, int operatorId, String comments) {
        this.userid = userid;
        this.operatorName = operatorName;
        this.productId = productId;
        this.operatorId = operatorId;
        this.comments = comments;
    }

    public String getUserid() {
        return userid;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public int getProductId() {
        return productId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public String getComments() {
        return comments;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}