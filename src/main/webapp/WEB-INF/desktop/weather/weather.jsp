<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>show.jsp</title>
</head>
<body>
<hr>
<h1>날씨 정보 조회 결과</h1>
<hr>
${city} 의 날씨정보 !!! <br>

<table border="1" style="border-collapse: collapse; ">
	<tr><td>날짜</td>
		<c:forEach var="f" items="${weather.forecasts}" varStatus="status">
			<td>${f.date} ${f.day}</td>
		</c:forEach>
	</tr>
	<tr><td>최고 기온</td>
		<c:forEach var="f" items="${weather.forecasts}" varStatus="status">
			<td>${f.high}</td>
		</c:forEach>
	</tr> 
 	<tr><td>최저 기온</td>
		<c:forEach var="f" items="${weather.forecasts}" varStatus="status">
		<td>${f.low}</td>
		</c:forEach>
	</tr>
	<tr><td>날씨 상태</td>
		<c:forEach var="f" items="${weather.forecasts}" varStatus="status">
			<td>${f.skytextday}</td>
		</c:forEach>
	<tr><td>이미지</td>
		<c:forEach var="f" items="${weather.forecasts}" varStatus="status">
			<c:if test="0<${f.skycodeday}<40"></c:if>
			<td><img src="/webapp/sql/sun.jpg">${f.skycodeday}</td>
		</c:forEach>
	</tr>
	
</table>
			<% 		out.println(request.getContextPath());%>

<%-- <% --%>
<!-- // 	String a = request.getParameter("city"); -->
<!-- // 	out.println(a+"의 날씨정보 !!!"); -->
<%-- %> --%>
<!-- <table border="1" style="border-collapse: collapse;"> -->
<!-- 	<tr><td></td> -->
<%-- 	<c:forEach var="date" items="${date}" varStatus="status"> --%>
<%-- 			<td>${date}</td> --%>
<%-- 	</c:forEach> --%>
<!-- 	</tr> -->
<!-- 	<tr><td>최고 기온</td> -->
<%-- 	<c:forEach var="high" items="${high}" varStatus="status"> --%>
<%-- 			<td>${high}</td> --%>
<%-- 	</c:forEach> --%>
<!-- 	</tr> -->
<!-- 	<tr><td>최저 기온</td> -->
<%-- 	<c:forEach var="low" items="${low}" varStatus="status"> --%>
<%-- 			<td>${low}</td> --%>
<%-- 	</c:forEach> --%>
<!-- 	</tr> -->
<!-- 	<tr><td>날씨 상태</td> -->
<%-- 	<c:forEach var="skytextday" items="${skytextday}" varStatus="status"> --%>
<%-- 			<td>${skytextday}</td> --%>
<%-- 	</c:forEach> --%>
<!-- 	</tr> -->
<!-- </table> -->

</body>
</html>