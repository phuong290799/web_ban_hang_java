<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/admin/assets" var="url"/>

  <jsp:include page = "./right-sidebar.jsp" flush = "true" />
  
  
 <script src="${url}/js/jquery.min.js"></script>
  <script src="${url}/js/popper.min.js"></script>
  <script src="${url}/js/bootstrap.min.js"></script>
  <script src="${url}/plugins/simplebar/js/simplebar.js"></script>
  <script src="${url}/js/sidebar-menu.js"></script>
  <script src="${url}/js/jquery.loading-indicator.js"></script>
  <script src="${url}/js/app-script.js"></script>
  <script src="${url}/plugins/Chart.js/Chart.min.js"></script>
  <script src="${url}/js/index.js"></script>
  <script src="${url}/plugins/summernote/dist/summernote-bs4.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css">
<script>
// just for the demos, avoids form submit
jQuery.validator.setDefaults({
  debug: true,
  success: "valid"
});
$( "#myform" ).validate({
  rules: {
    input-2: {
      required: true,
     
    },
    
    }
  }
});
</script>
</body>

</html>