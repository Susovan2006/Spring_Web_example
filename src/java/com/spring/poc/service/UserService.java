package com.spring.poc.service;

import com.spring.poc.bo.UserBO;
import java.util.Map;

public interface UserService {

	public void insertUser(UserBO userBO);
        public void deleteUser(UserBO userBO);
        public void updateUser(UserBO userBO);
        public void searchUser(UserBO userBO);
	public Map<String,String> getAllCountries();
	
}
