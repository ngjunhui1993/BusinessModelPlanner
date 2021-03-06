/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.model.entity.BOSOperator;
import com.app.model.entity.BOSProduct;
import com.app.model.entity.Operator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author jiaohui.lee.2014
 */
public class Excel {

    public static void Export(String userId, ArrayList<Operator> oList, String projectName, String prodName, int prodId) {
        try {
            String pathdir = new String(System.getenv("OPENSHIFT_DATA_DIR") + userId + ".xls");
            String localDir = new String("C:\\Users\\jiaohui.lee.2014\\Desktop\\Excel\\" + userId + ".xls");
            System.out.println(System.getenv("OPENSHIFT_DATA_DIR"));
            File file = null;
            //if(System.getenv("OPENSHIFT_DATA_DIR")== null){
            file = new File(pathdir);
            //}else{
            //  file = new File(pathdir); 
            // }
            FileInputStream fsIP = null;
            FileOutputStream output = null;
            Workbook workbook = null;
            //Checks if the file at Directory Exists
            if (file.isFile()) {
                fsIP = new FileInputStream(file);
                file.setWritable(true);
                //Access Existing Workbook
                workbook = new HSSFWorkbook(fsIP);
                //Open OutputStream to write updates
                output = new FileOutputStream(file);
            } else {
                output = new FileOutputStream(file);
                //Creates a new Workbook
                file.setWritable(true);
                workbook = new HSSFWorkbook();
            }
            // Creates an Excel Sheet with the projectName.
            Sheet sheet1 = workbook.createSheet(projectName); //Create a Excel sheet with sheetname of the Product
            
            CellStyle cs = workbook.createCellStyle();
            sheet1.setColumnWidth(0, 5000); //set column width to accommodate longer words
            cs.setWrapText(true); //set wrap text
            
            //Creates Top portion
            Row row = sheet1.createRow(1);
            Cell product = row.createCell(1);
            product.setCellValue("Product");
            
            product.setCellStyle(cs); //set wrap text
            
            Cell productName = row.createCell(2);
            productName.setCellValue(prodName);
            
            productName.setCellStyle(cs); //set wrap text
            
            Row row2 = sheet1.createRow(2);
            Cell productID = row2.createCell(1);
            productID.setCellValue("Product ID");
            
            productID.setCellStyle(cs); //set wrap text
            
            Cell id = row2.createCell(2);
            id.setCellValue(Integer.toString(prodId));
            
            id.setCellStyle(cs); //set wrap text
            //same with the rest with setCellStyle(cs)

            //Creates Table Headers
            Row row3 = sheet1.createRow(3);
            Cell Operatorheader = row3.createCell(1);
            Operatorheader.setCellValue("Operator");
            
            Operatorheader.setCellStyle(cs);
            
            
            Cell Commentsheader = row3.createCell(2);
            Commentsheader.setCellValue("Comments");
            
            Commentsheader.setCellStyle(cs);
            
            int operatorid = 1;
            if (oList != null) {
                for (int i = 0; i < oList.size(); i++) {

                    Operator operator = oList.get(i);
                    String operatorName = operator.getOperatorName();
                    String comments = operator.getComments();
                    int columnCounter = 0;
                    int rowCounter = 4;
                    Row rowTable = sheet1.createRow(i + rowCounter);
                    
                        Cell operatorNumberTable = rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                        operatorNumberTable.setCellValue("Operator" + operatorid);
                        operatorNumberTable.setCellStyle(cs);
                        columnCounter++;
                        
                        operatorid++;

                    Cell operatorNameTable = rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                    operatorNameTable.setCellValue(operatorName);
                    
                    operatorNameTable.setCellStyle(cs);
                    
                    columnCounter++;

                    Cell generalPhraseTable = rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                    generalPhraseTable.setCellValue(comments);
                    
                    generalPhraseTable.setCellStyle(cs);
                    
                    
                    columnCounter++;
                }

            }
            workbook.write(output);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(String userId, String projectName) {
        try {
            String pathdir = new String(System.getenv("OPENSHIFT_DATA_DIR") + userId + ".xls");
            String localDir = new String("C:/Users/Dell/Desktop/" + userId + ".xls");
            System.out.println(System.getenv("OPENSHIFT_DATA_DIR"));
            File file = null;
            //if(System.getenv("OPENSHIFT_DATA_DIR")== null){
            file = new File(pathdir);
            //}else{
            //  file = new File(pathdir); 
            // }
            FileInputStream fsIP = null;
            POIFSFileSystem fsPoi = null;
            FileOutputStream output = null;
            Workbook workbook = null;
            //Checks if the file at Directory Exists
            if (file.isFile()) {
                fsIP = new FileInputStream(file);
                fsPoi = new POIFSFileSystem(fsIP);
                //Access Existing Workbook
                workbook = new HSSFWorkbook(fsPoi);
                //Open OutputStream to write updates
                output = new FileOutputStream(file);
            }

            Sheet sheet = workbook.getSheet(projectName);
            int index = 0;
            if (sheet != null) {
                index = workbook.getSheetIndex(sheet);
                int noOfSheets = workbook.getNumberOfSheets();
                if (index == 0 && noOfSheets == 1) {
                    boolean delete = file.delete();
                } else {
                    workbook.removeSheetAt(index);
                    workbook.write(output);
                    output.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void edit(String userId, ArrayList<Operator> oList, String projectName, String prodName, int prodId) {
        try {
            if (!oList.isEmpty()) {
                String pathdir = new String(System.getenv("OPENSHIFT_DATA_DIR") + userId + ".xls");
                String localDir = new String("C:/Users/Dell/Desktop/" + userId + ".xls");
                System.out.println(System.getenv("OPENSHIFT_DATA_DIR"));
                File file = null;
                //if(System.getenv("OPENSHIFT_DATA_DIR")== null){
                file = new File(pathdir);
                //}else{
                //  file = new File(pathdir); 
                // }
                FileInputStream fsIP = null;
                FileOutputStream output = null;
                Workbook workbook = null;
                //Checks if the file at Directory Exists
                if (file.isFile()) {
                    fsIP = new FileInputStream(file);
                    file.setWritable(true);
                    //Access Existing Workbook
                    workbook = new HSSFWorkbook(fsIP);
                    //Open OutputStream to write updates
                    output = new FileOutputStream(file);
                } else {
                    output = new FileOutputStream(file);
                    //Creates a new Workbook
                    file.setWritable(true);
                    workbook = new HSSFWorkbook();
                }

                // Grabs the Excel Sheet to edit
                Sheet sheet1 = workbook.getSheet(projectName); //Create a Excel sheet with sheetname of the Product

                //From here, may create error. Refer to http://stackoverflow.com/questions/521274/edit-existing-excel-files-using-jxl-api-apache-poi
                //Creates Top portion
                Row row = sheet1.createRow(1);
                Cell product = row.createCell(1);
                product.setCellValue("Product");
                Cell productName = row.createCell(2);
                productName.setCellValue(prodName);
                Row row2 = sheet1.createRow(2);
                Cell productID = row2.createCell(1);
                productID.setCellValue("Product ID");
                Cell id = row2.createCell(2);
                id.setCellValue(Integer.toString(prodId));

                //Creates Table Headers
                Row row3 = sheet1.createRow(3);
                Cell Operatorheader = row3.createCell(1);
                Operatorheader.setCellValue("Operator");
                Cell Verbheader = row3.createCell(2);
                Verbheader.setCellValue("Verb");
                Cell Commentsheader = row3.createCell(3);
                Commentsheader.setCellValue("Comments");

                int operatorid = 1;
                for (int i = 0; i < oList.size(); i++) {

                    Operator operator = oList.get(i);
                    String operatorName = operator.getOperatorName();
                    String comments = operator.getComments();
                    int columnCounter = 0;
                    int rowCounter = 4;
                    Row rowTable = sheet1.createRow(i + rowCounter);
                    if (i % 2 == 0) {
                        Cell operatorNumberTable = rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                        operatorNumberTable.setCellValue("Operator" + operatorid);
                        columnCounter++;
                    } else {
                        Cell operatorNumberTable = rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                        operatorNumberTable.setCellValue("Operator" + operatorid + " Compliment");
                        columnCounter++;
                        operatorid++;
                    }
                    Cell operatorNameTable = rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                    operatorNameTable.setCellValue(operatorName);
                    columnCounter++;
                    Cell commentsTable = rowTable.createCell(columnCounter); //A column == 0, B == 1, C ==2, D==3
                    commentsTable.setCellValue(comments);
                    columnCounter++;

                }
                workbook.write(output);
                output.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void BOSExport (String userId, ArrayList<BOSOperator> bList, BOSProduct project){
        try{
            String projectName = project.getProjectName();
            int productid = project.getProductID();
            int originalCost = project.getOriginalCost();
            int budgetRequired = project.getBudgetRequired();
            
            String pathdir = new String(System.getenv("OPENSHIFT_DATA_DIR") + userId + "BOSC.xls");
            String localDir = new String("C:\\Users\\jiaohui.lee.2014\\Desktop\\Excel\\" + userId + "BOSC.xls");
            //System.out.println(System.getenv("OPENSHIFT_DATA_DIR"));
            File file = null;
            //if(System.getenv("OPENSHIFT_DATA_DIR")== null){
            file = new File(pathdir);
            //}else{
            //  file = new File(pathdir); 
            // }
            FileInputStream fsIP = null;
            FileOutputStream output = null;
            Workbook workbook = null;
            //Checks if the file at Directory Exists
            if (file.isFile()) {
                fsIP = new FileInputStream(file);
                file.setWritable(true);
                //Access Existing Workbook
                workbook = new HSSFWorkbook(fsIP);
                //Open OutputStream to write updates
                output = new FileOutputStream(file);
            } else {
                output = new FileOutputStream(file);
                //Creates a new Workbook
                file.setWritable(true);
                workbook = new HSSFWorkbook();
            }
            // Creates an Excel Sheet with the projectName.
            Sheet sheet1 = workbook.createSheet(projectName); //Create a Excel sheet with sheetname of the Product
            
            CellStyle cs = workbook.createCellStyle();
            sheet1.setColumnWidth(0, 5000); //set column width to accommodate longer words
            cs.setWrapText(true); //set wrap text
            
            //Creates Top portion
            Row row = sheet1.createRow(1);
            Cell productID = row.createCell(1);
            productID.setCellValue("Product ID");
            productID.setCellStyle(cs); //set wrap text
            
            Cell id = row.createCell(2);
            id.setCellValue(Integer.toString(productid));
            id.setCellStyle(cs); //set wrap text
            
            Row row2 = sheet1.createRow(2);
            Cell originalCostRow = row2.createCell(1);
            originalCostRow.setCellValue("Original Cost:");
            originalCostRow.setCellStyle(cs); //set wrap text
            Cell originalCostValue = row2.createCell(2);
            originalCostValue.setCellValue(Integer.toString(originalCost));
            originalCostValue.setCellStyle(cs); //set wrap text
            
            Row row3 = sheet1.createRow(3);
            Cell budgetRequiredRow = row3.createCell(1);
            budgetRequiredRow.setCellValue("Budget Required:");
            budgetRequiredRow.setCellStyle(cs); //set wrap text
            Cell budgetRequiredValue = row3 .createCell(2);
            budgetRequiredValue.setCellValue(Integer.toString(budgetRequired));
            budgetRequiredValue.setCellStyle(cs); //set wrap text
            
            //Creates Table Headers
            Row row4 = sheet1.createRow(4);
            for (int columnNumber = 1; columnNumber<=7;columnNumber++){
                Cell header = row4.createCell(columnNumber);
                switch(columnNumber){
                    case 1:
                        header.setCellValue("Factor ID");
                        break;
                    case 2:
                        header.setCellValue("Factor Name");
                        break;
                    case 3:
                        header.setCellValue("Weight");
                        break;
                    case 4:
                        header.setCellValue("Grid");
                        break;
                    case 5:
                        header.setCellValue("Per Unit Value");
                        break;
                    case 6:
                        header.setCellValue("Original Value");
                        break;
                    default:
                        header.setCellValue("New Value");   
                        break;
                }
                header.setCellStyle(cs);
            }
            
            
            if (bList != null) {
                for (int i = 0; i < bList.size(); i++) {

                    BOSOperator operator = bList.get(i);
                    String factorName = operator.getFactorName();
                    int operatorid = operator.getFactorid();
                    int weight = operator.getWeight();
                    int grid = operator.getGrid();
                    int perUnitValue = operator.getPerUnitValue();
                    int originalValue = operator.getOriginalValue();
                    int newValue = operator.getNewValue();
                    
                    int columnCounter = 1;
                    int rowCounter = 5;
                    Row rowTable= sheet1.createRow(i+rowCounter);
                    
                    Cell operatorNumberTable = rowTable.createCell(columnCounter);
                    operatorNumberTable.setCellValue("Factor: " + operatorid);
                    operatorNumberTable.setCellStyle(cs);
                    columnCounter++;
                    
                    Cell operatorNameTable = rowTable.createCell(columnCounter);
                    operatorNameTable.setCellValue(factorName);   
                    operatorNameTable.setCellStyle(cs);
                    columnCounter++;
                            
                    Cell weightTable = rowTable.createCell(columnCounter);
                    weightTable.setCellValue(weight);
                    weightTable.setCellStyle(cs);             
                    columnCounter++;
                    
                    Cell gridTable = rowTable.createCell(columnCounter);
                    gridTable.setCellValue(grid);
                    gridTable.setCellStyle(cs);             
                    columnCounter++;
                    
                    Cell perUnitValueTable = rowTable.createCell(columnCounter);
                    perUnitValueTable.setCellValue(perUnitValue);
                    perUnitValueTable.setCellStyle(cs);             
                    columnCounter++;
                    
                    Cell originalValueTable = rowTable.createCell(columnCounter);
                    originalValueTable.setCellValue(originalValue);
                    originalValueTable.setCellStyle(cs);             
                    columnCounter++;
                    
                    Cell newValueTable = rowTable.createCell(columnCounter);
                    newValueTable.setCellValue(newValue);
                    newValueTable.setCellStyle(cs);             
                    columnCounter++;
                }
            }
            workbook.write(output);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void BOSDelete(String userId, String projectName) {
        try {
            String pathdir = new String(System.getenv("OPENSHIFT_DATA_DIR") + userId + "BOSC.xls");
            String localDir = new String("C:/Users/Dell/Desktop/" + userId + "BOSC.xls");
            System.out.println(System.getenv("OPENSHIFT_DATA_DIR"));
            File file = null;
            //if(System.getenv("OPENSHIFT_DATA_DIR")== null){
            file = new File(pathdir);
            //}else{
            //  file = new File(pathdir); 
            // }
            FileInputStream fsIP = null;
            POIFSFileSystem fsPoi = null;
            FileOutputStream output = null;
            Workbook workbook = null;
            //Checks if the file at Directory Exists
            if (file.isFile()) {
                fsIP = new FileInputStream(file);
                fsPoi = new POIFSFileSystem(fsIP);
                //Access Existing Workbook
                workbook = new HSSFWorkbook(fsPoi);
                //Open OutputStream to write updates
                output = new FileOutputStream(file);
            }

            Sheet sheet = workbook.getSheet(projectName);
            int index = 0;
            if (sheet != null) {
                index = workbook.getSheetIndex(sheet);
                int noOfSheets = workbook.getNumberOfSheets();
                if (index == 0 && noOfSheets == 1) {
                    boolean delete = file.delete();
                } else {
                    workbook.removeSheetAt(index);
                    workbook.write(output);
                    output.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
