package com.app.model;

import java.util.HashMap;

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
    private String operatorName;
    private String verb;
    private String generalPhrase;
    private String specificPhrase;
    private String dimensions;
    private int productId;
    private int operatorId;

    public Operator(String operatorName, String verb, String generalPhrase, String specificPhrase, String dimensions, int productId, int operatorId) {
        this.operatorName = operatorName;
        this.verb = verb;
        this.generalPhrase = generalPhrase;
        this.specificPhrase = specificPhrase;
        this.dimensions = dimensions;
        this.productId = productId;
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public String getVerb() {
        return verb;
    }

    public String getGeneralPhrase() {
        return generalPhrase;
    }

    public String getSpecificPhrase() {
        return specificPhrase;
    }

    public String getDimensions() {
        return dimensions;
    }

    public int getProductId() {
        return productId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public void setGeneralPhase(String generalPhrase) {
        this.generalPhrase = generalPhrase;
    }

    public void setSpecificPhrase(String specificPhrase) {
        this.specificPhrase = specificPhrase;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    
    
}