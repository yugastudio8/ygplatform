<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld"%>
<%@ taglib prefix="fnc" uri="/WEB-INF/tlds/fnc.tld"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<c:set var="ctx"
	value="${pageContext.request.contextPath}${fns:getAdminPath()}" />
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />


<link href="${ctxStatic}/bootstrap3.0/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctxStatic}/bootstrap3.0/css/style.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->
<script type="text/javascript" src="${ctxStatic}/common/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${ctxStatic}/common/yuga.js"></script>
<link href="${ctxStatic}/common/yuga.css" rel="stylesheet">
<script type="text/javascript" src="${ctxStatic}/bootstrap3.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/bootstrap3.0/js/scripts.js"></script>
<script src="${ctxStatic}/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${ctxStatic}/common/mustache.js" type="text/javascript"></script>
<link href="${ctxStatic}/jquery-validation/1.11.0/jquery.validate.min.css" type="text/css" rel="stylesheet" />
<script src="${ctxStatic}/jquery-validation/1.11.0/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/jquery-validation/1.11.0/jquery.validate.method.min.js" type="text/javascript"></script>

<%@include file="/WEB-INF/views/include/dialog.jsp"%>