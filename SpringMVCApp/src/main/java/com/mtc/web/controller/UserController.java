package com.mtc.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mtc.web.entity.Userlogin;

@Controller
public class UserController {

	@Autowired
	private SessionFactory sessionFactory;
	
	@RequestMapping(value="searchuser")
	public ModelAndView searchuser(HttpServletRequest request){
		//Userlogin userlogin=new Userlogin();
		System.out.println("*****in search user modeland view*****");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Session session =sessionFactory.openSession();
		Userlogin userlogin=(Userlogin) session.get(Userlogin.class, id);
												//view name
		ModelAndView modelAndView=new ModelAndView("searchoutput");
		modelAndView.addObject("userlogin",userlogin);
		return modelAndView;
	}
	
	@RequestMapping(value="allusers")
	public ModelAndView allusers(HttpServletRequest request){
		Session session= sessionFactory.openSession();
		Query q=session.createQuery("from Userlogin");
		List<Userlogin> userlogins=q.list();
		ModelAndView modelAndView=new ModelAndView("searchoutput");
		modelAndView.addObject("userlogins",userlogins);
		return modelAndView;
	}
}
