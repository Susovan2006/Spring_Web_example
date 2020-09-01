/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poc.utils;


import java.util.Properties;

/**
 *
 * @author Sandipan
 */
public class ConfigProperties extends Properties {   

     
    public ConfigProperties(String location) {
        
    	try {              		
            super.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(location));
             } 
        catch (Exception ex) {
    		ex.printStackTrace();
        }       
        
    }
    
    
    
}
