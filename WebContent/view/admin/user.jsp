<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="nongsan.webmvc.model.User"%>
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

        <div class="row mt-3">
          <div class="col-lg-12">
            <a href="${pageContext.request.contextPath}/view/admin/adduser.jsp">Thêm User</a>
          </div> 
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Danh sách User</h5>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">stt</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Email</th>
                        <th scope="col">Số điện thoại</th>
                        <th scope="col">Username</th>
                        <th scope="col">Ngày tạo</th>
                         <th scope="col">Hành động</th>
             
                      </tr>
                    </thead>
                    <tbody>
                  		<%
					          List<User> arradmin= (List<User>) request.getAttribute("userlist");
					          for(int i=0; i<arradmin.size(); i++)
					          {
						          int id=arradmin.get(i).getId();
				
				          %>
                      <tr>
                        <td scope="row"><%=i+1 %></td>
                        <td><%=arradmin.get(i).getName() %></td>
        				<td><%=arradmin.get(i).getEmail() %></td>
        				<td><%=arradmin.get(i).getPhone() %></td>
        				<td><%=arradmin.get(i).getUsername() %></td>
        				<td><%=arradmin.get(i).getCreated()%></td>
        				 <td>
                          <a href="${pageContext.request.contextPath}/UserDeleteController1?user-id=<%=arradmin.get(i).getId()%>">Xóa</a>
                         
                          <a href="${pageContext.request.contextPath}/UserEditController1?user-id=<%=arradmin.get(i).getId() %>">Sửa</a>
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
        <div class="overlay toggle-menu"></div>
      </div>
    </div>

  
    <jsp:include page = "./footer/footer.jsp" flush = "true" />