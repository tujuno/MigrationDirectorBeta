/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misys.tiplus2.migdirector.dao;

import com.misys.tiplus2.migdirector.connector.DatabaseManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author falmarez
 */
public class SettingsDAO {
    
    DatabaseManager dbmanager = new DatabaseManager();
    Statement statement;
    ResultSet rs;
    
    public boolean isTableEmpty(){
   
     boolean result= true;
        Connection newconn = dbmanager.getConnection();
        
        try {
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT COUNT(*) FROM SETTINGS");
            rs.next();
            
                if(rs.getInt(1)>0){
                result = false;
                }
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        return result;
    }
    
    public ResultSet retrieveDBContents(){
    
        ResultSet argRs = null;
        Connection newconn = dbmanager.getConnection();
        
        try {
            
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT * FROM SETTINGS");
            argRs = rs;
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return argRs;
        
    }

    public ResultSet retrieveDBContents(String argParam){
    
        ResultSet argRs = null;
        Connection newconn = dbmanager.getConnection();
        
        try {
            
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT * FROM SETTINGS WHERE NAME='"+argParam+"'");
            argRs = rs;
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return argRs;
        
    }
    
    public void closeResultSet() {
        try {
            this.rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MappingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean execute(String argName, String argValue) {
         
    boolean result = false;
    
    String query = "UPDATE SETTINGS SET VALUE='"+argValue+"' WHERE NAME='"+argName+"'";

    Connection newconn = dbmanager.getConnection();
        
        try {
            statement = newconn.createStatement();
            statement.executeUpdate(query);
            
            statement.close();
            newconn.close();
               
            result = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return result;

    }
    
}
