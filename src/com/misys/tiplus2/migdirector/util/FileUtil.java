/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misys.tiplus2.migdirector.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author falmarez
 */
public class FileUtil {
    
    public FileUtil(){
    
    }
    
    public void saveToFile(String argLocation, String argContent){
    
        try {
            File newFile = new File(argLocation.concat("/").concat(generateUuid()).concat(".xml"));
            newFile.createNewFile();
            
            FileWriter fw = new FileWriter(newFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(argContent);
            
            bw.close();
            fw.close();
            
        } catch (Exception ex) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private String generateUuid(){
    
        String id = "";
        
        UUID uniqueId = UUID.randomUUID();
        id = uniqueId.toString();
        
        return id;
        
    }
}
