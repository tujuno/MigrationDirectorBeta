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
public class MappingDAO {
    
    DatabaseManager dbmanager = new DatabaseManager();
    Statement statement;
    ResultSet rs;
    
    
    public MappingDAO(){
    
    }
    
    public boolean isTableEmptyMessage(){
   
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
    
    public boolean isTableEmpty(){
   
        boolean result= true;
        
        Connection newconn = dbmanager.getConnection();
        
        try {
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT COUNT(*) FROM MAPPING");
            rs.next();
            
                if(rs.getInt(1)>0){
                result = false;
                }
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        return result;
    }
    
     public boolean isRowExisting(int argOrder, String argMessage){
   
        boolean result= true;
        
        Connection newconn = dbmanager.getConnection();
        
        try {
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT COUNT(*) FROM MAPPING WHERE MAPITEMID= '"+argOrder+"' AND MESSAGEID='"+argMessage+"'");
            rs.next();
            
            System.out.println("rs.getInt(1):"+rs.getInt(1));
            
                if(rs.getInt(1)<1){
                result = false;
                }
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        return result;
    }

    public ResultSet retrieveDBContents() {
        
        ResultSet argRs = null;
        Connection newconn = dbmanager.getConnection();
        
        try {
            
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT * FROM MAPPING");
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

    public void closeStatement() {
        try {
            this.statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(MappingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public ResultSet retrieveDBContentsMessage(String condition) {
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

    public ResultSet retrieveDBContents(String condition) {
        
        ResultSet argRs = null;
        Connection newconn = dbmanager.getConnection();
        
        System.out.println("Condition:" + condition);
        
        try {
            
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT * FROM MAPPING WHERE MESSAGEID='"+condition+"' ORDER BY MAPITEMID ASC");
            argRs = rs;
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return argRs;
    }
    
    public ResultSet retrieveDBContentsWithSource(String condition) {
        
        ResultSet argRs = null;
        Connection newconn = dbmanager.getConnection();
        
        System.out.println("Condition:" + condition);
        
        try {
            
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT * FROM MAPPING WHERE MESSAGEID='"+condition+"' AND SOURCE<>'' ORDER BY MAPITEMID ASC");
            argRs = rs;
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return argRs;
    }

        public ResultSet retrieveDBContentsThruId(String argId) {
        
        ResultSet argRs = null;
        Connection newconn = dbmanager.getConnection();
        
        System.out.println("Condition:" + argId);
        
        try {
            
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT * FROM MAPPING WHERE MAPITEMID ="+Integer.parseInt(argId)+"");
            argRs = rs;
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return argRs;
    }
        
    public boolean findRecord(String argMapid){
        
        boolean result = false;
        
        Connection newconn = dbmanager.getConnection();
        
        try {
            statement = newconn.createStatement();
            rs = statement.executeQuery("SELECT COUNT(*) FROM MAPPING WHERE");
            rs.next();
            
                if(rs.getInt(1)>0){
                result = false;
                }
            
            } catch (Exception ex) {
                Logger.getLogger(NamespaceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return result;
    }

    public boolean execute(int argOrder, String argMessage, String argSource, String argTarget, int argTargetlen, String argNamespace, String argParent, String argIsboolean, String argNoValue,String argAction) {
        
        boolean result = false;
        
        switch(argAction){
            case "A":   result = insertQuery(argOrder, argMessage ,argSource, argTarget, argTargetlen, argNamespace, argParent, argIsboolean, argNoValue);
                        break;
            case "U":   result = updateQuery(argOrder, argMessage,argSource, argTarget, argTargetlen, argNamespace, argParent, argIsboolean, argNoValue);
                        break;
            case "D":   result = deleteQuery(argOrder,argMessage,argTarget);
                        break;
        }      
        
        return result;
        
    }

    private boolean insertQuery(int argOrder, String argMessage, String argSource, String argTarget, int argTargetlen, String argNamespace, String argParent, String argIsboolean, String argNoValue) {
        
        boolean result = false;
        
        String query = "INSERT INTO MAPPING VALUES("+argOrder+",'"+argMessage+"','"+argSource+"','"+argTarget+"',"+argTargetlen+",'"+argNamespace+"','"+argParent+"',"+toBoolean(argIsboolean)+","+toBoolean(argNoValue)+");";

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

    private boolean deleteQuery(int argOrder, String argMessage, String argTarget) {

         System.out.println("messageID:" + argOrder);
        
        boolean result = false;
        
        String query = "DELETE FROM MAPPING WHERE MAPITEMID='"+argOrder+"' AND MESSAGEID='"+argMessage+"' AND TARGET='"+argTarget+"';";

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

    private boolean updateQuery(int argOrder, String argMessage,String argSource, String argTarget, int argTargetlen, String argNamespace, String argParent, String argIsboolean, String argNoValue) {
        
        boolean result = false;
        
        String query = "UPDATE MAPPING SET SOURCE='"+argSource+"', TARGET='"+argTarget+"', TARGETLEN='"+argTargetlen+"',NAMESPACEID='"+argNamespace+"',PARENTID='"+argParent+"', ISBOOLEAN="+toBoolean(argIsboolean)+" , NOVALUE="+toBoolean(argNoValue)+" WHERE MAPITEMID='"+argOrder+"' AND MESSAGEID='"+argMessage+"';";

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

    private boolean toBoolean(String argBoolean){
        
        boolean result;
        
        result = argBoolean.equals("true");
        
        return result;
    }
    
}
