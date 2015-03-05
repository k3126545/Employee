<%@page import="java.util.List"%>
<%@page import="webapp.model.Emp"%>
<%@page import="webapp.model.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>infowithemps.jsp</title>
</head>
<body>
<hr>
<h1> 부서정보 </h1>
<hr>
스크립트로(getDeptInfoWithEmps) <br>
<% 
	Dept dept = (Dept)request.getAttribute("dept");
	%> DeptNo : <%out.println(dept.getDeptno()+"<br>");
	for(Emp e : dept.getEmps()){
		out.println("empno = "+e.getEmpno()+"<br>");
		out.println("ename = "+e.getEname()+"<br>");
		out.println("job = "+e.getJob()+"<br><br>");
	}
%>
<!--  
	Dept dept = (Dept)request.getAttribute("dept");
	List<Emp> list = dept.getEmps();
	for(Emp e : list){
		out.println(e.getEmpno() + " "+e.getEname()+" "+e.getJob());
	}
-->	
 
<hr>
EL로(getDeptInfoWithEmps) JSTL사용(태크 라이브러리) <br>
	DeptNo = ${requestScope.dept.deptno} <br>
<c:forEach var="e" items="${requestScope.dept.emps}">
	empno = ${pageScope.e.empno} <br>
	ename = ${pageScope.e.ename} <br>
	job = ${pageScope.e.job} <br><br>

</c:forEach>



</body>
</html>