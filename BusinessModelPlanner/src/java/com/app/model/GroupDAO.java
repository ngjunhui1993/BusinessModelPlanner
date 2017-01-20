/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.model.entity.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author jiaohui.lee.2014
 */
public class GroupDAO {
    
    private LinkedHashMap userList;
 
    public GroupDAO(){
        userList = new LinkedHashMap();
        this.loadData();
}
    
     public Group retrieveGroups(String section, String instructorEmail){
        Group u = (Group)userList.get(section);
        return u;
    }//end of retrieve method

    public boolean groupExist(String section, String instructorEmail){
        if((Group)userList.get(section) != null && (Group)userList.get(instructorEmail)!= null){
            return true;
        }
        return false;
    }//end of method
      
    
    public void loadData(){

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Group group = null;

        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM group");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String course = rs.getString(1);
                String section = rs.getString(2);
                String course_id = rs.getString(3);
                String instructorEmail = rs.getString(4);
                String password = rs.getString(5);
                Group g = new Group(course, section, instructorEmail, password);
                userList.put(instructorEmail,g);
            }	
        }catch(SQLException e){
            System.out.println("Error Occured in GroupDAO.loadData");
                //e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
    }//end of loadData method
 
    public static ArrayList<Group> retrieveAllGroups(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Group> groupList = new ArrayList<>();
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM group");
            rs = pstmt.executeQuery();
            while(rs.next()){
                String course = rs.getString(1);
                String section = rs.getString(2);
                String course_id = rs.getString(3);
                String instructorEmail = rs.getString(4);
                String password = rs.getString(5);
                Group g = new Group(course, section, instructorEmail, password);
                groupList.add(g);
            }
        }catch(SQLException e){
            System.out.print("Error Occured in GroupDAO.retrieveAllGroups");
        }finally{
            ConnectionManager.close(conn,pstmt,rs);
            return groupList;
        }
        
    }
    
    public static ArrayList<Group> retrieveGroupsByInstructor(String email){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Group> groupList = new ArrayList<>();
        try{
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * from groups where instructorEmail = ?;");
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String course = rs.getString(1);
                String section = rs.getString(2);
                String course_id = rs.getString(3);
                String instructorEmail = rs.getString(4);
                String password = rs.getString(5);
                Group g = new Group(course, section, instructorEmail, password);
                groupList.add(g);
            }
        }catch(SQLException e){
            System.out.print("Error Occured in GroupDAO.retrieveAllGroups");
        }finally{
            ConnectionManager.close(conn,pstmt,rs);
            return groupList;
        }
        
    }
    
    public static void createGroup(String course , String section , String courseid , String instructorEmail, String password){
        Connection conn = null ;
        PreparedStatement pstmt = null ;
        ResultSet rs = null ;
        String sql = "INSERT into groups(course , section , course_id, instructorEmail, password) values(?, ? , ? , ? , ?); ";
        try {
                conn = ConnectionManager.getConnection();
                conn.setAutoCommit(false);
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1 , course);
                pstmt.setString(2 , section);
                pstmt.setString(3 , courseid);
                pstmt.setString(4, instructorEmail);
                pstmt.setString(5, password);
                pstmt.execute() ;
               //System.out.println("saved 1 row of qadim to db");
               conn.commit();
               
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionManager.close(conn, pstmt, rs);
                
            }
    }
}
