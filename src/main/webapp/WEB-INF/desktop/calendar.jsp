<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calendar.jsp</title>
<script type="text/javascript">
var year, month, date;

function changeListener() {
	//alert(this.value);
	var calc = new Date(year.value, month.value, 1);
	calc.setDate(calc.getDate()-1);
// 	alert(calc.toLocaleString());
	
	var options="";
	for(var i=0;i<calc.getDate();i++){
		options += "<option>"+(i+1)+"日</option>\n";
	}
	
	date.innerHTML = options;
// 	alert(options);
	
	var calendar="<table>";
	var calc2 = new Date(year.value, month.value-1, 1);
	
	var month1=calc2.getMonth();
	calc2.setDate(calc2.getDate());
//  	alert(calc2.toLocaleString());
	while(true){
		calendar +="<tr>";
		alert(calendar);
		if(calc2.getDate() == 1){
			for(int i=0;i<calc2.getDay();i++)
				calendar +="<td></td>";
		}	
		
		calendar +="<td>"+calc2.getDate()+"</td>";
		
		calc2.setDate(calc2.getDate()+1);
		
		if(month1 != calc2.getMonth())
			break;
		if(calc2.getDay()==0)
			calendar +="</tr>";
	}
	calendar+="</table>"
	alert(calendar);
	result.innerHTML = calendar;
}
window.onload = function() {
	year = document.querySelector("select[name=year]");
	month = document.querySelector("select[name=month]");
	date = document.querySelector("select[name=date]");
	
	year.onchange = changeListener;
	month.onchange = changeListener;
};
</script>
</head>
<body>
<hr>
<h1>Calendar</h1>
<hr>
<input name="year" type="range" min="2000" max="2100" value="2015">
<input name="year" type="number" min="2000" max="2100" value="2015">
<hr>
<%
	Date current = new Date();
	pageContext.setAttribute("current", current);
	
	Date calc = new Date(current.getYear(), current.getMonth()+1, 1);
	calc.setDate(calc.getDate()-1);
	pageContext.setAttribute("calc", calc);
%>
<select name="year">
	<c:forEach var="year" begin="2000" end="2020">
		<c:if test="${year==current.year+1900}">
			<option value="${year}" selected="selected">${year} 年</option>
		</c:if>
		<c:if test="${year!=current.year+1900}">
			<option value="${year}">${year} 年</option>
		</c:if>
	</c:forEach>
</select>
<select name="month">
	<c:forEach var="month" begin="1" end="12">
		<c:if test="${month == current.month+1}">
			<option value="${month}" selected="selected">${month} 月</option>
		</c:if>
		<c:if test="${month != current.month+1}">
			<option value="${month}">${month} 月</option>
		</c:if>
	</c:forEach>
</select>
<select name="date">
	<c:forEach var="date" begin="1" end="${calc.date}">
		<c:if test="${date == current.date}">
			<option value="${month}" selected="selected">${date} 日</option>
		</c:if>
		<c:if test="${date != current.date}">
			<option value="${date}">${date} 日</option>
		</c:if>
	</c:forEach>
</select>
<div id="result" style="border: 1px solid red; width: 800px; height: 300px;" />
</body>
</html>