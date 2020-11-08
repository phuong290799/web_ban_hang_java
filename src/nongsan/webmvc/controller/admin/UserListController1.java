package nongsan.webmvc.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.List;
import nongsan.webmvc.model.Admin;
import nongsan.webmvc.model.User;
import nongsan.webmvc.service.AdminService;
import nongsan.webmvc.service.UserService;
import nongsan.webmvc.service.impl.AdminServicesImpl;
import nongsan.webmvc.service.impl.UserServicesImpl;

/**
 * Servlet implementation class UserListController1
 */
@WebServlet("/UserListController1")
public class UserListController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServicesImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 
		List<User> userList = null;
		userList = userService.getAll(); 
		request.setAttribute("userlist", userList); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/user.jsp"); 
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
