<%@page import="java.sql.ResultSet"%>
<%@page import="nongsan.webmvc.jdbc.connectDB"%>
<%@page import="nongsan.webmvc.model.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
            <a href="${pageContext.request.contextPath}/view/admin/addadmin.jsp">Thêm Admin</a>
          </div> 
          <div class="col-lg-12"> 
            <div class="card"> 
              <div class="card-body"> 
                <h5 class="card-title">Danh sách Admin</h5> 
                <div class="table-responsive">              
                  <table class="table table-striped"> 
                    <thead> 
                      <tr> 
                        <th scope="col">#</th> 
                        <th scope="col">Tên đăng nhập</th> 
                        <th scope="col">Tên Admin</th>
                        <th scope="col">Hành động</th>                        
                     </tr> 
                    </thead> 
                    <tbody> 
                 
                  		<%
					          ArrayList<Admin> arradmin= (ArrayList<Admin>) request.getAttribute("adminlist");
					          for(int i=0; i<arradmin.size(); i++)
					          {
						          int id=arradmin.get(i).getId();
				
				          %>
                      <tr> 
                        <td scope="row"><%=i+1 %></td> 
                        <td><%=arradmin.get(i).getUsername() %></td> 
        				<td><%=arradmin.get(i).getName() %></td> 
        				 <td> 
                           <a href="${pageContext.request.contextPath}/AdminDeleteController1?admin-id=<%=arradmin.get(i).getId()%>">Xóa</a>
              
                          <a href="${pageContext.request.contextPath}/AdminEditController1?admin-id=<%=arradmin.get(i).getId()%>">Sửa</a>
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