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
    
    public static int upload (HashMap<String, String[]> data, String database){
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
            String sql = "insert into " + database +" (choice, company, description) values (?,?,?);";
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
    public static int uploadCA (HashMap<String, String[]> caData){
        int totalUploaded = 0;
        final int batchSize = 1000;
        int count = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        if (caData.isEmpty()){
            return totalUploaded;
        }else{
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement preStmt = null;
            String sql = "insert into customer_acquisition (choice, company, description) values (?,?,?);";
            try{
                conn = ConnectionManager.getConnection();
               //allow you to group multiple subsequent Statements under the same transaction.
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                for(Map.Entry<String,String[]> entry : caData.entrySet()){
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
    public static int uploadCR (HashMap<String, String[]> crData){
        int totalUploaded = 0;
        final int batchSize = 1000;
        int count = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        if (crData.isEmpty()){
            return totalUploaded;
        }else{
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement preStmt = null;
            String sql = "insert into customer_relations (choice, company, description) values (?,?,?);";
            try{
                conn = ConnectionManager.getConnection();
               //allow you to group multiple subsequent Statements under the same transaction.
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                for(Map.Entry<String,String[]> entry : crData.entrySet()){
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
    public static int uploadCS (HashMap<String, String[]> csData){
        int totalUploaded = 0;
        final int batchSize = 1000;
        int count = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        if (csData.isEmpty()){
            return totalUploaded;
        }else{
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement preStmt = null;
            String sql = "insert into channel_strategy (choice, company, description) values (?,?,?);";
            try{
                conn = ConnectionManager.getConnection();
               //allow you to group multiple subsequent Statements under the same transaction.
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                for(Map.Entry<String,String[]> entry : csData.entrySet()){
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
    public static int uploadVP (HashMap<String, String[]> vpData){
        int totalUploaded = 0;
        final int batchSize = 1000;
        int count = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        if (vpData.isEmpty()){
            return totalUploaded;
        }else{
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement preStmt = null;
            String sql = "insert into value_proposition (choice, company, description) values (?,?,?);";
            try{
                conn = ConnectionManager.getConnection();
               //allow you to group multiple subsequent Statements under the same transaction.
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                for(Map.Entry<String,String[]> entry : vpData.entrySet()){
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
    public static int uploadKA (HashMap<String, String[]> kaData){
        int totalUploaded = 0;
        final int batchSize = 1000;
        int count = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        if (kaData.isEmpty()){
            return totalUploaded;
        }else{
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement preStmt = null;
            String sql = "insert into key_activities (choice, company, description) values (?,?,?);";
            try{
                conn = ConnectionManager.getConnection();
               //allow you to group multiple subsequent Statements under the same transaction.
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                for(Map.Entry<String,String[]> entry : kaData.entrySet()){
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
    public static int uploadKR (HashMap<String, String[]> krData){
        int totalUploaded = 0;
        final int batchSize = 1000;
        int count = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        if (krData.isEmpty()){
            return totalUploaded;
        }else{
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement preStmt = null;
            String sql = "insert into key_resources (choice, company, description) values (?,?,?);";
            try{
                conn = ConnectionManager.getConnection();
               //allow you to group multiple subsequent Statements under the same transaction.
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                for(Map.Entry<String,String[]> entry : krData.entrySet()){
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
    public static int uploadKP (HashMap<String, String[]> kpData){
        int totalUploaded = 0;
        final int batchSize = 1000;
        int count = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        if (kpData.isEmpty()){
            return totalUploaded;
        }else{
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement preStmt = null;
            String sql = "insert into key_partnerships (choice, company, description) values (?,?,?);";
            try{
                conn = ConnectionManager.getConnection();
               //allow you to group multiple subsequent Statements under the same transaction.
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                for(Map.Entry<String,String[]> entry : kpData.entrySet()){
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
    public static int uploadCM (HashMap<String, String[]> cmData){
        int totalUploaded = 0;
        final int batchSize = 1000;
        int count = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        if (cmData.isEmpty()){
            return totalUploaded;
        }else{
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement preStmt = null;
            String sql = "insert into cost_management (choice, company, description) values (?,?,?);";
            try{
                conn = ConnectionManager.getConnection();
               //allow you to group multiple subsequent Statements under the same transaction.
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                for(Map.Entry<String,String[]> entry : cmData.entrySet()){
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
    public static int uploadR (HashMap<String, String[]> rData){
        int totalUploaded = 0;
        final int batchSize = 1000;
        int count = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        if (rData.isEmpty()){
            return totalUploaded;
        }else{
            Connection conn = null;
            ResultSet rs = null;
            PreparedStatement preStmt = null;
            String sql = "insert into revenues (choice, company, description) values (?,?,?);";
            try{
                conn = ConnectionManager.getConnection();
               //allow you to group multiple subsequent Statements under the same transaction.
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                for(Map.Entry<String,String[]> entry : rData.entrySet()){
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
    public static void deleteCA(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        
        try{
            conn = ConnectionManager.getConnection();
            String sql = "TRUNCATE customer_acquisition;";
            preStmt = conn.prepareStatement(sql);
            preStmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            ConnectionManager.close(conn, preStmt, rs);
        }
    }
    public static void deleteCR(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        
        try{
            conn = ConnectionManager.getConnection();
            String sql = "TRUNCATE customer_relations;";
            preStmt = conn.prepareStatement(sql);
            preStmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            ConnectionManager.close(conn, preStmt, rs);
        }
    }
    public static void deleteCS(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        
        try{
            conn = ConnectionManager.getConnection();
            String sql = "TRUNCATE channel_strategy;";
            preStmt = conn.prepareStatement(sql);
            preStmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            ConnectionManager.close(conn, preStmt, rs);
        }
    }
    public static void deleteVP(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        
        try{
            conn = ConnectionManager.getConnection();
            String sql = "TRUNCATE value_proposition;";
            preStmt = conn.prepareStatement(sql);
            preStmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            ConnectionManager.close(conn, preStmt, rs);
        }
    }
    public static void deleteKA(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        
        try{
            conn = ConnectionManager.getConnection();
            String sql = "TRUNCATE key_activities;";
            preStmt = conn.prepareStatement(sql);
            preStmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            ConnectionManager.close(conn, preStmt, rs);
        }
    }
    public static void deleteKR(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        
        try{
            conn = ConnectionManager.getConnection();
            String sql = "TRUNCATE key_resources;";
            preStmt = conn.prepareStatement(sql);
            preStmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            ConnectionManager.close(conn, preStmt, rs);
        }
    }
    public static void deleteKP(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        
        try{
            conn = ConnectionManager.getConnection();
            String sql = "TRUNCATE key_partnerships;";
            preStmt = conn.prepareStatement(sql);
            preStmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            ConnectionManager.close(conn, preStmt, rs);
        }
    }
    public static void deleteCM(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        
        try{
            conn = ConnectionManager.getConnection();
            String sql = "TRUNCATE cost_management;";
            preStmt = conn.prepareStatement(sql);
            preStmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            ConnectionManager.close(conn, preStmt, rs);
        }
    }
    public static void deleteR(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        
        try{
            conn = ConnectionManager.getConnection();
            String sql = "TRUNCATE revenues;";
            preStmt = conn.prepareStatement(sql);
            preStmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            ConnectionManager.close(conn, preStmt, rs);
        }
    }
}
