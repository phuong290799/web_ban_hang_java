<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="nongsan.webmvc.model.Product"%>
<%@page import="nongsan.webmvc.model.Catalog"%>
<%@page import="java.util.List"%>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />

    <div class="content-wrapper">
      <div class="container-fluid">
        <div class="row mt-3">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Sửa sản phẩm</div>
                <hr>
                <%
				Product product= (Product)request.getAttribute("product");

				%>
                <form method="post" action="${pageContext.request.contextPath}/ProductEditController1">
                <input type="hidden" class="form-control" readonly="readonly" id="input-1" placeholder="Mã sản phẩm" name="product-sku" value="<%=product.getId()%>">
                 <div class="form-group">
                    <label for="input-1">Mã sản phẩm</label>
                    <input disabled type="text" class="form-control" readonly="readonly" id="input-1" placeholder="Mã sản phẩm" name="product-sku1" value="<%=product.getId()%>">
                  </div>
                  
                  <div class="form-group">
                    <label for="input-1">Tên sản phẩm</label>
                    <input required type="text" class="form-control" id="input-1" placeholder="Tên sản phẩm" name="product-name" value="<%=product.getName()%>">
                  </div>
                  
        
                  <div class="form-group">
	                  <label for="input-2">Chuyên mục</label>
	                  <div>
	                    <select class="form-control valid" id="input-6" name="product-cate" aria-invalid="false">
	                    
	                    
	                    <%
					          List<Catalog> arrcate= (List<Catalog>) request.getAttribute("catelist");
					          for(int i=0; i<arrcate.size(); i++)
					          {
						          int idcate=Integer.parseInt(arrcate.get(i).getId());
						          
				
				          %>
	                    <% if(product.getCatalog_id().equals(arrcate.get(i).getId())){ %>
	                        <option value="<%=arrcate.get(i).getId()%>" selected="selected"><%=arrcate.get(i).getName()%></option>
	                    <%}else{ %>>
	                   <option value="<%=arrcate.get(i).getId()%>" ><%=arrcate.get(i).getName()%></option>	
	                   <%} }%>
	                   
	                    </select>
	                  </div>
	                </div>
	                 <div class="form-group">
                    <label for="input-1">Ngày</label> 
                    <input required type="date" class="form-control" id="input-1" placeholder="Ngày đăng" name="product-day" value="<%=product.getCreated()%>">
                  </div>
	                <div class="form-group">
                    <label for="input-1">Giá</label>
                    <input required type="text" class="form-control" id="input-1" placeholder="Giá" name="product-price" value="<%=product.getPrice()%>">
                  </div>
                  
                    <div class="form-group">
	                  <label for="input-2">Trạng thái</label>
	                  <div>
	                    <select class="form-control valid" id="input-6" name="product-status" required aria-invalid="false">
	                        <option value="1">Còn hàng</option>
	                        <option value="0" >Hết hàng</option>
	                    </select>
	                  </div>
	                </div>
	                 <div class="form-group">
		                <label for="input-2">Giảm giá</label>
		                <div class="input-group">
		                <input required type="text" class="form-control" placeholder="Giảm ... %" name="product-discount" value="<%=product.getDiscount()%>">
		                <div class="input-group-append">
		                <button class="btn btn-light" type="button">%</button>
		                </div>
		                </div>
	              </div>
                 <div class="form-group">
                  <label for="input-2" class="col-form-label">Mô tả</label>
                  <div>
                    <textarea required class="form-control" rows="4" id="input-17" name="product-desc"><%=product.getDescription()%></textarea>
                  </div>
                </div>
                <div class="form-group">
                  <label for="input-2" class="col-form-label">Nội dung</label>
                  <div>
                    <textarea required class="form-control" rows="4" id="input-17" name="product-content"><%=product.getContent()%></textarea>
                  </div>
                </div>
                
                 <div class="form-group">
                    <label for="input-1">Ảnh đại diện</label>
                    <input required type="text" class="form-control" id="input-1" placeholder="Tên hình" name="product-image" value="<%=product.getImage_link()%>">
                  </div>
              
              
          
               <div class="form-footer">
                     <a href="${pageContext.request.contextPath}/ProductListController1">Hủy</a>
                         
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