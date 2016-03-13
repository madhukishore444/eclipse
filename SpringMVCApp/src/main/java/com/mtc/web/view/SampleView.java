package com.mtc.web.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import com.mtc.web.entity.Product;

@Component("sampleview")
public class SampleView implements View{

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return "text/html";
	}
	
	@Override
	public void render(Map<String, ?> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Product product= (Product) map.get("product");
		PrintWriter out=response.getWriter();
		out.println("product details:");
		out.print("<br>");
		out.print("id::"+product.getId());
		out.print("<br>");
		out.print("name::"+product.getName());
		out.print("<br>");
		out.print("price::"+product.getPrice());
		out.print("<br>");
		out.print("desc::"+product.getDesc());
	}
}
