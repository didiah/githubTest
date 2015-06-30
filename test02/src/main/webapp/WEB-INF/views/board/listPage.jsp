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
<script src="http://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<div class="pancel-heading">
	<div class="puu-left"><h5><i class="fa fa-tasks"></i>Board List - Total : ${pageMaker.totalCount }</h5></div>
	<br>
</div>
<ul class="task-list">
	<c:if test="${list ==null or list.size() ==0 }">
		<li>검색 결과가 없습니다.</li>
	</c:if>
	
	<c:forEach items="${list} " var="baord">
		<li id="${board.bno }">
			<div class="task-title">
				<span class="task-title-sp">${board.bno }</span>
				<span class="task-title-sp">${board.title }</span>
				<div class="pull-right hidden-phone">
					<button class="btn btn-success btn-xs"><i class="fa fa-check"></i></button>
					<button class="btn btn-primary btn-xs"><i class="fa fa-Pencil"></i></button>
					<button class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i></button>
				</div>
			</div>
			</li>
	</c:forEach>
</ul>
<div class="col-lg-12">
<form id="jobForm">
	<input type='hidden' name='bno' value=1>
	<input type='hidden' name='page' value='${cri.page }'>
	<input type='hidden' name='displayPageNum' value='${cri.displayPageNum }'>
	<input type="radio" name='perPageNum' value="10" <c:out value="${cri.perPageNum ==10?'checked':'' }"/>>10개
	<input type="radio" name='perPageNum' value="20" <c:out value="${cri.perPageNum ==20?'checked':'' }"/>>20개
	<input type="radio" name='perPageNum' value="50" <c:out value="${cri.perPageNum ==50?'checked':'' }"/>>50개
	<select name="searchType">
		<option value="n" <c:out value="${cri.searchType eq 'n'?'selected':''}"/>>-----</option>
		<option value="t" <c:out value="${cri.searchType eq 't'?'selected':''}"/>>Title</option>
		<option value="c" <c:out value="${cri.searchType eq 'c'?'selected':''}"/>>Content</option>
		<option value="w" <c:out value="${cri.searchType eq 'w'?'selected':''}"/>>Writer</option>
		<option value="tc" <c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>Title OR ConTent</option>
		<option value="cw" <c:out value="${cri.searchType eq 'cw'?'selected':''}"/>>Content OR Writer</option>
		<option value="tcw" <c:out value="${cri.searchType eq 'tcw'?'selected':''}"/>>Title OR Content OR Writer</option>
	</select>
	<input type="text" name='keyword' id="keywordInput" value='${cri.keyword }'>
	<button id='searchBtn'>Search</button>
	</form>
</div>

<div class="text-center">
	<ul class="pagination">
	
	<c:if test="${pageMaker.prev !=0 }">
		<li><a href="${pageMaker.prev }">&laquo;</a></li>
	</c:if>	
	<c:forEach begin="${pageMaker.first }" end="${pageMaker.last }" var="idx">
		<li <c:out value="${cri.page == idx?'class =active':''}"/>><a href="${idx }">${idx }</a></li>
	</c:forEach>
	<c:if test="${pageMaker.next != 0 }">
		<li><a href="${pageMaker.next }">&raquo;</a></li>
	</c:if>		
	</ul>
</div>


<script>
$(".task-list").on("click", "li",function(event){
	
	
	var targetId = $(this).attr("id");
	
	var jobForm = $("#jobForm");
	
	jobform.find("input[name='bno']").val(targetId);
	
	jobForm.attr("action", "/board/readPage").attr("method","get");
	
	jobForm.submit();
});
</script>

<script>
$(".paginathoin li a").on("click", function(event){
	
	event.preventDefault();
	
	var targetPageNum = $(this).attr("href");
	
	var jobForm = $("#jobForm");
	
	jobform.find("input[name='bno']").remove();
	jobform.find("[name='page']").val(targetPageNum);
	jobForm.attr("action", "/board/listPage").attr("method","get");
	
	jobForm.submit();
});
</script>
<script>
$("#searchBtn").on("click",function(event){
	var jobForm = $("#jobForm");
	jobForm.find("input[name='bno']").remove();
	jobForm.find("[name='page']").val(1);
	jobForm.attr("action", "/board/listPage").attr("method","get");
});
</script>

</body>
</html>