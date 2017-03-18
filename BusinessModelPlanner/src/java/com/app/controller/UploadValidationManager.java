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
import java.util.List;

/**
 *
 * @author jiaohui.lee.2014
 */
public class UploadValidationManager {
    final static String customerAcquisition = "customer_acquisition.csv";
    final static String customerRelations = "customer_relations.csv";
    final static String channelStrategy= "channel_strategy.csv";
    final static String valueProposition = "value_proposition.csv";
    final static String keyActivities = "key_activities.csv";
    final static String keyResources = "key_resources.csv";
    final static String keyPartnerships = "key_partnerships.csv";
    final static String costManagement = "cost_management.csv";
    final static String revenues = "revenues.csv";
    
    public static UploadResult validateCA(ArrayList<String[]> data){
        TreeMap<Integer,ArrayList<String>> errorList = new TreeMap<>();
        HashMap<String, String[]> validData = new HashMap<>();
        String[] headerLines = data.get(0);
        int noField = 0;
        int choiceField = 0;
        int companyField = 0;
        int descriptionField = 0;
        int unknown =0;
        
        for (int counter = 0; counter<headerLines.length; counter++){
            String currentHeader = headerLines[counter].trim().toLowerCase(); //to ensure header doesnt have extra spaces
            switch (currentHeader) {
                case ("no"):
                    noField = counter;
                case ("implementation choices for customer acquisition"):
                    choiceField = counter;
                case ("company"):
                    companyField = counter;
                case ("description"):
                    descriptionField = counter;
                default:
                    unknown = counter;    
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
                String choices = currentLine[choiceField].trim();
                String company = currentLine[companyField].trim();
                String description = currentLine[descriptionField].trim();
                
                //Creates a HASHMAP of validDATA to be imported
                if (isValidRow){
                    validData.put(choices,new String[]{company,description});
                }
                
            }         
        }
        return new UploadResult(customerAcquisition, validData, errorList);
    }
    
    public static UploadResult validateCR(ArrayList<String[]> data){
           TreeMap<Integer,ArrayList<String>> errorList = new TreeMap<>();
        HashMap<String, String[]> validData = new HashMap<>();
        String[] headerLines = data.get(0);
        int noField = 0;
        int choiceField = 0;
        int companyField = 0;
        int descriptionField = 0;
        int unknown =0;
        
        for (int counter = 0; counter<headerLines.length; counter++){
            String currentHeader = headerLines[counter].trim().toLowerCase(); //to ensure header doesnt have extra spaces
            switch (currentHeader) {
                case ("no"):
                    noField = counter;
                case ("implementation choices for customer relations"):
                    choiceField = counter;
                case ("company"):
                    companyField = counter;
                case ("description"):
                    descriptionField = counter;
                default:
                    unknown = counter;    
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
                String choices = currentLine[choiceField].trim();
                String company = currentLine[companyField].trim();
                String description = currentLine[descriptionField].trim();
                
                //Creates a HASHMAP of validDATA to be imported
                if (isValidRow){
                    validData.put(choices,new String[]{company,description});
                }
                
            }         
        }
        return new UploadResult(customerRelations, validData, errorList);
    }
    
    public static UploadResult validateCS(ArrayList<String[]> data){
        TreeMap<Integer,ArrayList<String>> errorList = new TreeMap<>();
        HashMap<String, String[]> validData = new HashMap<>();
        String[] headerLines = data.get(0);
        int noField = 0;
        int choiceField = 0;
        int companyField = 0;
        int descriptionField = 0;
        int unknown = 0;
        
        for (int counter = 0; counter<headerLines.length; counter++){
            String currentHeader = headerLines[counter].trim().toLowerCase(); //to ensure header doesnt have extra spaces
            switch (currentHeader) {
                case ("no"):
                    noField = counter;
                case ("implementation choices for channel strategy"):
                    choiceField = counter;
                case ("company"):
                    companyField = counter;
                case ("description"):
                    descriptionField = counter;
                default:
                    unknown = counter;    
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
                String choices = currentLine[choiceField].trim();
                String company = currentLine[companyField].trim();
                String description = currentLine[descriptionField].trim();
                
                //Creates a HASHMAP of validDATA to be imported
                if (isValidRow){
                    validData.put(choices,new String[]{company,description});
                }
                
            }         
        }
        return new UploadResult(channelStrategy, validData, errorList);
    }
    
