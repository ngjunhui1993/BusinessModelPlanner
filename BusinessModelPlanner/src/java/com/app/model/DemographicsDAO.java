package com.app.model;

import com.app.model.ConnectionManager;
import com.app.model.entity.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.text.*;
import javax.servlet.RequestDispatcher;
/**
  * A DemographicsDAO retrieves information from the demographics database.
  */
public class DemographicsDAO {
	
    private LinkedHashMap userList;
    private String demographicsCSV  = "demographics";
/**
  * The default constructor
  */
    public DemographicsDAO(){
        userList = new LinkedHashMap();
        this.loadData();
    }
/**
  * This method retrieves a Demographics entity with the specified macAddress
  * @param macAddress String  macAddress to filter the correct demographic entity.
  * @return demographics object
  */
    public Demographics retrieve(String email){
        Demographics u = (Demographics)userList.get(email);
        //if(u!=null) System.out.println("Getting user :"+u.getMacAddress() + "s");
        return u;
    }//end of retrieve method
/**
  * This method checks that the user exist in the database.
  * @param macAddress String macAddress to be validated.
  * @return true if the user exists in the database , false if the user does not exist in the database.
  */
    public boolean userExist(String email){
        if((Demographics)userList.get(email) != null) return true;
        return false;
    }//end of method
      
    
    public void loadData(){

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Demographics user = null;

        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT name, password, email, userid FROM "+demographicsCSV);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                String password = rs.getString(2);
                String email = rs.getString(3);

                int n = email.indexOf('@');
                int end = email.indexOf(".",n);
                String school = email.substring((n+1),end);
                String userId = rs.getString(4);
                String year = email.substring((n-4),n);

                Demographics u = new Demographics(name,password,email,userId);
                userList.put(email,u);
            }	
        }catch(SQLException e){
            System.out.println("Error Occured in DemographicsDAO.loadData");
                //e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
    }//end of loadData method

/**
  * This method retrieves all the demographics objects in the database.
  * @return an Array list of all the demographics objects.
  */      
    public ArrayList<Demographics> retrieveAll(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Demographics> users = new ArrayList<Demographics>();
        
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT name, password, email, userid FROM demographics");
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
              String email = rs.getString(3);
              int n = email.indexOf("@");
              String userId = rs.getString(4);
              int end = email.indexOf(".",n);
              String school = email.substring(n+1,end);
              String year = email.substring((n-4),n);
              
              users.add(new Demographics(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
              
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ConnectionManager.close(conn, pstmt, rs);
        }
        
        return users;
    }
    
 /**
  * This method retrieves a demographic object of the specified username
  * @param username
  * @return a Demographics object. 
  */  
    public static Demographics retrieveByUsername(String username){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Demographics user = null;
        
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT name, password, email, userid FROM demographics");
            //pstmt.setString(1, "'" + username + "%'");
            rs = pstmt.executeQuery();
            while (rs.next()) {
              String email = rs.getString(3);
              int n = email.indexOf("@");
              String userName = email.substring(0, n);
              int end = email.indexOf(".",n);
              String school = email.substring(n+1,end);
              String year = email.substring((n-4),n);
              
              
              if(username.equals(userName)){
                user = new Demographics(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
              }
            }

            }catch(SQLException e){
             e.printStackTrace();
            } finally {
              ConnectionManager.close(conn, pstmt, rs);
            }
        
        return user;

        }
    
    public static String register(String name, String password, String email, String userid){
        Connection conn = null ;
            PreparedStatement pstmt = null ;
            ResultSet rs = null ;
            String statement = null ;
            System.out.println("there is no problem with the validations it is with the connection manager and sql");
            try{
                conn = ConnectionManager.getConnection();
                System.out.println("There is no problem with connection Manager");
                
                pstmt = conn.prepareStatement("INSERT INTO demographics (name, password, email,userid) VALUES (?, ?, ?,?)");
                pstmt.setString(1 , name);
                pstmt.setString(2 , password);
                pstmt.setString(3 , email);
                pstmt.setString(4 , userid);
                pstmt.executeUpdate();
                
                    
            }catch(Exception e){
                System.out.println("There is an error while adding new user");
                e.printStackTrace();
            }finally{
                ConnectionManager.close(conn , pstmt , rs);
                
            }
            return "Congratulation! Your account has been created!";
    }
    
}//end of class