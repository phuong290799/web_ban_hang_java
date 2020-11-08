package nongsan.webmvc.controller.admin;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nongsan.webmvc.model.Admin;
import nongsan.webmvc.service.AdminService;
import nongsan.webmvc.service.impl.AdminServicesImpl;



/**
 * Servlet implementation class AdminEditController1
 */
@WebServlet("/AdminEditController1")
public class AdminEditController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService adminService = new AdminServicesImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int admin_id= Integer.parseInt(request.getParameter("admin-id"));
		Admin admin = null;
		admin = adminService.get(admin_id);
		request.setAttribute("admin", admin);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/editadmin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		int admin_id = Integer.parseInt(request.getParameter("id"));
		String admin_username = request.getParameter("username");
		String admin_password = (request.getParameter("password"));
		String admin_name = request.getParameter("name");	
		
		System.out.println(admin_username);
		System.out.println(admin_password);
		System.out.println(admin_name);
		
		Admin admin = new Admin();
		admin.setId(admin_id);
		admin.setUsername(admin_username);
		admin.setPassword(admin_password);
		admin.setName(admin_name);
		
		
		List<Admin> adminList = null;
		adminService.edit(admin);
		adminList = adminService.getAll();
		request.setAttribute("adminlist", adminList); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/admin.jsp"); 
		dispatcher.forward(request, response); 
	}
	
	public static String md5(String str){
		String result = "";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			BigInteger bigInteger = new BigInteger(1,digest.digest());
			result = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

}
