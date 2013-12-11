<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html lang="en">
<head>
<meta charset="utf-8">
<title>YGPlatform</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
<!--script src="js/less-1.3.3.min.js"></script-->
<!--append â#!watchâ to the browser URL, then refresh the page. -->
<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="${ctxStatic}/bootstrap3.0/img/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="${ctxStatic}/bootstrap3.0/img/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="${ctxStatic}/bootstrap3.0/img/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="${ctxStatic}/bootstrap3.0/img/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon"
	href="${ctxStatic}/bootstrap3.0/img/favicon.png">
</head>

<body>
	<div id="main" class="container">
		<div id="header" class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default" role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Yuga Admin</a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">测试1</a></li>
							<li><a href="#">测试2</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
									<li class="divider"></li>
									<li><a href="#">One more separated link</a></li>
								</ul></li>
						</ul>
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input type="text" class="form-control">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#">Link</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul></li>
						</ul>
					</div>

				</nav>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-2 column" id="left">
				<div class="panel-group" id="panel-305613">
					<div class="panel panel-default">
						<div class="panel-heading">
							<a class="panel-title collapsed" data-toggle="collapse"
								data-parent="#panel-305613" href="#panel-element-485540">功能1</a>
						</div>
						<div id="panel-element-485540" class="panel-collapse collapse">
							<div class="panel-body">详细介绍</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<a class="panel-title collapsed" data-toggle="collapse"
								data-parent="#panel-305613" href="#panel-element-173762">功能2</a>
						</div>
						<div id="panel-element-173762" class="panel-collapse collapse">
							<div class="panel-body">详细介绍2</div>
						</div>
					</div>
				</div>
			</div>
			<div id="openClose" class="close">&nbsp;</div>
			<div class="col-md-10 column">
				<ul class="breadcrumb">
					<li><a href="#">首页</a> <span class="divider">/</span></li>
					<li><a href="#">工作流</a> <span class="divider">/</span></li>
					<li class="active">当前任务</li>
				</ul>
				<div class="tabbable" id="tabs-450941">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-141562" data-toggle="tab">待办任务</a></li>
						<li><a href="#panel-356407" data-toggle="tab">所有任务</a></li>
						<li><a href="#panel-356408" data-toggle="tab">请假申请</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-141562">
							<iframe src="a/oa/leave" style="overflow: visible;"
								scrolling="yes" frameborder="no" width="100%" height="650"></iframe>
						</div>
						<div class="tab-pane" id="panel-356407">
							<iframe src="a/oa/leave/list" style="overflow: visible;"
								scrolling="yes" frameborder="no" width="100%" height="650"></iframe>
						</div>
						<div class="tab-pane" id="panel-356408">
							<iframe src="a/oa/leave/form" style="overflow: visible;"
								scrolling="yes" frameborder="no" width="100%" height="650"></iframe>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<%-- <script type="text/javascript">
		var leftWidth = "160"; // 左侧窗口大小
		function wSize() {
			var minHeight = 500, minWidth = 980;
			var strs = getWindowSize().toString().split(",");
			$("#menuFrame, #mainFrame, #openClose").height(
					(strs[0] < minHeight ? minHeight : strs[0])
							- $("#header").height() - $("#footer").height()
							- 32);
			$("#openClose").height($("#openClose").height() - 5);
			if (strs[1] < minWidth) {
				$("#main").css("width", minWidth - 10);
				$("html,body").css({
					"overflow" : "auto",
					"overflow-x" : "auto",
					"overflow-y" : "auto"
				});
			} else {
				$("#main").css("width", "auto");
				$("html,body").css({
					"overflow" : "hidden",
					"overflow-x" : "hidden",
					"overflow-y" : "hidden"
				});
			}
			$("#right").width(
					$("#content").width() - $("#left").width()
							- $("#openClose").width() - 5);
		}
	</script>		
	<script src="${ctxStatic}/common/wsize.min.js" type="text/javascript"></script> --%>
</body>
</html>
