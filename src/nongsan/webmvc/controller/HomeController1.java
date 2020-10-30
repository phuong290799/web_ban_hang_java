package nongsan.webmvc.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nongsan.webmvc.model.Boardnew;
import nongsan.webmvc.model.Product;
import nongsan.webmvc.service.BoardnewService;
import nongsan.webmvc.service.ProductService;
import nongsan.webmvc.service.impl.BoardnewServicesImpl;
import nongsan.webmvc.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class HomeController1
 */
@WebServlet("/HomeController1")
public class HomeController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();
	BoardnewService boardnewService = new BoardnewServicesImpl();
	DecimalFormat df = new DecimalFormat("#.000");   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Boardnew> boardnewList = boardnewService.getAll();
		request.setAttribute("boardnewlist", boardnewList);
		// Product Rau củ quả
		List<Product> product_raucu= productService.getProductById(1);
		request.setAttribute("product_raucu", product_raucu);	
		
		// Product hạt
		List<Product> product_hat= productService.getProductById(2);
		request.setAttribute("product_hat", product_hat);	
		
		// Product trái cây
		List<Product> product_traicay= productService.getProductById(3);
		request.setAttribute("product_traicay", product_traicay);	
		
		// Product mật ong
		List<Product> product_matong= productService.getProductById(4);
		request.setAttribute("product_matong", product_matong);	
		
		// Product mới
		List<Product> product_new= productService.getProductById(5);
		request.setAttribute("product_new", product_new);	
				
		// Product bán chạy
		List<Product> product_banchay= productService.getProductById(6);
		request.setAttribute("product_banchay", product_banchay);	
		
		List<Product> productList = productService.getAll();
		request.setAttribute("productlist", productList);	
		//Giá giảm
		List<Product> productsList1 = new ArrayList<Product>();
		for(Product product: productList)
		{
			Product product1 = productService.get(Integer.parseInt(product.getId()));
			product1.setPrice(String.valueOf(df.format(Double.parseDouble(product.getPrice()) * (1 - (Double.parseDouble(product.getDiscount())/100)))));
			productsList1.add(product1);
			
		}

		request.setAttribute("productlist1", productsList1);
		
		// Product giảm giá
		List<Product> product_sale= productService.getProductById(7);
		request.setAttribute("product_sale", product_sale);	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
