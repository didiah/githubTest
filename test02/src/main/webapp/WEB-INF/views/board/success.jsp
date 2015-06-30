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
</head>
<body>
<form id='jobForm' action="/board/listPage" method="get">
	<input type='hidden' name='page' value='${cri.page }'>
	<input type='hidden' name='perPageNum' value='${cri.perPageNum }'>
	<input type='hidden' name='displayPageNum' value='${cri.displayPageNum }'>
	<input type='hidden' name='searchType' value='${cri.serachType }'>
	<input type='hidden' name='keyword' value='${cri.keyword }'>
</form>
<script type="text/javascript" src="/resources/js/jquery-1.11.2.min.js"></script>
<script>

alert("정상적으로처리되었습니다. \n 리스트로 이동합니다.")

$('#jobForm').submit();

</script>

</body>
</html>