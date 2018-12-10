<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Delete Event</title>
    <link rel="stylesheet" href="css/style.css">
 </head>
 
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
    
    <h3>Delete Event</h3>
    
    <p style="color: red;">${errorString}</p>
    <a href="eventList">Event List</a>
    
    <jsp:include page="_footer.jsp"></jsp:include>
    
 </body>
</html>