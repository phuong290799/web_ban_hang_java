package nongsan.webmvc.controller.admin;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nongsan.webmvc.dao.AdminLoginDao;
import nongsan.webmvc.model.Admin;


@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public AdminLoginController() {
        super();    
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/admin/login.jsp");
    	dispatcher.forward(request, response);
    }
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   response.setContentType("text/html");   
		 
		String username = request.getParameter("admin-username");
		String password = md5((request.getParameter("admin-password")));
		System.out.println(username);
		System.out.println(password);
		Admin admin = new Admin();
		admin.setName(request.getParameter("name"));
		
		if(AdminLoginDao.checkAdminLogin(username,password)) {
			HttpSession session = request.getSession();
			session.setAttribute("admin-username", username);
			session.setAttribute("admin-password", password);
			response.sendRedirect(request.getContextPath() + "/view/admin/index.jsp"); 
		}
		else {
            request.setAttribute("errorMessage", "Tai khoan cua ban nhap sai !!!");
            RequestDispatcher rd = request.getRequestDispatcher("/view/admin/login.jsp");
            rd.forward(request, response);     
		}
		
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