    public static UploadResult validateVP(ArrayList<String[]> data){
        TreeMap<Integer,ArrayList<String>> errorList = new TreeMap<>();
        HashMap<String, String[]> validData = new HashMap<>();
        String[] headerLines = data.get(0);
        int noField = 0;
        int choiceField = 0;
        int companyField = 0;
        int descriptionField = 0;
        int unknown = 0;
        
        for (int counter = 0; counter<headerLines.length; counter++){
            String currentHeader = headerLines[counter].trim().toLowerCase(); //to ensure header doesnt have extra spaces
            switch (currentHeader) {
                case ("no"):
                    noField = counter;
                case ("implementation choices for value proposition"):
                    choiceField = counter;
                case ("company"):
                    companyField = counter;
                case ("description"):
                    descriptionField = counter;
                default:
                    unknown = counter;     
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
                String choices = currentLine[choiceField].trim();
                String company = currentLine[companyField].trim();
                String description = currentLine[descriptionField].trim();
                
                //Creates a HASHMAP of validDATA to be imported
                if (isValidRow){
                    validData.put(choices,new String[]{company,description});
                }
                
            }         
        }
        return new UploadResult(valueProposition, validData, errorList);
    }
    
    public static UploadResult validateKA(ArrayList<String[]> data){
        TreeMap<Integer,ArrayList<String>> errorList = new TreeMap<>();
        HashMap<String, String[]> validData = new HashMap<>();
        String[] headerLines = data.get(0);
        int noField = 0;
        int choiceField = 0;
        int companyField = 0;
        int descriptionField = 0;
        int unknown = 0;
        
        for (int counter = 0; counter<headerLines.length; counter++){
            String currentHeader = headerLines[counter].trim().toLowerCase(); //to ensure header doesnt have extra spaces
            switch (currentHeader) {
                case ("no"):
                    noField = counter;
                case ("implementation choices for key activities"):
                    choiceField = counter;
                case ("company"):
                    companyField = counter;
                case ("description"):
                    descriptionField = counter;
                default:
                    unknown = counter;    
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
                String choices = currentLine[choiceField].trim();
                String company = currentLine[companyField].trim();
                String description = currentLine[descriptionField].trim();
                
                //Creates a HASHMAP of validDATA to be imported
                if (isValidRow){
                    validData.put(choices,new String[]{company,description});
                }
                
            }         
        }
        return new UploadResult(keyActivities, validData, errorList);
    }
    
    public static UploadResult validateKR(ArrayList<String[]> data){
        TreeMap<Integer,ArrayList<String>> errorList = new TreeMap<>();
        HashMap<String, String[]> validData = new HashMap<>();
        String[] headerLines = data.get(0);
        int noField = 0;
        int choiceField = 0;
        int companyField = 0;
        int descriptionField = 0;
        int unknown = 0;
        
        for (int counter = 0; counter<headerLines.length; counter++){
            String currentHeader = headerLines[counter].trim().toLowerCase(); //to ensure header doesnt have extra spaces
            switch (currentHeader) {
                case ("no"):
                    noField = counter;
                case ("implementation choices for key resources"):
                    choiceField = counter;
                case ("company"):
                    companyField = counter;
                case ("description"):
                    descriptionField = counter;
                default:
                    unknown = counter;      
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
                String choices = currentLine[choiceField].trim();
                String company = currentLine[companyField].trim();
                String description = currentLine[descriptionField].trim();
                
                //Creates a HASHMAP of validDATA to be imported
                if (isValidRow){
                    validData.put(choices,new String[]{company,description});
                }
                
            }         
        }
        return new UploadResult(keyResources, validData, errorList);
    }
    
