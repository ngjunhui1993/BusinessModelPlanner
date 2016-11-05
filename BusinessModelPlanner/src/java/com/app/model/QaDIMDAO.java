/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.model.entity.Demographics;
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
            String sql = "insert into `qadim_operator`(`userid`,`operator_name`, `product_id`, `operator_id`, `verb`, `general_phrase`, `specific_phrase`, `dimension`) values (?,?,?,?,?,?,?,?);"; //insert base on table
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
                    preStmt.setString(5, op.getVerb());
                    preStmt.setString(6, op.getGeneralPhrase());
                    preStmt.setString(7, op.getSpecificPhrase());
                    preStmt.setString(8, op.getDimensions());
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
    
    public static ArrayList<Operator> retrieveOperators (int productId, String userId){
        ArrayList<Operator> oList= null;
       // String email = userId.getEmail().substring(0,user.getEmail().indexOf("@"));
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from qadim_operator inner join qadim_product on qadim_product.product_id = qadim_operator.product_id where userid = ? and product_id =?;";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, userId);
            preStmt.setString(2, Integer.toString(productId));
            rs = preStmt.executeQuery();
            while (rs.next()) {
                Operator operator = new Operator(rs.getString("userid"),rs.getString("operator_name"), rs.getString("verb"), rs.getString("general_phrase"), rs.getString("specific_phrase"), rs.getString("dimension"), Integer.parseInt(rs.getString("product_id")), Integer.parseInt(rs.getString("operator_id")));
                oList.add(operator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return oList;
    }
    public static ArrayList<QadimProduct> retrieveAllProjects (String userId){ //buggy does not work. NullPointer occurs
        ArrayList<QadimProduct> products= null;
       // String email = userId.getEmail().substring(0,user.getEmail().indexOf("@"));
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from qadim_product where userid = ?;";
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
    
    public static void deleteProject(int productId , String userId) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "delete from qadim_product where product_id = ? and userid = ?;" +
                    "delete from qadim_operator where product_id = ? and userid = ?; ";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, Integer.toString(productId));
            preStmt.setString(2, userId);
            preStmt.setString(3, Integer.toString(productId));
            preStmt.setString(4, userId);
            preStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
    }
    
    public static void update(ArrayList<Operator> oList ){
        String sql = "update qadim_operator set operator_name=?, product_id=?,operator_id=?,verb=?,general_phrase=?,specific_phrase=?,dimension=? where operator_name=? and product_id=? and operator_id=?;";  
        int totalUploaded = 0;
            final int batchSize = 1000;
            int count = 0;
            ArrayList<int[]> list = new ArrayList<int[]>();
            Connection conn = null;
            PreparedStatement preStmt = null;
            ResultSet rs = null;
            try {
                conn = ConnectionManager.getConnection();
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                for (Operator op: oList) {
                    preStmt.setString(1, op.getOperatorName());
                    preStmt.setInt(2, op.getProductId());
                    preStmt.setInt(3, op.getOperatorId());
                    preStmt.setString(4, op.getVerb());
                    preStmt.setString(5, op.getGeneralPhrase());
                    preStmt.setString(6, op.getSpecificPhrase());
                    preStmt.setString(7, op.getDimensions());
                    preStmt.setString(8, op.getOperatorName());
                    preStmt.setInt(9, op.getProductId());
                    preStmt.setInt(10, op.getOperatorId());
                    
                    preStmt.addBatch();
                     System.out.println("editted 1 row of operator to db");
                    if (++count % batchSize == 0) {
                        list.add(preStmt.executeBatch());
                    }
                }
                list.add(preStmt.executeBatch());
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
