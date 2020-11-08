package nongsan.webmvc.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nongsan.webmvc.model.Review;
import nongsan.webmvc.service.ReviewService;
import nongsan.webmvc.service.impl.ReviewServicesImpl;

/**
 * Servlet implementation class ReviewClientController1
 */
@WebServlet("/ReviewClientController1")
public class ReviewClientController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReviewService reviewService = new ReviewServicesImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewClientController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		System.out.println("thang: " + id);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		
		
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today = df.format(date);
		
		
		
		Review review = new Review();
		review.setName(name);
		review.setEmail(email);
		review.setProduct_id(id);
		review.setContent(content);
		review.setCreated(today);
		System.out.println("tha­ tostring: " + review);
		
		
		
		reviewService.insert(review);
		response.sendRedirect(request.getContextPath() + "/HomeController1");
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() + "/ProductDetailController1?id=" +Integer.parseInt(request.getParameter("id")));
//		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
