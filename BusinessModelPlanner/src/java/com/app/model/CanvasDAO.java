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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Dell
 */
public class CanvasDAO {

    public ArrayList<String> retrieveAllCompanies() {
        ArrayList<String> companyList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from channel_strategy";
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String companyName = rs.getString("company");
                boolean check = false;

                for (String name : companyList) {
                    if (name.equals(companyName)) {
                        check = true;
                    }
                }

                if (!check) {
                    companyList.add(companyName);
                }
            }
            sql = "Select * from cost_management";
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String companyName = rs.getString("company");
                boolean check = false;

                for (String name : companyList) {
                    if (name.equals(companyName)) {
                        check = true;
                    }
                }

                if (!check) {
                    companyList.add(companyName);
                }
            }
            sql = "Select * from customer_acquisition";
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String companyName = rs.getString("company");
                boolean check = false;

                for (String name : companyList) {
                    if (name.equals(companyName)) {
                        check = true;
                    }
                }

                if (!check) {
                    companyList.add(companyName);
                }
            }
            sql = "Select * from customer_relations";
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String companyName = rs.getString("company");
                boolean check = false;

                for (String name : companyList) {
                    if (name.equals(companyName)) {
                        check = true;
                    }
                }

                if (!check) {
                    companyList.add(companyName);
                }
            }
            sql = "Select * from key_activities";
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String companyName = rs.getString("company");
                boolean check = false;

                for (String name : companyList) {
                    if (name.equals(companyName)) {
                        check = true;
                    }
                }

                if (!check) {
                    companyList.add(companyName);
                }
            }
            sql = "Select * from key_partnerships";
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String companyName = rs.getString("company");
                boolean check = false;

                for (String name : companyList) {
                    if (name.equals(companyName)) {
                        check = true;
                    }
                }

                if (!check) {
                    companyList.add(companyName);
                }
            }
            sql = "Select * from key_resources";
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String companyName = rs.getString("company");
                boolean check = false;

                for (String name : companyList) {
                    if (name.equals(companyName)) {
                        check = true;
                    }
                }

                if (!check) {
                    companyList.add(companyName);
                }
            }
            sql = "Select * from revenues";
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String companyName = rs.getString("company");
                boolean check = false;

                for (String name : companyList) {
                    if (name.equals(companyName)) {
                        check = true;
                    }
                }

                if (!check) {
                    companyList.add(companyName);
                }
            }
            sql = "Select * from value_proposition";
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String companyName = rs.getString("company");
                boolean check = false;

                for (String name : companyList) {
                    if (name.equals(companyName)) {
                        check = true;
                    }
                }

                if (!check) {
                    companyList.add(companyName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return companyList;
    }

    public ArrayList<CanvasCompany> retrieveCompanyDetailsByName(String companyName) {
        ArrayList<CanvasCompany> companyList = new ArrayList<>();
        CanvasCompany company = null;
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from channel_strategy where company like '%' ? '%'";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, companyName);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                company = new CanvasCompany(rs.getString("company"), rs.getString("choice"), rs.getString("description"), "Channel Strategy");
                companyList.add(company);
            }
            sql = "Select * from cost_management where company like '%' ? '%'";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, companyName);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                company = new CanvasCompany(rs.getString("company"), rs.getString("choice"), rs.getString("description"), "Cost Management");
                companyList.add(company);
            }
            sql = "Select * from customer_acquisition where company like '%' ? '%'";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, companyName);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                company = new CanvasCompany(rs.getString("company"), rs.getString("choice"), rs.getString("description"), "Customer Acquisition");
                companyList.add(company);
            }
            sql = "Select * from customer_relations where company like '%' ? '%'";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, companyName);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                company = new CanvasCompany(rs.getString("company"), rs.getString("choice"), rs.getString("description"), "Customer Relations");
                companyList.add(company);
            }
            sql = "Select * from key_activities where company like '%' ? '%'";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, companyName);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                company = new CanvasCompany(rs.getString("company"), rs.getString("choice"), rs.getString("description"), "Key Activities");
                companyList.add(company);
            }
            sql = "Select * from key_partnerships where company like '%' ? '%'";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, companyName);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                company = new CanvasCompany(rs.getString("company"), rs.getString("choice"), rs.getString("description"), "Key Partnerships");
                companyList.add(company);
            }
            sql = "Select * from key_resources where company like '%' ? '%'";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, companyName);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                company = new CanvasCompany(rs.getString("company"), rs.getString("choice"), rs.getString("description"), "Key Resources");
                companyList.add(company);
            }
            sql = "Select * from revenues where company like '%' ? '%'";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, companyName);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                company = new CanvasCompany(rs.getString("company"), rs.getString("choice"), rs.getString("description"), "Revenues");
                companyList.add(company);
            }
            sql = "Select * from value_proposition where company like '%' ? '%'";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, companyName);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                company = new CanvasCompany(rs.getString("company"), rs.getString("choice"), rs.getString("description"), "Value Proposition");
                companyList.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return companyList;
    }

    public ArrayList<String> retrieveTraitsByDriver(String driverName) {
        ArrayList<String> traitsList = new ArrayList<String>();
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select choice from ?";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, driverName);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String trait = rs.getString("choice");
                traitsList.add(trait);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return traitsList;
    }

    public HashMap<String, ArrayList<String>> retrieveAll() {
        HashMap<String, ArrayList<String>> allMap = new HashMap<>();
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from channel_strategy"; //get all traits and details from first value driver. then repeat this for the rest, to add all into allMap.
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String trait = rs.getString("choice");
                String companyName = rs.getString("company");
                if (allMap.containsKey(trait)) {
                    ArrayList<String> traitCompanies = allMap.get(trait);
                    traitCompanies.add(companyName);
                    allMap.put(trait, traitCompanies);
                } else {
                    ArrayList<String> newTraitCompanies = new ArrayList<>();
                    newTraitCompanies.add(companyName);
                    allMap.put(trait, newTraitCompanies);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from cost_management"; //get all traits and details from first value driver. then repeat this for the rest, to add all into allMap.
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String trait = rs.getString("choice");
                String companyName = rs.getString("company");
                if (allMap.containsKey(trait)) {
                    ArrayList<String> traitCompanies = allMap.get(trait);
                    traitCompanies.add(companyName);
                    allMap.put(trait, traitCompanies);
                } else {
                    ArrayList<String> newTraitCompanies = new ArrayList<>();
                    newTraitCompanies.add(companyName);
                    allMap.put(trait, newTraitCompanies);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }

        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * customer_acquisition"; //get all traits and details from first value driver. then repeat this for the rest, to add all into allMap.
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String trait = rs.getString("choice");
                String companyName = rs.getString("company");
                if (allMap.containsKey(trait)) {
                    ArrayList<String> traitCompanies = allMap.get(trait);
                    traitCompanies.add(companyName);
                    allMap.put(trait, traitCompanies);
                } else {
                    ArrayList<String> newTraitCompanies = new ArrayList<>();
                    newTraitCompanies.add(companyName);
                    allMap.put(trait, newTraitCompanies);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from customer_relations"; //get all traits and details from first value driver. then repeat this for the rest, to add all into allMap.
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String trait = rs.getString("choice");
                String companyName = rs.getString("company");
                if (allMap.containsKey(trait)) {
                    ArrayList<String> traitCompanies = allMap.get(trait);
                    traitCompanies.add(companyName);
                    allMap.put(trait, traitCompanies);
                } else {
                    ArrayList<String> newTraitCompanies = new ArrayList<>();
                    newTraitCompanies.add(companyName);
                    allMap.put(trait, newTraitCompanies);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from key_activities"; //get all traits and details from first value driver. then repeat this for the rest, to add all into allMap.
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String trait = rs.getString("choice");
                String companyName = rs.getString("company");
                if (allMap.containsKey(trait)) {
                    ArrayList<String> traitCompanies = allMap.get(trait);
                    traitCompanies.add(companyName);
                    allMap.put(trait, traitCompanies);
                } else {
                    ArrayList<String> newTraitCompanies = new ArrayList<>();
                    newTraitCompanies.add(companyName);
                    allMap.put(trait, newTraitCompanies);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from key_partnerships"; //get all traits and details from first value driver. then repeat this for the rest, to add all into allMap.
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String trait = rs.getString("choice");
                String companyName = rs.getString("company");
                if (allMap.containsKey(trait)) {
                    ArrayList<String> traitCompanies = allMap.get(trait);
                    traitCompanies.add(companyName);
                    allMap.put(trait, traitCompanies);
                } else {
                    ArrayList<String> newTraitCompanies = new ArrayList<>();
                    newTraitCompanies.add(companyName);
                    allMap.put(trait, newTraitCompanies);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from key_resources"; //get all traits and details from first value driver. then repeat this for the rest, to add all into allMap.
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String trait = rs.getString("choice");
                String companyName = rs.getString("company");
                if (allMap.containsKey(trait)) {
                    ArrayList<String> traitCompanies = allMap.get(trait);
                    traitCompanies.add(companyName);
                    allMap.put(trait, traitCompanies);
                } else {
                    ArrayList<String> newTraitCompanies = new ArrayList<>();
                    newTraitCompanies.add(companyName);
                    allMap.put(trait, newTraitCompanies);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from revenues"; //get all traits and details from first value driver. then repeat this for the rest, to add all into allMap.
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String trait = rs.getString("choice");
                String companyName = rs.getString("company");
                if (allMap.containsKey(trait)) {
                    ArrayList<String> traitCompanies = allMap.get(trait);
                    traitCompanies.add(companyName);
                    allMap.put(trait, traitCompanies);
                } else {
                    ArrayList<String> newTraitCompanies = new ArrayList<>();
                    newTraitCompanies.add(companyName);
                    allMap.put(trait, newTraitCompanies);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        try {
            conn = ConnectionManager.getConnection();
            String sql = "Select * from value_proposition"; //get all traits and details from first value driver. then repeat this for the rest, to add all into allMap.
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                String trait = rs.getString("choice");
                String companyName = rs.getString("company");
                if (allMap.containsKey(trait)) {
                    ArrayList<String> traitCompanies = allMap.get(trait);
                    traitCompanies.add(companyName);
                    allMap.put(trait, traitCompanies);
                } else {
                    ArrayList<String> newTraitCompanies = new ArrayList<>();
                    newTraitCompanies.add(companyName);
                    allMap.put(trait, newTraitCompanies);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
        }
        return allMap;
    }

    public HashMap<String, Integer> resultsFromAllTraitsSelected(ArrayList<String> selectedTraits, HashMap<String, ArrayList<String>> allData) {
        HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
        for (String trait : selectedTraits) {
            ArrayList<String> companiesWithTrait = allData.get(trait); //null pointer here. may be data doesn't tally.
            if (companiesWithTrait != null || companiesWithTrait.size() != 0) {

                for (String company : companiesWithTrait) {
                    if (resultMap.containsKey(company)) {
                        int count = resultMap.get(company);
                        count++;
                        resultMap.put(company, count);
                    } else {
                        resultMap.put(company, 1);
                    }
                }
            }
        }
        return resultMap;
    }

    public HashMap<String, Integer> nearestSearchFromResults(HashMap<String, Integer> resultsFromAllTraitsSelected) {
        HashMap<String, Integer> nearestResults = new HashMap<String, Integer>();
        Iterator iter = resultsFromAllTraitsSelected.entrySet().iterator();

        /* while(iter.hasNext()) {
            String company = (String) iter.next();
            int sum = resultsFromAllTraitsSelected.get(company);
            if(sum >= counter) {
                nearestResults.put(company, sum);
                counter = sum;
            }
        } */
        int maxValue = (Collections.max(resultsFromAllTraitsSelected.values()));

        while (iter.hasNext()) {
            String company = (String) iter.next();
            int count = resultsFromAllTraitsSelected.get(company);
            if (count == maxValue) {
                nearestResults.put(company, count);
            }
        }
        return nearestResults;
    }

}
