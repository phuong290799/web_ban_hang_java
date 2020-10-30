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
import nongsan.webmvc.service.CategoryService;
import nongsan.webmvc.service.impl.CategoryServicesImpl;

/**
 * Servlet implementation class CategoryEditController1
 */
@WebServlet("/CategoryEditController1")
public class CategoryEditController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServicesImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryEditController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int admin_id= Integer.parseInt(request.getParameter("id"));
		Catalog catelist = null;
		catelist = cateService.get(admin_id);
		request.setAttribute("catelist", catelist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/editcate.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		String parentid = request.getParameter("parent-id");
		String id = request.getParameter("id");	
		
		Catalog category = new Catalog();
		category.setName(name);
		category.setParent_id(parentid);
		category.setId(id);
		
		
		List<Catalog> catagoryList = null;
		cateService.edit(category);
		catagoryList = cateService.getAll();
		request.setAttribute("catelist", catagoryList); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-cate.jsp"); 
		dispatcher.forward(request, response); 
		
		
		
		
	}

}
