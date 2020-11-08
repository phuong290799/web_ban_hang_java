package nongsan.webmvc.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import nongsan.webmvc.service.BoardnewService;
import nongsan.webmvc.service.impl.BoardnewServicesImpl;

/**
 * Servlet implementation class BoardnewDeleteController1
 */
@WebServlet("/BoardnewDeleteController1")
public class BoardnewDeleteController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardnewService boardnewService = new BoardnewServicesImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardnewDeleteController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Lay cac tham so
		String id = request.getParameter("id");
		
//		Delete & getList
		boardnewService.delete(Integer.parseInt(id));
		
		
//		setAttribute va do ra view
		request.setAttribute("boardnewlist", boardnewService.getAll());	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-new.jsp"); 
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
