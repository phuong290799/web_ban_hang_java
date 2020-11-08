<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="nongsan.webmvc.model.Catalog"%>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Sửa chuyên mục</div>
                <hr>
          	<%
				Catalog catalog= (Catalog)request.getAttribute("catelist");

			%>
	                <form action="${pageContext.request.contextPath}/CategoryEditController1" method="post">
	                <input type="hidden" class="form-control" readonly id="input-1" placeholder="ID" name="id" value="<%=catalog.getId()%>">
	                  <div class="form-group">
	                    <label for="input-1">ID</label>
	                    <input disabled type="text" class="form-control" readonly id="input-1" placeholder="ID" name="id1" value="<%=catalog.getId()%>">
	                  </div>
	                  <div class="form-group">
	                    <label for="input-1">Tên chuyên mục</label>
	                    <input required type="text" class="form-control" id="input-1" placeholder="Tên chuyên mục" name="name" value="<%=catalog.getName()%>">
	                  </div>
		              <div class="form-group">
		                  <label for="input-2">Chuyên mục cha</label>
		                  <div>
		                     <select required class="form-control valid" id="input-6" name="parent-id" aria-invalid="false">
		                     <%if(catalog.getParent_id().equals(0)) {%>
		                        <option value="0" selected="selected">Sản Phẩm Cũ</option>
		                        <option value="1">Sản phẩm mới</option>
		                      <%}else{ %>
		                       <option value="0" >Sản Phẩm Cũ</option>
		                        <option value="1" selected="selected">Sản phẩm mới</option>
		                       <%} %>
		                    </select>
		                  </div>
		               </div>
	                   <div class="form-footer">
	                      <a href="${pageContext.request.contextPath}/CategoryListController1">Hủy</a>
                         
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