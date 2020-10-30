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


import nongsan.webmvc.model.Boardnew;
import nongsan.webmvc.service.BoardnewService;
import nongsan.webmvc.service.impl.BoardnewServicesImpl;

/**
 * Servlet implementation class BoardnewEditController1
 */
@WebServlet("/BoardnewEditController1")
public class BoardnewEditController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardnewService boardnewService = new BoardnewServicesImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardnewEditController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Boardnew boardnew=null;
		boardnew = boardnewService.get(Integer.parseInt(id));
		request.setAttribute("boardnewlist", boardnew);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/editboardnew.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		Boardnew boardnew = new Boardnew();
		boardnew.setId(request.getParameter("new-id"));
		boardnew.setTitle(request.getParameter("new-title"));
		boardnew.setContent(request.getParameter("new-content"));
		boardnew.setImage_link(request.getParameter("new-image_link"));
		boardnew.setAuthor(request.getParameter("new-author"));
		boardnew.setCreated(request.getParameter("new-created"));
		
		List<Boardnew> boardList = null;
		boardnewService.edit(boardnew);
		boardList = boardnewService.getAll();
		
		
		request.setAttribute("boardnewlist", boardList); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/show-new.jsp"); 
		dispatcher.forward(request, response); 
	}

}
