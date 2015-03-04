<%@page import="webapp.model.Emp"%>
<%@page import="webapp.model.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>info.jsp</title>
</head>
<body>
<hr>
<h1> 부서정보 </h1>
<hr>
스크립트로(getDeptInfo) <br>
<%
	Dept dept = (Dept)request.getAttribute("dept");
	out.println("deptno = "+dept.getDeptno() +"<br>");
	out.println("dname = "+dept.getDname() +"<br>");
	out.println("loc = "+dept.getLoc() +"<hr>");
%>스크립트로(getDeptInfoWithEmps) <br>
<% 
	Dept dept2 = (Dept)request.getAttribute("dept2");
	for(Emp e : dept2.getEmps()){
		out.println("empno = "+e.getEmpno()+"<br>");
		out.println("ename = "+e.getEname()+"<br>");
		out.println("job = "+e.getJob()+"<br>");
	}
%>
<hr>
EL로(getDeptInfo) <br>
	deptno = ${requestScope.dept.deptno} <br>
	dname = ${requestScope.dept.dname} <br>
	loc = ${requestScope.dept.loc} <br>
<hr>
EL로(getDeptInfoWithEmps) <br>


</body>
</html>