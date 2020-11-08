package nongsan.webmvc.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nongsan.webmvc.model.Catalog;
import nongsan.webmvc.model.Product;
import nongsan.webmvc.model.Review;
import nongsan.webmvc.service.CategoryService;
import nongsan.webmvc.service.ProductService;
import nongsan.webmvc.service.ReviewService;
import nongsan.webmvc.service.impl.CategoryServicesImpl;
import nongsan.webmvc.service.impl.ProductServiceImpl;
import nongsan.webmvc.service.impl.ReviewServicesImpl;

/**
 * Servlet implementation class ProductDetailController1
 */
@WebServlet("/ProductDetailController1")
public class ProductDetailController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServicesImpl();
	ProductService productService = new ProductServiceImpl();
	ReviewService reviewService = new ReviewServicesImpl();
	DecimalFormat df = new DecimalFormat("#.000");   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Product detail_product = productService.get(Integer.parseInt(id));
		request.setAttribute("detail_product", detail_product);
		
		List<Catalog> name_cate_of_product = cateService.getCateByProduct(Integer.parseInt(id));
		request.setAttribute("name_cate_of_product", name_cate_of_product);
		
		String idCate = detail_product.getCatalog_id();
		
		List<Product> productListCate = productService.getProductById(Integer.parseInt(idCate));
		
		request.setAttribute("productById", productListCate);
		
		List<Review> reviewById = reviewService.getReviewById(Integer.parseInt(id));
		request.setAttribute("reviewbyid", reviewById);
		
		List<Product> productList = productService.getAll();
		request.setAttribute("productlist", productList);	
		//Giá giảm
		List<Product> productsList1 = new ArrayList<Product>();
		for(Product product: productList)
		{
			Product product1 = productService.get(Integer.parseInt(product.getId()));
			product1.setPrice(String.valueOf(df.format(Double.parseDouble(product.getPrice()) * (1 - (Double.parseDouble(product.getDiscount())/100)))));
			productsList1.add(product1);
			
		}

		request.setAttribute("productlist1", productsList1);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/product-detail.jsp");
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
