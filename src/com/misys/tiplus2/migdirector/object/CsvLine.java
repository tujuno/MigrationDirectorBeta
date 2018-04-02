/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misys.tiplus2.migdirector.object;

import java.util.Map;

/**
 *
 * @author falmarez
 */
public class CsvLine {

    int recordNum;

    Map<String,String> content;
    
    public CsvLine(){
    
    
    }
    
    public int getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(int recordNum) {
        this.recordNum = recordNum;
    } 

    public Map<String, String> getContent() {
        return content;
    }

    public void setContent(Map<String, String> content) {
        this.content = content;
    }
    
}
