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
    <div id="contentform2">
    <h1>jsonform</h1>
      <p>输入你的信息！</p>
      <p>${message }</p>
      <form:form id="form2" modelAttribute="jsoninfo" method="post" action="jsonform">
          
        <p><label>姓名：</label><form:input path="name" id="name"/></p>
        <p><label>年龄：</label><form:input path="age" id="age"/></p>
        <p><label>性别：</label><form:select path="sex" id="sex">
            <option value="男">男</option>
            <option value="女">女</option>
        </form:select></p>
        <p><label><input type="submit" value="提交" id="submitbutton"></label></p>
      </form:form>
      <script type="text/javascript">
      $(document).ready(function() {	
					
			$("#form2").submit(function() {  
				$("#submitbutton").hide();
				$.post($(this).attr("action"), $(this).serialize(), function(html) {
					$("#contentform2").replaceWith(html);
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