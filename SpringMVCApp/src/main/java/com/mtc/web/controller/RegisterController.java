package com.mtc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mtc.web.validator.RegisterValidator;
import com.mtc.web.vo.Register;

@Controller
public class RegisterController {

	private Logger logger=Logger.getLogger(RegisterController.class);
/*	@Autowired
	private RegisterValidator registerValidator;
	
	@InitBinder
	public void registerInitBinder(WebDataBinder webDataBinder){
		webDataBinder.setValidator(registerValidator);
	}
*/
	@ModelAttribute("cities")
	public List<String> getCities(){
	//	logger.info("**in cities method***");
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("select");
		arrayList.add("hyd");
		arrayList.add("ban");
		arrayList.add("mum");
		arrayList.add("chn");
	
		return arrayList;
	}
	@ModelAttribute("states")
	public List<String> getStates(){
		//logger.info("**in states method***");
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("select");
		arrayList.add("tg");
		arrayList.add("kar");
		arrayList.add("bom");
		arrayList.add("tn");
	
		return arrayList;
	}
	@RequestMapping(value="/registerprocess",method=RequestMethod.GET)
	public String showView(ModelMap modelMap){
	
		logger.info("****in showview***");
		//command object
		Register register=new Register();
		//registering the command object
		modelMap.addAttribute("register",register);
		System.out.println(register.getCity());
		// input jsp name
		return "register";
	}
	
	@RequestMapping(value="/registerprocess",method=RequestMethod.POST)
	public /*ModelAndView*/ String processRequest(@Validated Register register,BindingResult bindingResult,Model model){
		logger.info("****in processrequest***");
		
	/*	Register register=new Register();
		register.setUsername(request.getParameter("username"));
		register.setLastName(request.getParameter("firstName"));
		register.setLastName(request.getParameter("lastName"));
		register.setEmail(request.getParameter("email"));
		register.setCity(request.getParameter("city"));
		register.setState(request.getParameter("state"));
	*/	
											//view name
		/*ModelAndView modelAndView=new ModelAndView("welcome");
		modelAndView.addObject("register", register);
		*/
		if(bindingResult.hasErrors()){
		return "register";
		
		}
		model.addAttribute("register",register);
		return "welcome";
		
		
	}
}
