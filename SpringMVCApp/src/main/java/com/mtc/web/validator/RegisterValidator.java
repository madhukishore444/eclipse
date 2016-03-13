package com.mtc.web.validator;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.InitBinder;

import com.mtc.web.vo.Register;

@Component("registerValidator")
public class RegisterValidator implements Validator {

	
private List<String> usernamelist=new ArrayList<String>();

@PostConstruct
public void initRegisterValidator(){
	usernamelist.add("madhu");
	usernamelist.add("kishore");
	usernamelist.add("reddy");
}
	@Override
	public void validate(Object commnd, Errors errors) {

		Register register=(Register) commnd;
		if(usernamelist.contains(register.getUsername())){
		errors.rejectValue("username", "uname.error.exists","already exists");	
			
		}
	}
	@Override
	public boolean supports(Class<?> class1) {
		// TODO Auto-generated method stub
		if(class1.equals(Register.class)){
			return true;
		}
		return false;
	}
	@PreDestroy
	public void destrouRegisterValidatior(){
		
	}
}
