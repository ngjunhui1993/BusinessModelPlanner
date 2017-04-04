/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.model.entity.Operator;
import com.app.model.entity.QadimProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jiaohui.lee.2014
 */
public class QaDIMDAO {
    
    public static void upload (ArrayList<Operator> operator){
        if (operator.isEmpty()) {
            //input error;
        } else {
            String sql = "insert into `qadim_operator`(`userid`,`operator_name`, `product_id`, `operator_id`, `comments`) values (?,?,?,?,?);"; //insert base on table
            Connection conn = null;
            PreparedStatement preStmt = null;
            ResultSet rs = null;
            try {
                conn = ConnectionManager.getConnection();
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                for (Operator op : operator) {
                    preStmt.setString(1, op.getUserid());
                    preStmt.setString(2, op.getOperatorName());
                    preStmt.setInt(3, op.getProductId());
                    preStmt.setInt(4, op.getOperatorId());
                    preStmt.setString(5, op.getComments());
                    preStmt.execute();
                }
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionManager.close(conn, preStmt, rs);
            }
        }
    }
    
    public static void createQadimProduct(String userID , String projectName , Integer productID , String productName){
        Connection conn = null ;
        PreparedStatement pstmt = null ;
        ResultSet rs = null ;
        String sql = "INSERT into qadim_product(userid , project_name , product_id, product_name) values(? , ? , ? , ?); ";
        try {
                conn = ConnectionManager.getConnection();
                conn.setAutoCommit(false);
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1 , userID);
                pstmt.setString(2 , projectName);
                pstmt.setInt(3 , productID);
                pstmt.setString(4, productName);
                pstmt.execute() ;
               System.out.println("saved 1 row of qadim to db");
               conn.commit();
               
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionManager.close(conn, pstmt, rs);
                
            }
    }
    
    public static QadimProduct retrieveProject (String projectName){
        QadimProduct product= null;
       // String email = userId.getEmail().substring(0,user.getEmail().indexOf("@"));
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from qadim_product where project_name = ?;";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, projectName);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                product = new QadimProduct(rs.getString("userid"), rs.getString("project_name"), Integer.parseInt(rs.getString("product_id")), rs.getString("product_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return product;
    }
    
    public static QadimProduct retrieveProjectByUser (String projectName, String userid) {
        QadimProduct product= null;
       // String email = userId.getEmail().substring(0,user.getEmail().indexOf("@"));
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from qadim_product where project_name = ? and userid =?";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, projectName);
            preStmt.setString(2, userid);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                product = new QadimProduct(rs.getString("userid"), rs.getString("project_name"), Integer.parseInt(rs.getString("product_id")), rs.getString("product_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return product;
    }
    
    public static ArrayList<Operator> retrieveOperators (int productId, String userId){
        ArrayList<Operator> oList= new ArrayList<Operator>();
       // String email = userId.getEmail().substring(0,user.getEmail().indexOf("@"));
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from qadim_operator where userid = ? and product_id =?;";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, userId);
            preStmt.setString(2, Integer.toString(productId));
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String userid = rs.getString("userid");
                String operatorName = rs.getString("operator_name");
                int productid = Integer.parseInt(rs.getString("product_id"));
                int operatorid = Integer.parseInt(rs.getString("operator_id"));
                String comments = rs.getString("comments");
                Operator operator = new Operator(userid ,operatorName, productid ,operatorid, comments );
                oList.add(operator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return oList;
    }
    public static ArrayList<QadimProduct> retrieveAllProjects (String userId){
        ArrayList<QadimProduct> products= new ArrayList<QadimProduct>();
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "select userid, project_name, product_id, product_name from qadim_product where userid = ?";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, userId);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String userid = rs.getString("userid");
                String projName = rs.getString("project_name");
                int productID = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                QadimProduct product = new QadimProduct(userid, projName, productID, productName);
                
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return products;
    }
    public static int checkForNextValidProductId(String userid){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        int maxProductid = 0;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "select max(product_id) from qadim_product where userid = ?";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, userid);
            rs = preStmt.executeQuery();
            while(rs.next()){
                maxProductid = rs.getInt("max(product_id)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return maxProductid;
    }
    public static void deleteProject(int productId , String userId) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "delete from qadim_product where product_id = ? and userid = ?;";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, Integer.toString(productId));
            preStmt.setString(2, userId);
            preStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
    }
    
        public static void deleteOperators(int productId , String userId) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "delete from qadim_operator where product_id = ? and userid = ?; ";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, Integer.toString(productId));
            preStmt.setString(2, userId);
            preStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
    }
    
    public static void update(ArrayList<Operator> oList, String userid){
            String sql = "update qadim_operator set operator_name=?, comments=? where userid=? and product_id=? and operator_id=?;";  
            Connection conn = null;
            PreparedStatement preStmt = null;
            ResultSet rs = null;
            try {
                conn = ConnectionManager.getConnection();
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                for (Operator op: oList) {
                    preStmt.setString(1, op.getOperatorName());
                    preStmt.setString(2, op.getComments());
                    preStmt.setString(3, userid);
                    preStmt.setInt(4, op.getProductId());
                    preStmt.setInt(5, op.getOperatorId());
                    
                  //   preStmt.addBatch();
                     System.out.println("edited 1 row of operator to db");
                     preStmt.executeUpdate();
                }
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionManager.close(conn, preStmt, rs);
            }
    }
    
        public static void editProjectName(String projName, String userid, String newProjName){
            String sql = "update qadim_product set project_name=? where userid=? and project_name=?;";  
            Connection conn = null;
            PreparedStatement preStmt = null;
            ResultSet rs = null;
            try {
                conn = ConnectionManager.getConnection();
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                preStmt.setString(1, newProjName);
                preStmt.setString(2, userid);
                preStmt.setString(3, projName);
                
                preStmt.executeUpdate();
                
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionManager.close(conn, preStmt, rs);
            }
    }
    
    public static int retrieveNoOfProjects(String userId){
       // String email = userId.getEmail().substring(0,user.getEmail().indexOf("@"));
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from qadim_product where userid = ?;";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, userId);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return count;
    }
}
