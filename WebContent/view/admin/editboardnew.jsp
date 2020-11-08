<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="nongsan.webmvc.model.Boardnew"%>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Sửa tin tức</div>
                <hr>
                <%
				Boardnew boardnew= (Boardnew)request.getAttribute("boardnewlist");

			%>
                <form action="${pageContext.request.contextPath}/BoardnewEditController1" method="post">
                <input type="hidden" class="form-control" readonly id="input-1" placeholder="ID" value="<%=boardnew.getId()%>" name="new-id">
                 <div class="form-group">
                    <label for="input-1">ID</label>
                    <input disabled type="text" class="form-control" readonly id="input-1" placeholder="ID" value="<%=boardnew.getId()%>" name="new-id1">
                  </div>
                  <div class="form-group">
                    <label for="input-2">Tên tin tức</label>
                    <input required type="text" class="form-control" id="input-2" placeholder="Tên tin tức" value="<%=boardnew.getTitle()%>"name="new-title">
                  </div>
                  <div class="form-group">
                    <label for="input-3">Nội dung</label>
                    <textarea required class="form-control" rows="4" id="input-17" name="new-content"><%=boardnew.getContent()%></textarea>
                  </div>
                  <div class="form-group">
                    <label for="input-2">Hình ảnh</label>
                    <input required type="text" class="form-control" id="input-10" placeholder="Địa chỉ hình ảnh" value="<%=boardnew.getImage_link()%>"name="new-image_link">
                  </div>
	               <div class="form-group">
	                  <label for="input-4">Người đăng</label>
                  <div>
                    <select required class="form-control valid" id="input-4" name="new-author"" >
                        
                        <option>Nguyen ngoc quang nhan</option>
                        <option>Pham van phuong</option> 
                        <option>Hoang thi thao</option>
                        <option>Nguyen dang sang</option>
                    </select>
                  </div>
                  </div>
                  <div class="form-group">
	                  <label for="input-5">Ngày đăng</label>
	                  <input required type="date" class="form-control" id="input-5" value="<%=boardnew.getCreated()%>" name="new-created">
	              </div>
                 <div class="form-footer">
                 	<a href="${pageContext.request.contextPath}/BoardnewListController1">Hủy</a>
                     <button class="btn btn-success">Cập nhật</button>
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