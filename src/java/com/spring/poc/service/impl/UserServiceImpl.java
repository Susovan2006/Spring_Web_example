package com.spring.poc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import com.spring.poc.bo.UserBO;
import com.spring.poc.dao.UserDAO;
import com.spring.poc.po.UserPO;
import com.spring.poc.service.UserService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDAO userDAO;  
    
   
    
    
	@Override
	public void insertUser(UserBO userBO) {
            
		//Persist the user object here.                 
                UserPO userPO=new UserPO();
                userPO.setCountry(userBO.getCountry());
                userPO.setName(userBO.getName());
                userPO.setUserId(userBO.getUserId());
                userDAO.insertUser(userPO);	

	}
        
        @Override
	public void deleteUser(UserBO userBO) {
		//Persist the user object here. 
                userDAO.deleteUser(userBO.getUserId());		

	}
        
        @Override
	public void updateUser(UserBO userBO) { 
                UserPO userPO=new UserPO();
                userPO.setCountry(userBO.getCountry());
                userPO.setName(userBO.getName());
                userPO.setUserId(userBO.getUserId());
                userDAO.updateUser(userPO);
		System.out.println("User updated successfully" + userBO);

	}
        
        @Override
	public void searchUser(UserBO userBO) {
		//Persist the user object here. 
                UserPO userPO=userDAO.searchUser(userBO.getUserId());		
                userBO.setCountry(userPO.getCountry());
                userBO.setName(userPO.getName());
                userBO.setUserId(userPO.getUserId());               

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String,String> getAllCountries() {
            
		Map<String,String> countryList = new HashMap<String,String>();
                
                for(String country : userDAO.getAllCountries())
		countryList.put(country,country);
                
		return countryList;
	}


}
