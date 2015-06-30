<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/scc" href="/resources/css/bootstrap.css"/>
<link rel="stylesheet" type="text/scc" href="/resources/css/style.css"/>
<link rel="stylesheet" type="text/scc" href="/resources/css/style-responsive.css"/>
<script type="text/javascript" src="/resources/js/jquery-1.11.3.min.js"></script>
</head>
<body>

<ul class="task-list">
	<c:forEach items="${list}" var="board">
	<li id="${board }">
		<div class="task-title">
			<span class="task-title-sp">${board.bno }</span>
			<span class="task-title-sp">${board.title }</span>
			<div class="pull-rigth hidden-phone">
				<button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
				<button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
				<button class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i></button>
			</div>
		</div>
	</li>
	</c:forEach>
</ul>

<form id='jobForm'>
	<input type='hidden' name='bno'>
</form>

<script>
$(document).read(function(){
	
	$(".task-list").on("click","li", function(event){
		var targetId = $(this).attr("id");
		var targetForm = $("#jobForm");
		targetForm.find("input[name='bno']").val(targetId);
		targetForm.attr("action", "/board/view").attr("method","get");
		targetForm.submit();
	});
	
});

</script>

</body>
</html>