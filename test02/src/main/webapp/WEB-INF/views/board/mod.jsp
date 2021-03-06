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

<form method='post' action="/board/mod">
	<div class="form-group">
		<label class="col-sm-2 col-sm-2 control-label">Bno</label>
		<div class="col-sm-10">
			<input class="form-control" name='bno' type="text" value="${boardVO.bno}" readonly>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 col-sm-2 control-label">Title</label>
		<div class="col-sm-10">
			<input class="form-control" name='title' type="text" value="${boardVO.title}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 col-sm-2 control-label">Content</label>
		<div class="col-sm-10">
			<textarea class="form-control" name='content' rows="5" >${boardVO.content}</textarea>
		</div>
	</div>
		<div class="form-group">
		<label class="col-sm-2 col-sm-2 control-label">Regist Date</label>
		<div class="col-sm-10">
			<fmt:formatDate value="${boardVO.regdate}" var="dateString" pattern="yyyy/MM/dd hh:mm"/>
			<input class="form-control" type="text" value="${dateString}" readonly>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 col-sm-2 control-label">Writer</label>
		<div class="col-sm-10">
			<input class="form-control" name='writer' type="text" value="${boardVO.writer}" readonly>
		</div>
	</div>	
	<div class="showback">
		<button class="btn btn-theme" type="submit">Save</button>
	</div>
</form>
</body>
</html>