/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

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
        int totalUploaded = 0;
        final int batchSize = 1000;
        int count = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        if (operator.isEmpty()) {
            //input error;
        } else {
            String sql = "insert into qadim_operator(operator_name, product_id,operator_id,verb,general_phrase,specific_phrase,dimension) values (?,?,?,?,?,?,?);"; //insert base on table
            Connection conn = null;
            PreparedStatement preStmt = null;
            ResultSet rs = null;
            try {
                conn = ConnectionManager.getConnection();
                conn.setAutoCommit(false);
                preStmt = conn.prepareStatement(sql);
                for (Operator op: operator) {
                    preStmt.setString(1, op.getOperatorName());
                    preStmt.setString(2, op.getVerb());
                    preStmt.setString(3, op.getGeneralPhrase());
                    preStmt.setString(4, op.getSpecificPhrase());
                    preStmt.setString(5, op.getDimensions());
                    preStmt.setString(6, Integer.toString(op.getProductId()));
                    preStmt.setString(7, Integer.toString(op.getOperatorId()));
                    preStmt.addBatch();

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
    }
    
}
