<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!-- Start header section -->
  <jsp:include page = "./header/header.jsp" flush = "true" />
    <div class="content-wrapper">
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <div class="card-title">Thêm tin tức</div>
                <hr>
                <form action="${pageContext.request.contextPath}/BoardnewAddController1" method="post">
                 
                  <div class="form-group">
                    <label for="input-2">Tên tin tức</label>
                    <input required type="text" class="form-control" id="input-2" placeholder="Tên tin tức" name="new-title">
                  </div>
                  <div class="form-group">
                    <label for="input-3">Nội dung</label>
                    <textarea required class="form-control" rows="4" id="input-17" name="new-content"></textarea>
                  </div>
                  <div class="form-group">
                    <label for="input-3">Hình ảnh</label>
                    <input required type="text" class="form-control" id="input-18" placeholder="Địa chỉ hình ảnh" name="new-image_link">
                  </div>
	               <div class="form-group">
	                  <label for="input-4">Người đăng</label>
                  <div>
                    <select class="form-control valid" id="input-4" name="new-author" required aria-invalid="false">
                        <option>Nguyen Ngoc Quang Nhan</option>
                        <option>Nguyen Dang Sang</option>
                        <option>Pham Van Phuong</option>
                        <option>Hoang Thi Thao</option>
                    </select>
                  </div>
                  </div>
                  <div class="form-group">
	                  <label for="input-5">Ngày đăng</label>
	                  <input type="date" class="form-control" id="the-date" name="new-created">
	              </div>
                 <div class="form-footer">
                 	
                    <a href="${pageContext.request.contextPath}/BoardnewListController1">Hủy</a>
                    <button type="submit" class="btn btn-success"><i class="fa fa-check-square-o"></i> Thêm</button>
                </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="overlay toggle-menu"></div>
      </div>
    </div>
  <script>
		var date = new Date();
		
		var day = date.getDate();
		var month = date.getMonth() + 1;
		var year = date.getFullYear();
		
		if (month < 10) month = "0" + month;
		if (day < 10) day = "0" + day;
		
		var today = year + "-" + month + "-" + day;
		
		
		document.getElementById('the-date').value = today;
</script>
    <jsp:include page = "./footer/footer.jsp" flush = "true" />