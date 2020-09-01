/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poc.bo;

import java.util.Map;

/**
 *
 * @author Sandipan
 */
public class UserBO {
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

    @Override
    public String toString() {
        return "UserBO{" + "name=" + name + ", userId=" + userId + ", country=" + country +  '}';
    }
    
    
    
}
