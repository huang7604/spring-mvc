<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:if test="${!ajaxRequest }">
<html>
  <head>
    <title>spring-mvc</title>
    <script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
  </head>
  <body>
</c:if>
   <div id="contentform1">
      <h1>userform</h1>
   
      <p>输入你的账户和密码！</p>
      
      <form:form id="form1" commandName="userinfo" method="post" action="userform">
         <p>${message } </p>
        <p><label>账户：</label><form:input path="name" id="name"/></p>
        <p><label>密码：</label><form:password path="password" id="password"/></p>
        <p><label>邮箱：</label><form:input path="email" id="email"/></p>
        <p><label><input type="submit" value="提交" id="submitbutton"></label></p>
      </form:form>
      
      <script type="text/javascript">
     
		$(document).ready(function() {	
					
			$("#form1").submit(function() {  
				$("#submitbutton").hide();
				$.post($(this).attr("action"), $(this).serialize(), function(html) {
					$("#contentform1").replaceWith(html);
				});
				
				return false;  
			});	
		});
      </script>
    </div>
<c:if test="${!ajaxRequest }">
  </body>
</html>
</c:if>