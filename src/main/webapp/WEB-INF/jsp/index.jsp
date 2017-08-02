<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
  <head>
    <title>spring-mvc</title>
    <link href="<c:url value="/resources/form/form.css" />" rel="stylesheet"  type="text/css" />		
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.core.css" />" rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.theme.css" />" rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.tabs.css" />" rel="stylesheet" type="text/css"/>
  </head>
  <body>
    <h1>spring-mvc</h1>
    <div id="tabs">
       <ul>
        <li><a href="<c:url value="/userform"/>" title="userform">UserForm</a></li>
        <li><a href="<c:url value="/jsonform"/>" title="jsonform">JsonForm</a></li>
       </ul>
    </div>
    <p>
    mvc-2017
    <script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/jqueryform/2.8/jquery.form.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.core.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.widget.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.tabs.js" />"></script>
    <script type="text/javascript">
       $(document).ready(function(){
    	   $("#tabs").tabs();
    	   window.location.hash = ui.tab.hash;
       });
    
    </script>
    </p>
  </body>

</html>