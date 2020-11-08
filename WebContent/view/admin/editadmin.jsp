<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="nongsan.webmvc.model.Admin"%>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Chuyên mục: Sửa</div>
                <hr>
          	<%
				Admin admin= (Admin)request.getAttribute("admin");

			%>
	         <form action="${pageContext.request.contextPath}/AdminEditController1" method="post"> 
	         		<input type="hidden" class="form-control" readonly id="input-1" placeholder="Admin ID" name="id" value="<%=admin.getId()%>">
	         		  <div class="form-group">
	                    <label for="input-1">ID</label>
	                    <input disabled type="text" class="form-control" readonly id="input-1" placeholder="Admin ID" name="id1" value="<%=admin.getId()%>">
	                  </div>
	                  <div class="form-group">
	                    <label for="input-1">Username</label>
	                    <input required type="text" class="form-control" id="input-1" placeholder="Username" name="username" value="<%=admin.getUsername()%>">
	                  </div>
	                  <div class="form-group">
	                    <label for="input-1">Password</label>
	                    <input disabled required type="password" class="form-control" id="myinput" placeholder="Mật khẩu" name="password1" value="<%=admin.getPassword()%>">
       					<input type="checkbox" onclick="myFunction1()">Hiển thị mật khẩu
					<script>function myFunction1() {
                    	  var x = document.getElementById("myinput");
                    	  if (x.type === "password") {
                    	    x.type = "text";
                    	  } else {
                    	    x.type = "password";
                    	  }
                    	}
					</script> 
                     <input required type="hidden" class="form-control" id="myinput" placeholder="Mật khẩu" name="password" value="<%=admin.getPassword()%>">
       
	                  </div>
	                  <div class="form-group">
	                    <label for="input-1">Tên Admin</label>
	                    <input required type="text" class="form-control" id="input-1" placeholder="Tên Admin" name="name" value="<%=admin.getName()%>">
	                  </div>	                  		              
	                 <div class="form-footer">
	                 <a href="${pageContext.request.contextPath}/AdminListController1">Hủy</a>
	                    <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Sửa </button>
	                </div> 
	               
	                </form>
	                 
              </div>
            </div>
          </div>
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>
  
    <jsp:include page = "./footer/footer.jsp" flush = "true" />