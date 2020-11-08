<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="nongsan.webmvc.model.Review"%>
<%@page import="nongsan.webmvc.model.Product"%>
<%@page import="java.util.List"%>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">
        <!--End Row-->
          <div class="col-lg-12"> 
            <div class="card">	
              <div class="card-body">
                <h5 class="card-title">Danh sách Review</h5>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Email</th>
                        <th scope="col">Sản Phẩm</th>
                        <th scope="col">Nội dung</th>
                        <th scope="col">Ngày đánh giá</th>
                        <th scope="col">Hành động</th>
                      </tr>
                    </thead>
                    <tbody>
                    <%
					          List<Review> arrreview= (List<Review>) request.getAttribute("reviewlist");
                    			List<Product> arrpro= (List<Product>) request.getAttribute("productlist");
					          for(int i=0; i<arrreview.size(); i++)
					          {
						          int id=Integer.parseInt(arrreview.get(i).getProduct_id());
				
				          %>
                 
                      <tr>
                        <td scope="row"><%=i+1 %></td>
                        <td><%=arrreview.get(i).getName() %></td>
                        <td><%=arrreview.get(i).getEmail() %></td>
                        <%
                       		
                        	for(int j=0; j<arrpro.size(); j++)
				          	{
                        		int id1=Integer.parseInt(arrpro.get(j).getId());
                        		if(id==id1){
                        %>
                        <td><%=arrpro.get(j).getName() %></td>
                        <%}}%>
                        
                        <td><%=arrreview.get(i).getContent() %></td>
                        <td><%=arrreview.get(i).getCreated() %></td>           
        				 <td>
                       	<a href="${pageContext.request.contextPath}/ReviewDeleteController1?id=<%=arrreview.get(i).getId() %>">Xóa</a>
                        </td>
                     </tr>
                    <% } %>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
 
    <jsp:include page = "./footer/footer.jsp" flush = "true" />