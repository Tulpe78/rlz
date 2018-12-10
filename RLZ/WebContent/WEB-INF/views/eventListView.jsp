<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Alle Events</title>
    <link rel="stylesheet" href="css/style.css">
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Event-Liste</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table>
       <tr>
          <th>Id</th>
          <th>Saison</th>
          <th>Durchführung</th>
          <th>Name</th>
          <th>Beschreibung</th>
          <th></th>
          <th></th>
       </tr>
       <c:forEach items="${eventList}" var="event" >
          <tr>
             <td>${event.id}</td>
             <td>${event.saison}</td>
             <td>${event.execDate}</td>
             <td>${event.name}</td>
             <td>${event.descn}</td>
             <td>
                <a href="editEvent?id=${event.id}">Edit</a>
             </td>
             <td>
                <a href="deleteEvent?id=${event.id}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createEvent" class="button">Event hinzugügen</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>