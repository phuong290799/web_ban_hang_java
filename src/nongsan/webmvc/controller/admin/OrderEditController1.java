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


import nongsan.webmvc.model.Transactions;
import nongsan.webmvc.service.TransactionService;
import nongsan.webmvc.service.impl.TransactionServicesImpl;

/**
 * Servlet implementation class OrderEditController1
 */
@WebServlet("/OrderEditController1")
public class OrderEditController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TransactionService transactionService = new TransactionServicesImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderEditController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		Transactions transaction= null;
		transaction = transactionService.get(id);
		request.setAttribute("order", transaction);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/editorder.jsp");
		dispatcher.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Transactions transactions = new Transactions();
		transactions.setId(Integer.parseInt(request.getParameter("order-id")));
		transactions.setUser_name(request.getParameter("order-name"));
		transactions.setUser_mail(request.getParameter("order-mail"));
		transactions.setUser_phone(request.getParameter("order-phone"));
		transactions.setAddress(request.getParameter("order-address"));
		transactions.setMessage(request.getParameter("order-mess"));
		transactions.setAmount(request.getParameter("order-amount"));
		transactions.setPayment(request.getParameter("order-payment"));
		transactions.setStatus(request.getParameter("order-status"));
		
		
		List<Transactions> transactionsList = null;
		transactionService.edit(transactions);
		transactionsList = transactionService.getAll();
		
		
		request.setAttribute("order", transactionsList); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-order.jsp"); 
		dispatcher.forward(request, response); 
	}

}
