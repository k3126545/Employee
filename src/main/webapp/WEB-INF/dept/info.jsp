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
<title>info.jsp</title>
</head>
<body>
<hr>
<h1> 부서정보</h1>
<hr>

스크립트로(getDeptInfo) <br>
<%
	Dept dept = (Dept)request.getAttribute("dept");
	out.println(dept.getDeptno() +", "+dept.getDname()+", "+dept.getLoc());
%>
<hr>
스크립트로(getDeptInfoWithEmps) <br>
<% 
	Dept dept2 = (Dept)request.getAttribute("dept2");
	for(Emp e : dept2.getEmps()){
		out.println(e.getEmpno()+", "+e.getEname()+", "+e.getJob()+"<br>");
	}
%>
<hr>
스크립트로(getDeptInfoAll)<br>
<% 
	List<Dept> list = (List<Dept>)request.getAttribute("list");
	for(Dept d : list){
		out.println(d.getDeptno() +", "+d.getDname()+", "+d.getLoc()+"<br>");
	}
%>
<hr>
EL로(getDeptInfo) <br>
	${requestScope.dept.deptno}, ${requestScope.dept.dname}, 
	${requestScope.dept.loc} <br>
<hr>
EL로(getDeptInfoWithEmps) JSTL사용(태크 라이브러리)<br>
	<c:forEach var="e" items="${requestScope.dept2.emps}">
	${pageScope.e.empno}, ${pageScope.e.ename}, ${pageScope.e.job} <br>
	</c:forEach>
<hr>
EL로(getDeptInfoAll) JSTL사용(태크 라이브러리)<br>
	<c:forEach var="d" items="${requestScope.list}">
	${pageScope.d.deptno}, ${pageScope.d.dname}, 
	${pageScope.d.loc} <br>	
	</c:forEach>

</body>
</html>