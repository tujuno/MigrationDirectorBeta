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
public class NamespaceDAO {
    
    DatabaseManager dbmanager = new DatabaseManager();
    Statement statement;
    ResultSet rs;
    
    public NamespaceDAO(){
        
    }
    
    public boolean isTableEmpty(){
        
        boolean result= true;
        Connection newconn = dbmanager.getConnection();
        
        try {
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT COUNT(*) FROM NAMESPACE");
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
            rs = statement.executeQuery("SELECT * FROM NAMESPACE");
            argRs = rs;
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return argRs;
        
    }
    
    public ResultSet retrieveDBContents(String condition){
    
        ResultSet argRs = null;
        Connection newconn = dbmanager.getConnection();
        
        try {
            
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT * FROM NAMESPACE WHERE NAMESPACEID='"+condition+"'");
            argRs = rs;
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return argRs;
        
    }
    
    public boolean recordExist(String condition){
    
        boolean result = false;
        Connection newconn = dbmanager.getConnection();
        
        try {
            
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT NAMESPACEID FROM NAMESPACE WHERE NAMESPACEID='"+condition+"'");
                        
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
    
    public boolean execute(String argNameidorig, String argNameid, String argNamespace, String argCharpresent, String argAction){
   
        boolean result = false;
        
        switch(argAction){
            case "A":   result = insertQuery(argNameid, argNamespace, argCharpresent);
                        break;
            case "U":   result = updateQuery(argNameidorig, argNameid, argNamespace, argCharpresent);
                        break;
            case "D":   result = deleteQuery(argNameidorig);
                        break;
        }      
        
        return result;
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
    
    private boolean insertQuery(String argNameId, String argNamespace, String argCharpresent){
    
    boolean result = false;
    
    String query = "INSERT INTO NAMESPACE VALUES('"+argNameId+"','"+argNamespace+"','"+argCharpresent+"');";

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
    
    private boolean updateQuery(String argNameidorig, String argNameid, String argNamespace, String argCharpresent){
    
    boolean result = false;    
        
    Connection newconn = dbmanager.getConnection();
    
    String query = "UPDATE NAMESPACE SET NAMESPACEID='"+argNameid+"', NAME='"+argNamespace+"', CHARPRESENT='"+argCharpresent+"' WHERE NAMESPACEID = '"+argNameidorig+"';";
    
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
    
    private boolean deleteQuery(String argNameidorig){
    
    boolean result = false;
        
    Connection newconn = dbmanager.getConnection();
    
    String query = "DELETE FROM NAMESPACE WHERE NAMESPACEID = '"+argNameidorig+"'";
        
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
