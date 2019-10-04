<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	@media (min-height:320px){
		tr:hover {
			background-color: gray;
		}
	}
</style>
</head>
<body>
<table>
	<tbody>
		<c:forEach items="${list }" var="list">
			<tr>
				<td class="no" attr="${list.no }">${list.no }</td>
				<td>${list.title }</td>
				<td>${list.content }</td>
				<td>${list.startDate }</td>
				<td>${list.endDate }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script>
window.addEventListener('load', function () {
	view();
})
function view() {
	var view = document.getElementsByClassName('no');
	console.log(view.length);
    for(var i=0; i < view.length; i++){
    	view[i].addEventListener('click', function () {
            var no = view[i].getAttribute('attr');
            console.log(no);
        });
    };
}
</script>
</body>
</html>