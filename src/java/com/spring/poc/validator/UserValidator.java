package com.spring.poc.validator;

import com.spring.poc.bo.UserBO;
import com.spring.poc.validator.utils.ValidatorUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class UserValidator implements Validator {
    
      
       
       private String actionType ;

        public String getActionType() {
        return actionType;
                                        }

        public void setActionType(String actionType) {
        this.actionType = actionType;
                                                      }
       
       

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
                boolean isError=false ;
                UserBO userBO = (UserBO) target;                
		ValidatorUtils.rejectIfEmptyOrWhitespace(errors,"userId","userId.required");
                isError=!(errors.hasErrors());
                if(isError)
                isError=ValidatorUtils.checkNumeric(userBO.getUserId(), errors,"userId" ,"userId.nonNumeric");
                if(isError)
                isError=ValidatorUtils.checkAccurateLength(userBO.getUserId(),6,errors, "userId","userId.invalidLength");
                
                if(actionType.equals(ValidatorUtils.INSERT)||actionType.equals(ValidatorUtils.UPDATE)){
                ValidatorUtils.rejectIfEmptyOrWhitespace(errors,"name","username.required");    
		ValidatorUtils.rejectIfEmpty(errors,"country","country.required");
                                                                        }
		
		
		
	}

        
}
