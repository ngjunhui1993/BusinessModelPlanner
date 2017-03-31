/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.model.entity.BOSOperator;
import com.app.model.entity.BOSProduct;
import static java.lang.System.console;
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
                 bosProduct = new BOSProduct(rs.getString("userID"), rs.getString("project_name"),Integer.parseInt(rs.getString("product_id")),Integer.parseInt(rs.getString("original_cost")),Integer.parseInt(rs.getString("budget_required")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return bosProduct;
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
                bosProduct = new BOSProduct(rs.getString("userID"), rs.getString("project_name"),Integer.parseInt(rs.getString("product_id")),Integer.parseInt(rs.getString("original_cost")),Integer.parseInt(rs.getString("budget_required")));
                projectList.add(bosProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return projectList;
    }

    public static void createProject(String userID, String projectName, Integer productID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "INSERT into blueoceanstrategy_product(userid , project_name , product_id) values(? , ? , ?); ";
        try {
            conn = ConnectionManager.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userID);
            pstmt.setString(2, projectName);
            pstmt.setInt(3, productID);
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

    public static void createOperator(String userid, String projectName, int factorid, String factorName,int weightNumber, int gridNumber,int perUnitValueNumber,int originalValue,int newValue) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "INSERT into blueoceanstrategy_operator(userid, project_name, factor_id, factor_name, weight, grid, per_unit_value, original_value, new_value) values(?,?,?,?,?,?,?,?,?); ";
        
        try {
            conn = ConnectionManager.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            pstmt.setString(2, projectName);
            pstmt.setInt(3, factorid);
            pstmt.setString(4, factorName);
            pstmt.setInt(5, weightNumber);
            pstmt.setInt(6, gridNumber);
            pstmt.setInt(7, perUnitValueNumber);
            pstmt.setInt(8, originalValue);
            pstmt.setInt(9, newValue);
            pstmt.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);

        }
    }
    
    public static ArrayList<BOSOperator> getAllOperators(String userid, String projectName) {
        ArrayList<BOSOperator> operatorList= new ArrayList<>();
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
                int factorID = rs.getInt("factor_id");
                String factorName = rs.getString("factor_name");
                int weight = rs.getInt("weight");
                int grid = rs.getInt("grid");
                int perUnitValue = rs.getInt("per_unit_value");
                int originalValue = rs.getInt("original_value");
                int newValue = rs.getInt("new_value");
                BOSOperator operator = new BOSOperator(userID, projName, productID, factorID, factorName, weight, grid, perUnitValue, originalValue, newValue);
                operatorList.add(operator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return operatorList;
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

    public static void editOperator (String userid, String projectName, int factorid, String factorName,int weightNumber, int gridNumber,int perUnitValueNumber,int originalValue,int newValue){
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "update blueoceanstrategy_operator set factor_name = ?, weight = ? , grid = ?, per_unit_value = ?, original_value = ?, new_value = ? where userid = ?, project_name = ?, factor_id = ?";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, factorName);
            preStmt.setInt(2, weightNumber);
            preStmt.setInt(3, gridNumber);
            preStmt.setInt(4, perUnitValueNumber);
            preStmt.setInt(5, originalValue);
            preStmt.setInt(6, newValue);
            preStmt.setString(7, userid);
            preStmt.setString(8, projectName);
            preStmt.setInt(9, factorid);
            
            preStmt.executeUpdate();
        }catch(SQLException e){
            //handle exception
        }finally{
            ConnectionManager.close(conn, preStmt, rs);
        }
    }

    public static boolean checkOperatorExist (String userid, String projectName,int factorid,String factorName,int weightNumber,int gridNumber,int perUnitValueNumber,int originalValue,int newValue){
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        boolean operatorExist = false;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "select * from blueoceanstrategy_operator where factor_name = ?, weight = ? , grid = ?, per_unit_value = ?, original_value = ?, new_value = ?, userid = ?, project_name = ?, factor_id = ?";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, factorName);
            preStmt.setInt(2, weightNumber);
            preStmt.setInt(3, gridNumber);
            preStmt.setInt(4, perUnitValueNumber);
            preStmt.setInt(5, originalValue);
            preStmt.setInt(6, newValue);
            preStmt.setString(7, userid);
            preStmt.setString(8, projectName);
            preStmt.setInt(9, factorid);
            
            preStmt.executeUpdate();
            
            if (rs!=null){
                operatorExist = true;
            }
            return operatorExist;
        }catch (SQLException e){
            //handle exception
        }finally{
            ConnectionManager.close(conn, preStmt, rs);
        }
        return true ;// put this here to remove compile error only. remove this part if necessary
    }
    // this method is created by JH. will take in all the arrays and values to be saved in the db.
    // here are the arrays
    // factors , grids , greendots , bluedots , pricepoints , weights 
    // here are the values : projectName , userID , currentValue , newValue.
    public static boolean saveProjectOperators(ArrayList<String> factors , ArrayList<String> grids , ArrayList<String> greenDots , 
                                    ArrayList<String> blueDots , ArrayList<String> pricePoints , ArrayList<String> weights , String projectName , 
                                    String userID , int column, int productID ){
        
   // this method is created by JH. will take in all the arrays and values to be saved in the db.
    // here are the arrays
    // factors , grids , greendots , bluedots , pricepoints , weights 
    // here are the values : projectName , userID , currentValue , newValue , column
        // establish connection
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql ;
        boolean done = false ;
      //  int numProjects = retrieveNoOfProjects(userID);
      
        // done establishing connection
        // i think i will use the update sql statement
        // note those suppose to be int must change to int.
        // sequence also should be noted. not sure if based on the index is accurate. 
        //checking should be done at BOSC.jsp script
        try {
            conn = ConnectionManager.getConnection();
            // if projectID = 1 , i am a new user. go ahead and insert, no need to update.
            // if projectID more than 1, then i have existing project, check to see if project name is existing. if yes, obtain its projectID.
            sql = "insert into blueoceanstrategy_operator(userid, project_name, product_id, factor_id, factor_name, weight, grid, per_unit_value, original_value, new_value) values (?,?,?,?,?,?,?,?,?,?);" ;
            for(int i =1 ; i <=column  ; i ++){
                pstmt = conn.prepareStatement(sql);
                //select clause
                
                //where clause
                pstmt.setString(1,userID );
                pstmt.setString(2,projectName );
                pstmt.setInt(3,productID );
                pstmt.setInt(4,i );
                pstmt.setString(5, factors.get(i-1));
                pstmt.setInt(6,Integer.parseInt(weights.get(i-1)) );
                pstmt.setInt(7 ,Integer.parseInt(grids.get(i-1)) );
                pstmt.setInt(8 ,Integer.parseInt(pricePoints.get(i-1)) );
                pstmt.setInt(9 ,Integer.parseInt(blueDots.get(i-1)) );
                pstmt.setInt(10 ,Integer.parseInt(greenDots.get(i-1)) );
                pstmt.executeUpdate();
                
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
            
            System.out.println("error in saving to database in bosdao");
            return false;
            
        }finally{
            ConnectionManager.close(conn, pstmt, rs);
            done = true ;
        }
        System.out.println("Saved BOSC operators.");
        
        return true ;// temporarily
    }
    
    // this method saves the product table, the one above saves the product operators.
    public static boolean saveProject(String userID , String projectName , int productID, double originalCost , double budget ){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql ;
        try{
            conn = ConnectionManager.getConnection();
            sql = "INSERT INTO `blueoceanstrategy_product`(`userID`, `project_name`, `product_id`, `original_cost`, `budget_required`) VALUES (?,?,?,?,?); ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userID);
            pstmt.setString(2, projectName);
            pstmt.setInt(3, productID);
            pstmt.setDouble(4, originalCost);
            pstmt.setDouble(5, budget);
            pstmt.executeUpdate();
            
            
            
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(userID);
            System.out.println("Problem with saveProject method in bosdao");
            
            
        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println("Something is null");
            
        }
        finally{
            ConnectionManager.close(conn, pstmt, rs); 
            
        }
        
        return true; //temporarily
    }
    
    
}
