package com.mtc.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mtc.web.entity.Product;

@Controller
public class ProductSearchController {

	@Autowired
	private SessionFactory sessionFactory;
	//to fetch all products
	
	@RequestMapping(value="/addproduct",method=RequestMethod.GET)
	public String productview(ModelMap modelMap){
		Product product=new Product();
		System.out.println(product.getId()+product.getName());
		modelMap.addAttribute("product",product);
		return "addproduct";
		
	}
	
	//@Transactional
	@RequestMapping(value="/addproduct")
	public ModelAndView procesAddProduct(Product product){
		System.out.println(product.getId()+product.getName());

		Session session=sessionFactory.openSession();
		//Session session=sessionFactory.getCurrentSession();

		Transaction transaction=session.getTransaction();
		transaction.begin();

		session.save(product);
		
		transaction.commit();
		return new ModelAndView("sucess");
		
		
		
	}
	
	@RequestMapping(value="getProduct")
	public ModelAndView getProducts(){
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> products=query.list();
		ModelAndView modelAndView=new ModelAndView("productPdfView");
		modelAndView.addObject("products",products);
		return modelAndView;
		
	}
	
	@RequestMapping(value="productSearch")
	public ModelAndView productSearchRequest(HttpServletRequest request){
		int id= Integer.parseInt( request.getParameter("product_Id"));
		//System.out.println(id);
		Session session= sessionFactory.openSession();
		
		Product product=(Product) session.get(Product.class, id);
												//viewname
		//ModelAndView modelAndView=new ModelAndView("productview");
		ModelAndView modelAndView=new ModelAndView("sampleview");

		modelAndView.addObject("product",product);
		return modelAndView;
	}
}
