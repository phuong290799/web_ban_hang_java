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
 * Servlet implementation class BoardnewAddController1
 */
@WebServlet("/BoardnewAddController1")
public class BoardnewAddController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardnewService boardnewService = new BoardnewServicesImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardnewAddController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
//		Lay cac tham so
		String new_title = request.getParameter("new-title");
		String new_content = request.getParameter("new-content");
		String new_image_link = request.getParameter("new-image_link");
		String new_author = request.getParameter("new-author");
		String new_created = request.getParameter("new-created");
//		tao Object & set
		Boardnew boardnew = new Boardnew();
		boardnew.setTitle(new_title);
		boardnew.setContent(new_content);
		boardnew.setImage_link(new_image_link);
		boardnew.setAuthor(new_author);
		boardnew.setCreated(new_created);
		
//		Insert & getList
		List<Boardnew> boardList = null;
		boardnewService.insert(boardnew);
		boardList = boardnewService.getAll();
//		setAttribute va do ra view
		request.setAttribute("boardnewlist", boardList); 
		//response.sendRedirect(request.getContextPath() + "/view/admin/show-new.jsp");
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
