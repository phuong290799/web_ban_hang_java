<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="nongsan.webmvc.model.User"%>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />

    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Sửa User</div>
                <hr>
                
                <%
				User user= (User)request.getAttribute("user");

				%>
                <form action="${pageContext.request.contextPath}/UserEditController1" method="post">
                	<input type="hidden" class="form-control" id="input-1" readonly="readonly" placeholder="ID" value="<%=user.getId()%>" name="user-id">
                  <div class="form-group">
                    <label for="input-1">ID</label>
                    <input disabled type="text" class="form-control" id="input-1" readonly="readonly" placeholder="ID" value="<%=user.getId()%>" name="user-id1">
                  </div>
                  <div class="form-group">
                    <label for="input-1">Họ tên</label>
                    <input required type="text" class="form-control" id="exampleInputUsername" placeholder="Họ tên" value="<%=user.getName()%>" name="user-name">
                  </div>
                  <div class="form-group">
                    <label for="input-2">Email</label>
                    <input required type="text" class="form-control" id="exampleInputUsername" placeholder="Địa chỉ Email" value="<%=user.getEmail()%>" name="user-email">
                  </div>
                  <div class="form-group">
                    <label for="input-3">Số điện thoại</label>
                    <input  required type="text" class="form-control" id="input-4" placeholder="Số điện thoại" value="<%=user.getPhone()%>" name="user-phone">
                  </div>
                  <div class="form-group">
                    <label for="input-3">UserName</label>
                    <input required type="text" class="form-control" id="input-5" placeholder="Username" value="<%=user.getUsername()%>" name="user-userName">
                  </div>
                  <div class="form-group">
                    <label for="input-4">Mật khẩu</label>
                    <input disabled required type="password" class="form-control" id="myinput" placeholder="Mật khẩu" value="<%=user.getPassword()%>" name="user-password">
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
					<input required type="hidden" class="form-control" id="myinput" placeholder="Mật khẩu" value="<%=user.getPassword()%>" name="user-password1">                  
                  </div>
                  <div class="form-group">
                    <label for="input-5">Date</label>
                    <input required type="date" class="form-control" id="input-6" placeholder="Ngày tạo" value="<%=user.getCreated()%>" name="user-created">
                  </div>
                  
                  <div class="form-group">
                    <a href="${pageContext.request.contextPath}/UserListController1">Hủy</a>
                        
                     <button type="submit" class="btn btn-success">Cập nhật</button>
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