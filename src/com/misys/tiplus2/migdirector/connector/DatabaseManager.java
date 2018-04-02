/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misys.tiplus2.migdirector.connector;

import com.misys.tiplus2.migdirector.global.MigProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author falmarez
 */
public class DatabaseManager {
    
    Connection connection = null;
    
    public Connection getConnection(){
    
    String workingDir = System.getProperty("user.dir");
    
    try {
	Class.forName(MigProperties.DATABASE_DRIVER_CLASS);
	this.connection = DriverManager.getConnection(MigProperties.DATABASE_URL.concat(workingDir).concat(MigProperties.DATABASE_LOC).concat("/")
                .concat(MigProperties.DATABASE_NAME), MigProperties.DATABASE_USER, MigProperties.DATABASE_PASSWORD);
        

        /*
	statement = connection.createStatement();
        System.out.println("workingDir" + workingDir);
        resultSet = statement.executeQuery("SELECT * FROM NAMESPACE");
			while (resultSet.next()) {
				System.out.println("reports:"
						+ resultSet.getString("NAMESPACEID"));
			}
        
          */   
                
	} catch (Exception e) {
        e.printStackTrace();
        }
    
     return connection;
    }
    
    public void close(){
        try {
            this.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
