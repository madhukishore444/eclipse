package com.mtc.web.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.mtc.web.entity.Product;

@Component("productPdfView")
public class ProductPDFView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Product> products=(List<Product>) map.get("products");
		
		Table table=new Table(4);
			
		table.addCell("productid");
		table.addCell("productname");
		table.addCell("productprice");
		table.addCell("productdesc");
		
		for (Product product : products) {
			table.addCell(product.getId()+"");
			table.addCell(product.getName());
			table.addCell(product.getPrice()+"");
			table.addCell(product.getDesc());
		}
		document.add(table);
		
	}
}
