package nongsan.webmvc.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
 * Servlet implementation class AddtoCartController1
 */
@WebServlet("/AddtoCartController1")
public class AddtoCartController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();
	DecimalFormat df = new DecimalFormat("#.000");   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddtoCartController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		initial
		int n= 0;
		int qty = 1;
		String id;
		
		
		if(request.getParameter("product-id")!=null) {
//			Lay product theo ID
			id = request.getParameter("product-id");
			Product product = productService.get(Integer.parseInt(id));;
			if(product != null) {
//				neu co so luong thi xet
				if(request.getParameter("qty")!=null) {
					qty = Integer.parseInt(request.getParameter("qty"));
				}
				
				HttpSession session = request.getSession();
				
//				neu chua order truoc 
				if(session.getAttribute("order") == null) {
					
					List<Item> listItems = new ArrayList<Item>();
					
//					Set item da order
					Item item = new Item();
					item.setQty(qty);
					item.setProduct(product);
					item.setPrice(Double.parseDouble(product.getPrice()) - Double.parseDouble(product.getPrice())*(Double.parseDouble(product.getDiscount())/100));
					
//					xet tong order
					Order order = new Order();
					order.setSumPrice(0);
					order.setSumPrice(order.getSumPrice() + item.getPrice());
					
					
//					add vao list_item
					listItems.add(item);
//					set order có list_item
					order.setItems(listItems);
					n = listItems.size();
					
//					set session
					session.setAttribute("length_order",n);
					session.setAttribute("order", order);
					session.setAttribute("sumprice", df.format(order.getSumPrice()));
				} else {
//					Lay ra order da order truoc do
					Order order = (Order) session.getAttribute("order");
					
					
					List<Item> listItems = order.getItems();
					boolean check = false;
					
//					duyet cac item xem item moi order co trung ko
					for(Item item : listItems) {
//						neu trung thi cap nhat lai so luong va gia và tong gia cua order
						if(Integer.parseInt(item.getProduct().getId()) == Integer.parseInt(product.getId())) {
							item.setQty(item.getQty() + qty);
							order.setSumPrice(order.getSumPrice() + Double.parseDouble(item.getProduct().getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(Double.parseDouble(item.getProduct().getDiscount())/100));
							item.setPrice(item.getPrice() + (Double.parseDouble(item.getProduct().getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(Double.parseDouble(item.getProduct().getDiscount())/100)));
							check = true;
						}
					}
//					neu ko thi Set new item da order
					if(check == false) {
						Item item = new Item();
						item.setQty(qty);
						item.setProduct(product);
						item.setPrice(Double.parseDouble(product.getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(Double.parseDouble(item.getProduct().getDiscount())/100));
						order.setSumPrice(order.getSumPrice() + Double.parseDouble(item.getProduct().getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(Double.parseDouble(item.getProduct().getDiscount())/100));
						listItems.add(item);
					}
					
					
					n = listItems.size();
					
//					set session
					session.setAttribute("length_order",n);
					session.setAttribute("order", order);
					session.setAttribute("sumprice", df.format(order.getSumPrice()));
				}
			}
			response.sendRedirect(request.getContextPath() + "/view/client/cart.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
