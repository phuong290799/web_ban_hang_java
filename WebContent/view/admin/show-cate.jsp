<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="nongsan.webmvc.model.Catalog"%>
<%@page import="java.util.List"%>
<%
  response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
  response.setHeader("Pragma" , "no-cache");
  response.setHeader("Expires" , "0");
  
  
  if (session.getAttribute("admin-username") == null){
	  response.sendRedirect(request.getContextPath() +  "/view/admin/login.jsp");
  }
  %>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">
        <!--End Row-->


        <div class="row">
          <div class="col-lg-12">
            <a href="${pageContext.request.contextPath}/view/admin/addcate.jsp">Thêm chuyên mục</a>
          </div>
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Danh sách chuyên mục</h5>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Tên chuyên mục</th>
                        <th scope="col">Chuyên mục cha</th>
                        <th scope="col">Hành động</th>
                        
                      </tr>
                    </thead>
                    <tbody>
                  <%
					          List<Catalog> arrcate= (List<Catalog>) request.getAttribute("catelist");
					          for(int i=0; i<arrcate.size(); i++)
					          {
						          int id=Integer.parseInt(arrcate.get(i).getId());
						          
				
				          %>
                      <tr>
                        <td scope="row"><%=i+1 %></td>
                        <td><%=arrcate.get(i).getName() %></td>
        				<td>
        					<%if(Integer.parseInt(arrcate.get(i).getParent_id())==0){ %>
	                        	san pham cu
	                        <%}else{ %>
	                       		san pham moi
							<%} %>
                       	
        				</td>
        				 <td>
                         <a href="${pageContext.request.contextPath}/CategoryDeleteController1?id=<%=Integer.parseInt(arrcate.get(i).getId()) %>">Xóa</a>
                         
                          <a href="${pageContext.request.contextPath}/CategoryEditController1?id=<%=Integer.parseInt(arrcate.get(i).getId()) %>">Sửa</a>
                        </td>
                     </tr>
                    <% }%>
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