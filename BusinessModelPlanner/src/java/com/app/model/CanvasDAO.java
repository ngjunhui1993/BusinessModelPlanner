/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;
import com.app.model.entity.CanvasCompany;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class CanvasDAO {

    public ArrayList<CanvasCompany> retrieveCompanyDetailsByName(String companyName) {
        ArrayList<CanvasCompany> companyList = new ArrayList<>();
        CanvasCompany company = null;
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from data where company like '%' ? '%'";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, companyName);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                company = new CanvasCompany(rs.getString("company"), rs.getString("choice"), rs.getString("description"));
                companyList.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return companyList;
    }
 
    
    
    
}
