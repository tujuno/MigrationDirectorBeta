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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author falmarez
 */
public class RunDAO {
    
    DatabaseManager dbmanager = new DatabaseManager();
    Statement statement;
    ResultSet rs;
    
    public RunDAO(){
       
    }

    public boolean isTableEmptyMessage() {
        
        boolean result= true;
        
        Connection newconn = dbmanager.getConnection();
        
        try {
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT COUNT(*) FROM MESSAGE");
            rs.next();
            
                if(rs.getInt(1)>0){
                result = false;
                }
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        return result;
    }
    
    public boolean isTableEmptySettings(){
        
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

    public ResultSet retrieveDBContentsMessage() {
      
        ResultSet argRs = null;
        Connection newconn = dbmanager.getConnection();
        
        try {
            
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT * FROM MESSAGE");
            argRs = rs;
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return argRs;
    }
    
    public ResultSet retrieveUnfinishedRuns(String argMessage) {
      
        ResultSet argRs = null;
        Connection newconn = dbmanager.getConnection();
        
        try {
            
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT * FROM RUNS WHERE STATUS<>'COMPLETED' AND MESSAGEID='"+argMessage+"'");
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
    
    private boolean insertQuery(String argMessage){
        boolean result = false;
        
        String query = "INSERT INTO RUNS(START,END,MESSAGEID,STATUS,HISTORICAL) VALUES(NOW(),NOW(),'"+argMessage+"','INITIATING',FALSE);";

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
    
    private boolean updateQuery(String argMessage) {
        
        boolean result = false;
        
        String query = "UPDATE RUNS SET END=, STATUS= WHERE MESSAGEID='"+argMessage+"' AND HISTORICAL=false;";

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

    public void execute(String argMessage, String argAction) {
       
        switch(argAction){
            case "A":   insertQuery(argMessage);
                        break;
            
            case "U":   updateQuery(argMessage);
                        break;
        }
    }


    
}
