<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Alle Rennen</title>
    <link rel="stylesheet" href="css/style.css">
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>

	<div id="registerTab" class="clear">
		<c:forEach items="${eventList}" var="event">
		    <c:choose> 
			<c:when test="${(event.execDate == '21.02.2018')}">
				<div class="plan" id="most-popular">
					<h3>
						${event.name}<span>${event.execDate}</span>
					</h3>
					<a class="signup" href="registerEvent?id=${event.id}">Anmelden</a>
					<ul>
						<li><b>Startliste</b></li>
						<li><b>Rangliste</b></li>
					</ul>
				</div>
			</c:when>
			<c:otherwise>
				<div class="plan">
					<h3>
						${event.name}<span>${event.execDate}</span>
					</h3>
					<a class="signup" href="registerEvent?id=${event.id}">Anmelden</a>
					<ul>
						<li><b>Startliste</b></li>
						<li><b>Rangliste</b></li>
					</ul>
				</div>
			</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>

</body>