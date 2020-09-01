package com.spring.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.dao.EmptyResultDataAccessException ;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.servlet.ModelAndView;

import com.spring.poc.bo.UserBO;
import com.spring.poc.service.UserService;
import com.spring.poc.validator.UserValidator;
import com.spring.poc.validator.utils.ValidatorUtils;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.springframework.validation.BindingResult;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private Properties properties ;
    
    @Autowired
    private UserValidator userValidator;
    
        
        
	
	@ModelAttribute("COUNTRYLIST")
	public Set<Map.Entry<String,String>>  populateCountryList() {
		return userService.getAllCountries().entrySet();
	}
	
	
	
	@RequestMapping(value="/userRegistration.do",method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		UserBO userBO = new UserBO();
		model.addAttribute("user", userBO);           
		return "userForm";
	}

	
        @RequestMapping(value="/userInsertion.do",method = RequestMethod.POST)
	public ModelAndView onInsert(@ModelAttribute("user") UserBO userBO,BindingResult result) {
            try{
                userValidator.setActionType(ValidatorUtils.INSERT);
                userValidator.validate(userBO, result);
		if (result.hasErrors()) {                   
	        return new ModelAndView("userForm");
		                        }
                else{
		userService.insertUser(userBO); 
                userBO.clear();
                return new ModelAndView("userForm","MESSAGE",properties.getProperty("insertion.success"));
                }
            }
            catch (DuplicateKeyException e) {
             return new ModelAndView("userForm","MESSAGE",properties.getProperty("records.duplicate")); 
                                            }
            catch(Exception e){
               return new ModelAndView("error","ERROR",e);  
            }
		//return "redirect:userRegistration.do";
                
	}
	@RequestMapping(value="/userUpdation.do",method = RequestMethod.POST)
	public ModelAndView onUpdate(@ModelAttribute("user") UserBO userBO,BindingResult result) {
            try{
                userValidator.setActionType(ValidatorUtils.UPDATE);
                userValidator.validate(userBO, result);
		if (result.hasErrors()) {                   
	        return new ModelAndView("userForm");
		                        }
                else{
		userService.updateUser(userBO);
                userBO.clear();
                return new ModelAndView("userForm","MESSAGE",properties.getProperty("updation.success"));
                }
            }
            catch(Exception e){
               return new ModelAndView("error","ERROR",e);  
            }
                
	}
        
         @RequestMapping(value="/userSearch.do",method = RequestMethod.POST)
	public ModelAndView onSearch(@ModelAttribute("user") UserBO userBO,BindingResult result) {
             try{
                 
                userValidator.setActionType(ValidatorUtils.SEARCH);
                userValidator.validate(userBO, result);
		if (result.hasErrors()) {                   
	        return new ModelAndView("userForm");
		                        }
                else{
		userService.searchUser(userBO);
		return new ModelAndView("userForm");
                }
             }
             catch(EmptyResultDataAccessException e){
                 System.out.println("Empty Resultset" );
                 System.out.println(properties.getProperty("records.empty"));
             return new ModelAndView("userForm","MESSAGE",properties.getProperty("records.empty")); 
             }
             catch(Exception e){
               return new ModelAndView("error","ERROR",e);  
            }
                
	}
         
	@RequestMapping(value="/userDeletion.do",method = RequestMethod.POST)
	public ModelAndView onDelete(@ModelAttribute("user") UserBO userBO,BindingResult result) {
		try{
                userValidator.setActionType(ValidatorUtils.DELETE);
                userValidator.validate(userBO, result);
		if (result.hasErrors()) {                   
	        return new ModelAndView("userForm");
		                        }
                else{
                userService.updateUser(userBO);                
                userBO.clear();
		return new ModelAndView("userForm","MESSAGE",properties.getProperty("deletion.success"));
                    }
                }
             catch(Exception e){
               return new ModelAndView("error","ERROR",e);  
            }   
	}
}
