<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<div class = "form-group">
	<label class="col-sm-4 col-sm-4 control-label">Bno</label>
	<div class="col-sm-10">
		<input class="form-control" name="bno" type="text" value="${boardVO.bno }">
	</div>
</div>
<div class = "form-group">
	<label class="col-sm-4 col-sm-4 control-label">Title</label>
	<div class="col-sm-10">
		<input class="form-control" name="title" type="text" value="${boardVO.title}">
	</div>
</div>
<div class = "form-group">
	<label class="col-sm-4 col-sm-4 control-label">Content</label>
	<div class="col-sm-10">
		<textarea class="form-control" name="content" rows="5">${boardVO.content}></textarea>
	</div>
</div>
<div class = "form-group">
	<label class="col-sm-4 col-sm-4 control-label">Regist Date</label>
	<div class="col-sm-10">
		<input class="form-control" name="regdate" type="text" value="${boardVO.regdate}">
	</div>
</div>
<div class = "form-group">
	<label class="col-sm-4 col-sm-4 control-label">Writer</label>
	<div class="col-sm-10">
		<input class="form-control" name="writer" type="text" value="${boardVO.writer}">
	</div>
</div>

<form id = 'jobForm'>
	<input type='hidden' name='bno' value='${boardVO.bno}'>
	<input type='hidden' name='page' value='${cri.page }'>
	<input type='hidden' name='perPageNum' value='${cri.perPageNum }'>
	<input type='hidden' name='displayPageNum' value='${cri.displayPageNum }'>
	<input type='hidden' name='searchType' value='${cri.serachType }'>
	<input type='hidden' name='keyword' value='${cri.keyword }'>
</form>

<div class="col-sm-3 col-sm-3 pull-right">
	<button type="button" id='listBtn' class="btn btn-theme">List</button>
	<button type="button" id='modBtn' class ="btn btn-theme02">Modify</button>
	<button type="button" id='delBtn' class ="btn btn-theme03">Delete</button>
</div>
	
	<script type="text/javascript" src="/resources/js/jquery-1.11.3.min.js"></script>
	<script>
		
	$(document).ready(function(){
	
		var jobForm = $("#jobForm");
		
		$("#delBtn").click(function(){
		
		jobForm.attr("action", "/board/remove");
		jobForm.attr("method", "post");
		jobForm.submit();
	});
	
	$("#modBtn").click(function(){
		jobForm.attr("action", "/board/modPage");
		jobForm.attr("method","get");
		jobForm.submit();
	});
	$("#listBtn").click(function(){
		jobForm.attr("action", "/board/listPage");
		jobForm.attr("method", "get");
		jobForm.submit();
	});
	});
	</script>
	


</body>
</html>