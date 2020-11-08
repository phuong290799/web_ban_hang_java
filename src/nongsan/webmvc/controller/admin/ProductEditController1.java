package nongsan.webmvc.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import nongsan.webmvc.model.Catalog;
import nongsan.webmvc.model.Product;
import nongsan.webmvc.service.CategoryService;
import nongsan.webmvc.service.ProductService;
import nongsan.webmvc.service.impl.CategoryServicesImpl;
import nongsan.webmvc.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ProductEditController1
 */
@WebServlet("/ProductEditController1")
public class ProductEditController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();  
	CategoryService cateService = new CategoryServicesImpl();
    public ProductEditController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		Product product=null;
		
		
		product = productService.get(id);
		request.setAttribute("product", product);
		
		List<Catalog> cateList = cateService.getAll();
		request.setAttribute("catelist", cateList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/editproduct.jsp");
		dispatcher.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Product product = new Product();
		product.setId(request.getParameter("product-sku"));
		product.setCatalog_id(request.getParameter("product-cate"));
		product.setName(request.getParameter("product-name"));
		product.setPrice(request.getParameter("product-price"));
		product.setStatus(request.getParameter("product-status"));
		product.setDescription(request.getParameter("product-desc"));
		product.setContent(request.getParameter("product-content"));
		product.setDiscount(request.getParameter("product-discount"));
		product.setImage_link(request.getParameter("product-image"));
		product.setCreated(request.getParameter("product-day"));
		
		
		List<Product> productList = null;
		productService.edit(product);
		productList = productService.getAll();
		
		
		
		request.setAttribute("productlist", productList); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-product.jsp"); 
		dispatcher.forward(request, response); 
	}

}
