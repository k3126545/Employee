<%@page import="java.util.List"%>
<%@page import="webapp.model.Emp"%>
<%@page import="webapp.model.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>infoall.jsp</title>
<style type="text/css">
	table {
		border: 2px solid red;
		border-collapse: collapse;
	}
	tr, td {
		border: 1px dashed blue;	
		padding: 20px;
	}
	tr, th{
		border: 1px solid black;
	}
	td:HOVER {
		background-color: orange;
	}
</style>
<script type="text/javascript">
window.onload = function() {
	var tds = document.querySelectorAll("td");
	for (var i = 0; i < tds.length; i++) {
		tds[i].onclick = function() {
			if(this.style.color != "red")
				this.style.color = "red";
			else
				this.style.color = "black";
		}
	}
}
</script>
</head>
<body>
<hr>
<h1> 부서정보 all </h1>
<hr>
<table>
	<tr><th>deptno</th><th>dname</th><th>loc</th></tr>
	<tr><td>1000</td><td>총무부</td><td>서울</td></tr>
	<tr><td>1001</td><td>총무부</td><td>서울</td></tr>
	<tr><td>1002</td><td>총무부</td><td>서울</td></tr>
	<tr><td>1003</td><td>총무부</td><td>서울</td></tr>

</table>
스크립트로(getDeptinfoall) <br>
<% 
	List<Dept> list = (List<Dept>)request.getAttribute("list");
%>
<table>
	<tr><th>deptno</th><th>dname</th><th>loc</th></tr>
<%
	for(Dept d : list){
		out.print("<tr>");
		out.println("<td>"+d.getDeptno() +"</td><td>"+d.getDname()+"</td><td>"+d.getLoc()+"</td>");
		out.print("</tr>");
	}
%>
</table>
<hr>
EL로(getDeptinfoall) <br>
<table>
	<tr><th>deptno</th><th>dname</th><th>loc</th></tr>
<c:forEach var="d" items="${requestScope.list}">
	<tr>
		<td>${pageScope.d.deptno} </td>
		<td>${pageScope.d.dname} </td>
		<td>${pageScope.d.loc} </td>
	</tr>
</c:forEach>
</table>
<hr>

</body>
</html>