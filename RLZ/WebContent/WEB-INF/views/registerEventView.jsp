<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Athleten anmelden</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/toggleStyle.css">
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Anmelden</h3>

	<p style="color: red;">${errorString}</p>
	<p style="color: red;">${sucessString}</p>

	<div>
		<h3>${eventList.execDate}${eventList.name}</h3>
	</div>

	<div>
		<h3>Meine Athleten</h3>
		<table>
			<c:forEach items="${athletMyList}" var="athletMy">
				<tr>
					<td>${athletMy.id}</td>
					<td>${athletMy.lastName}</td>
					<td>${athletMy.firstName}</td>
					<td>${athletMy.year}</td>
					<td>${athletMy.gender}</td>
					<td>${athletMy.clubId}</td>
					<td>
					    <label class="switch"> <input type="checkbox" checked name="myAthletId" value=${athletMy.id}> <span class="slider round"></span></label>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

    <a href="addAthletEvent" class="button">Hinzufügen</a>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>