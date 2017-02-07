/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import com.app.model.UploadResult;

/**
 *
 * @author jiaohui.lee.2014
 */
public class UploadValidationManager {
    final static String COMPANYDATA_FILENAME = "data.csv";
    
    public static UploadResult validateData(ArrayList<String[]> data){
        TreeMap<Integer,ArrayList<String>> errorList = new TreeMap<>();
        HashMap<String,String[]> validData = new HashMap<>();
        String[] headerLines = data.get(0);
        int numberField = 0;
        int choicesField = 0;
        int companyField = 0;
        int descriptionField = 0;
        
        for(int counter = 0; counter<headerLines.length;counter++){
            //ensures that headers does not have extra space and are consistent
            String currentHeader = headerLines[counter].trim().toLowerCase();
            String check = currentHeader;
            //identifies which columns the headers are at
            switch (currentHeader){
                case ("no"):
                    numberField = counter;
                case ("implementation choices for key activities"):
                    choicesField = counter;
                case ("company"):
                    companyField = counter;
                default:
                    descriptionField = counter;
            }          
        }
        
        //Iterates through each ROW
        for (int i = 1; i < data.size() ; i++){
            String[] currentLine = data.get(i);
            boolean hasBlankField = false;
            boolean isValidRow = true;
            String blankFields = "";
            ArrayList<String> blankErrors = new ArrayList<>();
            for (int j = 0; j < currentLine.length; j++){
                String currentElement = currentLine[j].trim();
                //Checks if current cell is empty
                if (currentElement.isEmpty()){
                    // Allows company field to be blank so long a valid description is available
                    if(j == descriptionField && currentLine[descriptionField].trim().isEmpty() && !(currentLine[companyField].trim().isEmpty())){
                        continue;
                    //else sets an error message
                    }else{
                        blankFields = "blank " + headerLines[j].trim();
                        blankErrors.add(blankFields);
                        hasBlankField = true;
                    }
                }
                /*
                
                Insert ANY Input Validation HERE
                
                */
            }
            
            // adds an error if a blank field is detected
            if (hasBlankField){
                errorList.put(i + 1, blankErrors);
            }
            
            // if there are no blank Fields, trim the individual cell of that Row
            if (!hasBlankField){
                String choices = currentLine[choicesField].trim();
                String company = currentLine[companyField].trim();
                String description = currentLine[descriptionField].trim();
                
                //Creates a HASHMAP of validDATA to be imported
                if (isValidRow){
                    validData.put(choices,new String[]{company,description});
                }
                
            }         
        }
        return new UploadResult(COMPANYDATA_FILENAME, validData, errorList);
    }
}
