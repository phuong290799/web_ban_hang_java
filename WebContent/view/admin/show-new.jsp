<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
  response.setHeader("Pragma" , "no-cache");
  response.setHeader("Expires" , "0");
  
  
  if (session.getAttribute("admin-username") == null){
	  response.sendRedirect(request.getContextPath() + "/view/admin/login.jsp");
  }
  %>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">
        <!--End Row-->


        <div class="row">
          <div class="col-lg-12">
            <a href="${pageContext.request.contextPath}/view/admin/addboardnew.jsp">Thêm tin tức</a>
          </div>
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Danh sách tin tức</h5>
                <div class="table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Tiêu đề</th>
                        <th scope="col">Hình ảnh</th>
                        <th scope="col">Người đăng</th>
                        <th scope="col">Ngày đăng</th>
                         <th scope="col">Hành động</th>
                      </tr>
                    </thead>
                    <tbody>
                  <c:forEach items="${boardnewlist}" var="boardnew">
                      <tr>
                        <td scope="row">${boardnew.id}</td>
                        <td>${boardnew.title}</td>
        				<td><img style="width: 110px;height: 67px; object-fit: cover;border: 1px solid #fff;" src="${pageContext.request.contextPath}/view/client/assets/images/news/${boardnew.image_link}"></td>
        				<td>${boardnew.author}</td>
        				<td>${boardnew.created}</td>
        				 <td>
                         <a href="${pageContext.request.contextPath}/BoardnewDeleteController1?id=${boardnew.id}">Xóa</a>
                         
                          <a href="${pageContext.request.contextPath}/BoardnewEditController1?id=${boardnew.id}">Sửa</a>
                        </td>
                     </tr>
                    </c:forEach>
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