/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poc.dao;

import com.spring.poc.po.UserPO;
import java.util.List;

/**
 *
 * @author Sandipan
 */
public interface UserDAO {
    
        public void insertUser(UserPO userPO);
        public void deleteUser(String userId);
        public void updateUser(UserPO userPO);
        public UserPO searchUser(String userId);
        public List<String> getAllCountries();
    
}
