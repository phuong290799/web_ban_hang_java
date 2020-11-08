package nongsan.webmvc.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nongsan.webmvc.model.Product;
import nongsan.webmvc.service.ProductService;
import nongsan.webmvc.service.ReviewService;
import nongsan.webmvc.service.impl.ProductServiceImpl;
import nongsan.webmvc.service.impl.ReviewServicesImpl;

/**
 * Servlet implementation class ReviewDeleteController1
 */
@WebServlet("/ReviewDeleteController1")
public class ReviewDeleteController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReviewService reviewService =  new ReviewServicesImpl();
	ProductService productService = new ProductServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDeleteController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		reviewService.delete(Integer.parseInt(id));
		List<Product> productList = productService.getAll();
		request.setAttribute("productlist", productList);
		
		
		request.setAttribute("reviewlist", reviewService.getAll());	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-review.jsp"); 
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
