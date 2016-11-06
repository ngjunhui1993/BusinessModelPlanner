/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.model.entity.Operator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


/**
 *
 * @author jiaohui.lee.2014
 */
public class Excel {
    public static void Export(String userId, ArrayList<Operator> oList, String projectName, String pName, int pId){
            try{
                String pathdir = new String(System.getenv("OPENSHIFT_DATA_DIR")+ userId +".xls");
                String localDir = new String("C:/Users/jiaohui.lee.2014/Desktop/" + userId +".xls");
                System.out.println(System.getenv("OPENSHIFT_DATA_DIR"));
                File file= null ;
                //if(System.getenv("OPENSHIFT_DATA_DIR")== null){
                 file = new File(localDir); 
                //}else{
                 //  file = new File(pathdir); 
               // }
                FileInputStream fsIP = null;
                FileOutputStream output = null;
                Workbook workbook = null;
                //Checks if the file at Directory Exists
                if (file.isFile()){
                    fsIP= new FileInputStream(file);
                    file.setWritable(true);
                    //Access Existing Workbook
                    workbook=new HSSFWorkbook(fsIP);
                    //Open OutputStream to write updates
                    output = new FileOutputStream(file);
                }else{
                    output = new FileOutputStream(file);
                    //Creates a new Workbook
                    file.setWritable(true);
                    workbook=new HSSFWorkbook();
                }
                 
                 // Creates an Excel Sheet with the projectName.
                Sheet sheet1 = workbook.createSheet(projectName); //Create a Excel sheet with sheetname of the Product
               
                //Creates Top portion
                Row row = sheet1.createRow(1);
                Cell product = row.createCell(1);
                product.setCellValue("Product");
                Cell productName = row.createCell(2);
                productName.setCellValue(pName);
                Row row2 = sheet1.createRow(2);
                Cell productID = row2.createCell(1);
                productID.setCellValue("Product ID");
                Cell id = row2.createCell(2);
                id.setCellValue(Integer.toString(pId));
                
                //Creates Table Headers
                Row row3 = sheet1.createRow(3);
                Cell Operatorheader = row3.createCell(1);
                Operatorheader.setCellValue("Operator");
                Cell Verbheader = row3.createCell(2);
                Verbheader.setCellValue("Verb");
                Cell GeneralPhraseheader = row3.createCell(3);
                GeneralPhraseheader.setCellValue("General Phrase");
                Cell SpecificPhraseheader = row3.createCell(4);
                SpecificPhraseheader.setCellValue("Specific Phrase");
                Cell Dimensionheader = row3.createCell(5);
                Dimensionheader.setCellValue("Dimension");
                
                if(oList!=null){
                    for (int i = 0; i<oList.size(); i++){

                        Operator operator = oList.get(i);
                        String operatorName = operator.getOperatorName();
                        String verb = operator.getVerb();
                        String generalPhrase = operator.getGeneralPhrase();
                        String specificPhrase = operator.getSpecificPhrase();
                        String dimensions = operator.getDimensions();
                        int operatorid = operator.getOperatorId();
                        int columnCounter = 0;
                        int rowCounter = 4;
                        Row rowTable = sheet1.createRow(i+rowCounter);
                        if (i%2 == 0){
                            Cell operatorNumberTable= rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                            operatorNumberTable.setCellValue("Operator"+operatorid);
                            columnCounter++;
                        }else{
                            Cell operatorNumberTable= rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                            operatorNumberTable.setCellValue("Operator"+operatorid+"'");
                            columnCounter++;
                        }
                        Cell operatorNameTable= rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                        operatorNameTable.setCellValue(operatorName);
                        columnCounter++;
                        Cell verbTable= rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                        verbTable.setCellValue(verb);
                        columnCounter++;
                        Cell generalPhraseTable= rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                        generalPhraseTable.setCellValue(generalPhrase);
                        columnCounter++;
                        Cell specificPhraseTable= rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                        specificPhraseTable.setCellValue(specificPhrase);
                        columnCounter++;
                        Cell dimensionHeader= rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                        dimensionHeader.setCellValue(dimensions);
                        columnCounter++;

                        }
                }
                workbook.write(output);
                output.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
     public static void delete(String userId, String projectName){
        try{
            String pathdir = new String(System.getenv("OPENSHIFT_DATA_DIR")+ userId +".xls");
            String localDir = new String("C:/Users/jiaohui.lee.2014/Desktop/" + userId +".xls");
            System.out.println(System.getenv("OPENSHIFT_DATA_DIR"));
            File file= null ;
            //if(System.getenv("OPENSHIFT_DATA_DIR")== null){
             file = new File(localDir); 
            //}else{
             //  file = new File(pathdir); 
           // }
            FileInputStream fsIP = null;
            POIFSFileSystem fsPoi = null;
            FileOutputStream output = null;
            Workbook workbook = null;
            //Checks if the file at Directory Exists
            if (file.isFile()){
                fsIP= new FileInputStream(file);
                fsPoi = new POIFSFileSystem(fsIP);
                //Access Existing Workbook
                workbook=new HSSFWorkbook(fsPoi);
                //Open OutputStream to write updates
                output = new FileOutputStream(file);
            }

            Sheet sheet = workbook.getSheet(projectName);
            int index = 0;
            if(sheet != null)   {
                workbook.write(output);
                output.close();
                index = workbook.getSheetIndex(sheet);
                if(index == 0){
                    boolean delete = file.delete();
                }else{
                workbook.removeSheetAt(index);
                workbook.write(output);
            output.close();
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     
     public static void edit(String userId, ArrayList<Operator> oList, String projectName, String pName, int pId){
         try{
                if(!oList.isEmpty()){
                String pathdir = new String(System.getenv("OPENSHIFT_DATA_DIR")+ userId +".xls");
                String localDir = new String("C:/Users/jiaohui.lee.2014/Desktop/" + userId +".xls");
                System.out.println(System.getenv("OPENSHIFT_DATA_DIR"));
                File file= null ;
                //if(System.getenv("OPENSHIFT_DATA_DIR")== null){
                 file = new File(localDir); 
                //}else{
                 //  file = new File(pathdir); 
               // }
                FileInputStream fsIP = null;
                FileOutputStream output = null;
                Workbook workbook = null;
                //Checks if the file at Directory Exists
                if (file.isFile()){
                    fsIP= new FileInputStream(file);
                    file.setWritable(true);
                    //Access Existing Workbook
                    workbook=new HSSFWorkbook(fsIP);
                    //Open OutputStream to write updates
                    output = new FileOutputStream(file);
                }else{
                    output = new FileOutputStream(file);
                    //Creates a new Workbook
                    file.setWritable(true);
                    workbook=new HSSFWorkbook();
                }
                 
                 // Grabs the Excel Sheet to edit
                Sheet sheet1 = workbook.getSheet(projectName); //Create a Excel sheet with sheetname of the Product
               
                //From here, may create error. Refer to http://stackoverflow.com/questions/521274/edit-existing-excel-files-using-jxl-api-apache-poi
                //Creates Top portion
                Row row = sheet1.createRow(1);
                Cell product = row.createCell(1);
                product.setCellValue("Product");
                Cell productName = row.createCell(2);
                productName.setCellValue(pName);
                Row row2 = sheet1.createRow(2);
                Cell productID = row2.createCell(1);
                productID.setCellValue("Product ID");
                Cell id = row2.createCell(2);
                id.setCellValue(Integer.toString(pId));
                
                //Creates Table Headers
                Row row3 = sheet1.createRow(3);
                Cell Operatorheader = row3.createCell(1);
                Operatorheader.setCellValue("Operator");
                Cell Verbheader = row3.createCell(2);
                Verbheader.setCellValue("Verb");
                Cell GeneralPhraseheader = row3.createCell(3);
                GeneralPhraseheader.setCellValue("General Phrase");
                Cell SpecificPhraseheader = row3.createCell(4);
                SpecificPhraseheader.setCellValue("Specific Phrase");
                Cell Dimensionheader = row3.createCell(5);
                Dimensionheader.setCellValue("Dimension");
                
                
                for (int i = 0; i<oList.size(); i++){
                    
                    Operator operator = oList.get(i);
                    String operatorName = operator.getOperatorName();
                    String verb = operator.getVerb();
                    String generalPhrase = operator.getGeneralPhrase();
                    String specificPhrase = operator.getSpecificPhrase();
                    String dimensions = operator.getDimensions();
                    int operatorid = operator.getOperatorId();
                    int columnCounter = 0;
                    int rowCounter = 4;
                    Row rowTable = sheet1.createRow(i+rowCounter);
                    if (i%2 == 0){
                        Cell operatorNumberTable= rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                        operatorNumberTable.setCellValue("Operator"+operatorid);
                        columnCounter++;
                    }else{
                        Cell operatorNumberTable= rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                        operatorNumberTable.setCellValue("Operator"+operatorid+"'");
                        columnCounter++;
                    }
                    Cell operatorNameTable= rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                    operatorNameTable.setCellValue(operatorName);
                    columnCounter++;
                    Cell verbTable= rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                    verbTable.setCellValue(verb);
                    columnCounter++;
                    Cell generalPhraseTable= rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                    generalPhraseTable.setCellValue(generalPhrase);
                    columnCounter++;
                    Cell specificPhraseTable= rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                    specificPhraseTable.setCellValue(specificPhrase);
                    columnCounter++;
                    Cell dimensionHeader= rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                    dimensionHeader.setCellValue(dimensions);
                    columnCounter++;
                    
                
                }
                workbook.write(output);
                output.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
     }
}
