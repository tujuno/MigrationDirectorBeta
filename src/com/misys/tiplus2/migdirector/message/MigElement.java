/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misys.tiplus2.migdirector.message;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author falmarez
 */
public class MigElement {
   
    String id;
    String name;
    String source;
    String namespace;
    String parent;

    List<String> child;
            
    Element elem;
    
    boolean isBoolean;
    boolean noValue;
    int targetLength;

    public MigElement(){
    
    }

    public MigElement(String id,String target, String source, String namespace, String parent, boolean isBoolean, boolean noValue, int targetLength) {

        this.id = id;
        this.name = target;
        this.source = source;
        this.namespace = namespace;
        this.parent = parent;
        this.child = new ArrayList<String>();
        this.isBoolean = isBoolean;
        this.noValue = noValue;
        this.targetLength = targetLength;
        
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
     public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
    
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
    
    public List<String> getChild() {
        return child;
    }

    public void setChild(List<String> child) {
        this.child = child;
    }

    public Element getElem() {
        return elem;
    }

    public void setElem(Element elem) {
        this.elem = elem;
    }
     
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void addChild(String argChild){
    
        String tempchild = argChild;
        this.child.add(tempchild);
    }

    public void setElem(Document newDoc) {
        
        this.elem = newDoc.createElement(this.namespace.concat(":").concat(this.name));
        
    }
    
    public boolean isIsBoolean() {
        return isBoolean;
    }

    public void setIsBoolean(boolean isBoolean) {
        this.isBoolean = isBoolean;
    }

    public boolean isNoValue() {
        return noValue;
    }

    public void setNoValue(boolean noValue) {
        this.noValue = noValue;
    }

    public int getTargetLength() {
        return targetLength;
    }

    public void setTargetLength(int targetLength) {
        this.targetLength = targetLength;
    }
       
}
