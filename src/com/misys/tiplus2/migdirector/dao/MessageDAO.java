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
public class MessageDAO {
    
    DatabaseManager dbmanager = new DatabaseManager();
    Statement statement;
    ResultSet rs;
    
    public boolean isTableEmpty(){
    
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
    
    public ResultSet retrieveDBContents(){
    
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

    public void closeStatement(){
        
        try {
            this.statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }     
        
    public void closeResultSet(){
         
        try {
            this.rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void closeDBManager(){
    
        this.closeDBManager();
    
    }

    public boolean recordExists(String condition) {
        
        boolean result = false;
        Connection newconn = dbmanager.getConnection();
        
        try {
            
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT NAME FROM MESSAGE WHERE NAME='"+condition+"'");
                        
            if(rs.next()){
            result = true;
            }
            
            statement.close();
            rs.close();
            newconn.close();
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return result;
    }

    public boolean execute(String argNameorig, String argName, String argTiName, String argDescription, String argAction) {
       boolean result = false;
        
        switch(argAction){
            case "A":   result = insertQuery(argName, argTiName, argDescription);
                        break;
            case "U":   result = updateQuery(argNameorig, argName, argTiName, argDescription);
                        break;
            case "D":   result = deleteQuery(argNameorig);
                        break;
        }      
        
        return result;
    }

    private boolean insertQuery(String argName, String argTiName, String argDescription) {
    
        boolean result = false;

        String query = "INSERT INTO MESSAGE VALUES('"+argName+"','"+argTiName+"','"+argDescription+"');";

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

    private boolean updateQuery(String argNameorig, String argName, String argTiName, String argDescription) {
    
        boolean result = false;    

        Connection newconn = dbmanager.getConnection();

        String query = "UPDATE MESSAGE SET NAME='"+argName+"', TINAME='"+argTiName+"', DESCRIPTION='"+argDescription+"' WHERE NAMESPACEID = '"+argNameorig+"';";

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

    private boolean deleteQuery(String argNameorig) {
        
    boolean result = false;
        
    Connection newconn = dbmanager.getConnection();
    
    String query = "DELETE FROM MESSAGE WHERE NAME = '"+argNameorig+"'";
        
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

    public ResultSet retrieveDBContents(String condition) {
        
        ResultSet argRs = null;
        Connection newconn = dbmanager.getConnection();
        
        try {
            
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT * FROM MESSAGE WHERE NAME='"+condition+"'");
            argRs = rs;
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return argRs;
        
    }
    
}
