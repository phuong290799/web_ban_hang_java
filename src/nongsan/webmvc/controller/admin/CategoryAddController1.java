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
 * Servlet implementation class CategoryAddController1
 */
@WebServlet("/CategoryAddController1")
public class CategoryAddController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServicesImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryAddController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String cate_name = request.getParameter("cate-name");
		String cate_parent_id = request.getParameter("parent-id");
		Catalog category = new Catalog();
		category.setName(cate_name);
		category.setParent_id(cate_parent_id);
		
		List<Catalog> categorylist = null;
		cateService.insert(category);
		categorylist = cateService.getAll(); 
		
		
		request.setAttribute("catelist", categorylist); 
//		response.sendRedirect(request.getContextPath() + "/list_nv.jsp"); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-cate.jsp"); 
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
