/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poc.validator.utils;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 *
 * @author Sandipan
 */
public class ValidatorUtils extends ValidationUtils {
    
      public static final String INSERT="insert";
      public static final String UPDATE="update";
      public static final String DELETE="delete";
      public static final String SEARCH="search";
    
    public static boolean checkNumeric(String str,Errors errors,String fieldName,String messageKey){    
        boolean isNumeric=false;
        int strlen=str.length();
        for(int i=0;i<strlen;i++)
        {
           int ascii=str.charAt(i);
           if(ascii>47 && ascii<58)
           isNumeric=true;
           else{
           isNumeric=false;
           break;
               }
        }
        if(!isNumeric)       
       errors.rejectValue(fieldName,messageKey);
        
        return isNumeric ;
    }
    
    public static boolean checkAccurateLength(String str,int desiredLength,Errors errors,String fieldName,String messageKey){    
        boolean isOK=true ;
        int strlen=str.length();
        if(strlen!=desiredLength){   
        isOK=false ;    
        errors.rejectValue(fieldName,messageKey);
        }
        return isOK ;
    }
    
    
}
