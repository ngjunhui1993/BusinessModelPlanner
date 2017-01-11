/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.model.entity.BOSOperator;
import com.app.model.entity.BOSProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author Dell
 */
public class BOSDAO {

    public static BOSProduct retrieveProjectByUser(String projectName, String userid) {
        BOSProduct bosProduct = null;
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from blueoceanstrategy_product where project_name = ? and userid = ?";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, projectName);
            preStmt.setString(2, userid);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                bosProduct = new BOSProduct(rs.getString("userid"), rs.getString("project_name"), Integer.parseInt(rs.getString("product_id")), rs.getString("product_name"), rs.getString("type"), rs.getDouble("budget"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return bosProduct;
    }
    
        public static ArrayList<BOSProduct> retrieveAllProjectsByUser(String userid) {
        BOSProduct bosProduct = null;
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        ArrayList<BOSProduct> projectList = new ArrayList<>();
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from blueoceanstrategy_product where userid = ?";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, userid);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                bosProduct = new BOSProduct(rs.getString("userid"), rs.getString("project_name"), Integer.parseInt(rs.getString("product_id")), rs.getString("product_name"), rs.getString("type"), rs.getDouble("budget"));
                projectList.add(bosProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return projectList;
    }

    public static void createProject(String userID, String projectName, Integer productID, String productName, String type, Double budget) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "INSERT into blueoceanstrategy_product(userid , project_name , product_id, product_name, type, budget) values(? , ? , ? , ?, ?, ?); ";
        try {
            conn = ConnectionManager.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userID);
            pstmt.setString(2, projectName);
            pstmt.setInt(3, productID);
            pstmt.setString(4, productName);
            pstmt.setString(5, type);
            pstmt.setDouble(6, budget);
            pstmt.execute();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);

        }
    }

    public static int retrieveNoOfProjects(String userId) {
        // String email = userId.getEmail().substring(0,user.getEmail().indexOf("@"));
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from blueoceanstrategy_product where userid = ?;";
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
    
    /*
        public static int retrieveNoOfOperators(String userId, String projectName) {
        // String email = userId.getEmail().substring(0,user.getEmail().indexOf("@"));
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from blueoceanstrategy_product where userid = ? and project_name = ?;";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, userId);
            preStmt.setString(2, projectName);
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
*/
    public static BOSProduct retrieveProject(String projectName) {
        BOSProduct product = null;
        // String email = userId.getEmail().substring(0,user.getEmail().indexOf("@"));
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from blueoceanstrategy_product where project_name = ?;";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, projectName);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                product = new BOSProduct(rs.getString("userid"), rs.getString("project_name"), Integer.parseInt(rs.getString("product_id")), rs.getString("product_name"), rs.getString("type"), rs.getDouble("budget"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return product;
    }

    public static ArrayList<String> retrieveOperators(String projectName, String userid) {
        ArrayList<String> operatorList = new ArrayList<String>();
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select operator_name from blueoceanstrategy_operator where project_name = ? and userid = ?;";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, projectName);
            preStmt.setString(2, userid);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                operatorList.add(rs.getString("operator_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return operatorList;
    }

    
    
    public void createOperator(String userid, String projectName, int productID, int operatorID, String operatorName, int weight, int maxValue, int perUnitValue, int originalValue, int newValue, String originalProductName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "INSERT into blueoceanstrategy_operator(userid, project_name, product_id, operator_id, operator_name, weight, max_value, per_unit_value, original_value, new_value, original_product_name) values(? , ? , ? , ?, ?, ?, ?, ?, ?, ?, ?); ";
        try {
            conn = ConnectionManager.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            pstmt.setString(2, projectName);
            pstmt.setInt(3, productID);
            pstmt.setInt(4, operatorID);
            pstmt.setString(5, operatorName);
            pstmt.setInt(6, weight);
            pstmt.setInt(7, maxValue);
            pstmt.setInt(8, perUnitValue);
            pstmt.setInt(9, originalValue);
            pstmt.setInt(10, newValue);
            pstmt.setString(11, originalProductName);
            pstmt.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);

        }
    }
    
    public HashMap<Integer, ArrayList<BOSOperator>> getAllOperators(String userid, String projectName) {
        HashMap<Integer, ArrayList<BOSOperator>> operatorMap= new HashMap<>();
       // String email = userId.getEmail().substring(0,user.getEmail().indexOf("@"));
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "select * from blueoceanstrategy_operator where userid = ? and project_name =?";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, userid);
            preStmt.setString(2, projectName);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String userID = rs.getString("userid");
                String projName = rs.getString("project_name");
                int productID = rs.getInt("product_id");
                int operatorID = rs.getInt("operator_id");
                String operatorName = rs.getString("operator_name");
                int weight = rs.getInt("weight");
                int maxValue = rs.getInt("max_value");
                int perUnitValue = rs.getInt("per_unit_value");
                int originalValue = rs.getInt("original_value");
                int newValue = rs.getInt("new_value");
                String originalName = rs.getString("original_product_name");
                BOSOperator operator = new BOSOperator(userID, projName, productID, operatorID, operatorName, weight, maxValue, perUnitValue, originalValue, newValue, originalName);
                //see weight take out value add in put back 
                
                if(operatorMap.containsKey(weight)) {
                    ArrayList<BOSOperator> update = operatorMap.get(weight);
                    update.add(operator);
                    operatorMap.put(weight, update);
                } else {
                    ArrayList<BOSOperator> newList = new ArrayList<>();
                    newList.add(operator);
                    operatorMap.put(weight, newList);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return operatorMap;
    } 
    
    //add original value
    
    public void addOriginalValue(String projectName, int operatorID, String userID, int originalValue) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "update blueoceanstrategy_operator set original_value = ? where project_name = ? and operator_id = ? and userid = ?;";
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, originalValue);
            preStmt.setString(2, projectName);
            preStmt.setInt(3, operatorID);
            preStmt.setString(4, userID);
            
            preStmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
    }

    

}
