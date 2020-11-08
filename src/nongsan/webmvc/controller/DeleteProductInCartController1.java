package nongsan.webmvc.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nongsan.webmvc.model.Item;
import nongsan.webmvc.model.Order;
import nongsan.webmvc.model.Product;
import nongsan.webmvc.service.ProductService;
import nongsan.webmvc.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class DeleteProductInCartController1
 */
@WebServlet("/DeleteProductInCartController1")
public class DeleteProductInCartController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productservice = new ProductServiceImpl();
	DecimalFormat df = new DecimalFormat("#.000");
	DecimalFormat df1 = new DecimalFormat("#.0");   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductInCartController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		HttpSession session = request.getSession(true);
		Product product = productservice.get(Integer.parseInt(id));
		Order order = (Order) session.getAttribute("order");
		List<Item> listItems = order.getItems();
		for(Item item: listItems)
		{
			if(Integer.parseInt(item.getProduct().getId()) == Integer.parseInt(product.getId()))
			{
				order.setSumPrice(order.getSumPrice() - item.getPrice());
				listItems.remove(item);
				break;
			}
		}
		order.setItems(listItems);
		session.setAttribute("order", order);
		
		if(order.getSumPrice() == 0)
		{
			session.setAttribute("sumprice", "0");
		} else {
			session.setAttribute("sumprice", df.format(order.getSumPrice()));
		}
		response.sendRedirect(request.getContextPath() + "/view/client/cart.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