    public static UploadResult validateKP(ArrayList<String[]> data){
        TreeMap<Integer,ArrayList<String>> errorList = new TreeMap<>();
        HashMap<String, String[]> validData = new HashMap<>();
        String[] headerLines = data.get(0);
        int noField = 0;
        int choiceField = 0;
        int companyField = 0;
        int descriptionField = 0;
        int unknown = 0;
        
        for (int counter = 0; counter<headerLines.length; counter++){
            String currentHeader = headerLines[counter].trim().toLowerCase(); //to ensure header doesnt have extra spaces
            switch (currentHeader) {
                case ("no"):
                    noField = counter;
                case ("implementation choices for key partnerships"):
                    choiceField = counter;
                case ("company"):
                    companyField = counter;
                case ("description"):
                    descriptionField = counter;
                default:
                    unknown = counter;       
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
                String choices = currentLine[choiceField].trim();
                String company = currentLine[companyField].trim();
                String description = currentLine[descriptionField].trim();
                
                //Creates a HASHMAP of validDATA to be imported
                if (isValidRow){
                    validData.put(choices,new String[]{company,description});
                }
                
            }         
        }
        return new UploadResult(keyPartnerships, validData, errorList);
    }
    
    public static UploadResult validateCM(ArrayList<String[]> data){
        TreeMap<Integer,ArrayList<String>> errorList = new TreeMap<>();
        HashMap<String, String[]> validData = new HashMap<>();
        String[] headerLines = data.get(0);
        int noField = 0;
        int choiceField = 0;
        int companyField = 0;
        int descriptionField = 0;
        int unknown = 0;
        
        for (int counter = 0; counter<headerLines.length; counter++){
            String currentHeader = headerLines[counter].trim().toLowerCase(); //to ensure header doesnt have extra spaces
            switch (currentHeader) {
                case ("no"):
                    noField = counter;
                case ("implementation choices for cost management"):
                    choiceField = counter;
                case ("company"):
                    companyField = counter;
                case ("description"):
                    descriptionField = counter;
                default:
                    unknown = counter;     
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
                String choices = currentLine[choiceField].trim();
                String company = currentLine[companyField].trim();
                String description = currentLine[descriptionField].trim();
                
                //Creates a HASHMAP of validDATA to be imported
                if (isValidRow){
                    validData.put(choices,new String[]{company,description});
                }
                
            }         
        }
        return new UploadResult(costManagement, validData, errorList);
    }
    
    public static UploadResult validateR(ArrayList<String[]> data){
        TreeMap<Integer,ArrayList<String>> errorList = new TreeMap<>();
        HashMap<String, String[]> validData = new HashMap<>();
        String[] headerLines = data.get(0);
        int noField = 0;
        int choiceField = 0;
        int companyField = 0;
        int descriptionField = 0;
        int unknown = 0;
        
        for (int counter = 0; counter<headerLines.length; counter++){
            String currentHeader = headerLines[counter].trim().toLowerCase(); //to ensure header doesnt have extra spaces
            switch (currentHeader) {
                case ("no"):
                    noField = counter;
                case ("implementation choices for revenues"):
                    choiceField = counter;
                case ("company"):
                    companyField = counter;
                case ("description"):
                    descriptionField = counter;
                default:
                    unknown = counter;   
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
                String choices = currentLine[choiceField].trim();
                String company = currentLine[companyField].trim();
                String description = currentLine[descriptionField].trim();
                
                //Creates a HASHMAP of validDATA to be imported
                if (isValidRow){
                    validData.put(choices,new String[]{company,description});
                }
                
            }         
        }
        return new UploadResult(revenues, validData, errorList);
    }
    
}
