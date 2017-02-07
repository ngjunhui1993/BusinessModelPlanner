/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jiaohui.lee.2014
 */
public class MainFileDAO {
    private static boolean hasBootstrap = false;
    
    public static void deleteAll(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        
        try{
            conn = ConnectionManager.getConnection();
            String sql = "TRUNCATE data;";
            preStmt = conn.prepareStatement(sql);
            preStmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            ConnectionManager.close(conn, preStmt, rs);
        }
    }
    
    public static int upload (HashMap<String, String[]> data){
        int totalUploaded = 0;
        final int batchSize = 1000;
        int count = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        if (data.isEmpty()){
            return totalUploaded;
        }else{
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement preStmt = null;
            String sql = "insert into data (choice, company, description) values (?,?,?);";
            try{
                conn = ConnectionManager.getConnection();
               //allow you to group multiple subsequent Statements under the same transaction.
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                for(Map.Entry<String,String[]> entry : data.entrySet()){
                    String[] dataInfo = entry.getValue();
                    preStmt.setString(1,entry.getKey());
                    preStmt.setString(2,dataInfo[0]);
                    preStmt.setString(3,dataInfo[1]);
                    preStmt.addBatch();
                    
                    //Ensure that if a large Batch of data(1000) is sent, it breaks off and sends in batches instead
                    if (++count % batchSize == 0) {
                        list.add(preStmt.executeBatch());
                    }
               }
                
                list.add(preStmt.executeBatch());
                conn.commit();
            } catch(SQLException e){
                /*(1) one of the SQL statements you added to the batch produces a result set (usually a query) or 
                (2) one of the SQL statements in the batch does not execute successfully for some other reason.*/
                BatchUpdateException bup = (BatchUpdateException)e;
                list.add(bup.getUpdateCounts());
            } finally {
                ConnectionManager.close(conn,preStmt, rs);
            }
        }
        
        //Final counts on the total number of rows of data being uploaded
        for (int[] updates : list){
            for (int update: updates){
                if (update ==1){
                    totalUploaded +=update;
                }
            }
        }
        hasBootstrap = true;
        return count;
    }
}
