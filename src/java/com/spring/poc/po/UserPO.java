/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poc.po;

/**
 *
 * @author Sandipan
 */
public class UserPO {
    
    String name="" ;
    String userId="";
    String country="";
    
    
    public void clear(){
      name="";
      userId="";
      country="" ;
      
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    
    
}
