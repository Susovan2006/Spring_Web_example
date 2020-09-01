/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.poc.dao.impl;

/**
 *
 * @author Sandipan
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.spring.poc.dao.UserDAO;
import com.spring.poc.po.UserPO;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{
private static final String SQL_COUNTRY_LIST="SELECT DISTINCT COUNTRY FROM USER" ;    
private static final String SQL_INSERT_USER="INSERT INTO USER (USERID,USERNAME,COUNTRY) VALUES (:userId,:userName,:country) ";
private static final String SQL_UPDATE_USER="UPDATE USER SET USERNAME=:userName,COUNTRY=:country WHERE USERID=:userId";  
private static final String SQL_DELETE_USER="DELETE FROM USER WHERE USERID=:userId";
private static final String SQL_SEARCH_USER="SELECT USERID,USERNAME,COUNTRY FROM USER WHERE USERID=:userId";


private SimpleJdbcTemplate jdbcTemplate;

@Autowired   
 public void setJdbcTemplate(DataSource dataSource) {
	    this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

@Override
public List<String> getAllCountries(){    
 RowMapper<List<String>> stdRowMapper =new RowMapper<List<String>>() {
				@Override
				public List<String> mapRow(ResultSet resultSet,int arg1)
						throws SQLException {
                                        List<String> countryList = new ArrayList<String>();                                        
                                        do{   
					countryList.add(resultSet.getString("COUNTRY")); 
                                        }while(resultSet.next());                                                         
                                        
                                        return countryList;             
                                       
				                                    }
			                                                  };
		
		return jdbcTemplate.queryForObject(SQL_COUNTRY_LIST,stdRowMapper);
	                                                             }   
 

    
 @Override
 public UserPO searchUser(String userId){    
 RowMapper<UserPO> stdRowMapper=new RowMapper<UserPO>() {
				@Override
				public UserPO mapRow(ResultSet resultSet,int arg1)
						throws SQLException {
					UserPO userPO = new UserPO();                                         
					userPO.setName(resultSet.getString("USERNAME"));
                                        userPO.setCountry(resultSet.getString("COUNTRY"));
                                        userPO.setUserId(resultSet.getString("USERID"));
                                        
                                       	return userPO;
				                                    }
			                                               };
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId",userId);                
                return jdbcTemplate.queryForObject(SQL_SEARCH_USER,stdRowMapper,map);
                
	                                                                  } 
                  
 
 @Override
 public void updateUser(UserPO userPO){   
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId",userPO.getUserId());
                map.put("userName",userPO.getName());
                map.put("country",userPO.getCountry());
                jdbcTemplate.update(SQL_UPDATE_USER,map);
	                               } 
 
 @Override
 public void deleteUser(String userId){   
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId",userId);                
                jdbcTemplate.update(SQL_DELETE_USER,map);
	                               } 
 @Override
 public void insertUser(UserPO userPO){   
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId",userPO.getUserId());
                map.put("userName",userPO.getName());
                map.put("country",userPO.getCountry());
                jdbcTemplate.update(SQL_INSERT_USER,map);
	                               } 
 
                  }