/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author jiaohui.lee.2014
 */
public class UploadResult implements Comparable<UploadResult> {
    int numOfSuccess;
    String fileName;
    HashMap<String, String[]> validDataList;
    TreeMap<Integer, ArrayList<String>> errorList;
    String unknownFiles;
    int additionalBids;

    public UploadResult(String fileName, HashMap<String, String[]> validDataList, TreeMap<Integer, ArrayList<String>> errorList) {
        this.fileName = fileName;
        this.validDataList = validDataList;
        this.errorList = errorList;
        numOfSuccess = 0;
        additionalBids = 0;
    }
    
    public UploadResult(String fileName, HashMap<String, String[]> validDataList, TreeMap<Integer, ArrayList<String>> errorList,int additionalBids) {
        this.fileName = fileName;
        this.validDataList = validDataList;
        this.errorList = errorList;
        numOfSuccess = 0;
        this.additionalBids = additionalBids;
    }

    public String getFileName() {
        return fileName;
    }

    public int getNumOfSuccess() {
        return numOfSuccess;
    }
    
    public int getAdditionalBids() {
        return additionalBids;
    }

    public HashMap<String, String[]> getValidDataList() {
        return validDataList;
    }

    public TreeMap<Integer, ArrayList<String>> getErrorList() {
        return errorList;
    }

    public String getUnknownFiles() {
        return unknownFiles;
    }

    public void setNumSuccessful(int numOfSuccess) {
        this.numOfSuccess = numOfSuccess;
    }
    
    public int compareTo(UploadResult o){
        return fileName.compareTo(o.getFileName());
    }
}
