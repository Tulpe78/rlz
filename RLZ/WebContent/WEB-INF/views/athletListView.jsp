<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Alle Athleten</title>
    <link rel="stylesheet" href="css/style.css">
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Athletenliste</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table>
       <tr>
          <th>Id</th>
          <th>Nachname</th>
          <th>Vorname</th>
          <th>Jahrgang</th>
          <th>Geschlecht</th>
          <th>Contact-Daten</th>
          <th>Club</th>
          <th></th>
          <th></th>
       </tr>
       <c:forEach items="${athletList}" var="athlet" >
          <tr>
             <td>${athlet.id}</td>
             <td>${athlet.lastName}</td>
             <td>${athlet.firstName}</td>
             <td>${athlet.year}</td>
             <td>${athlet.gender}</td>
             <td>${athlet.contactId}</td>
             <td>${athlet.clubId}</td>
             <td>
                <a href="deleteAthlet?id=${athlet.id}">Delete</a>
             </td>
             <td>
                <a href="addAthlet?id=${athlet.id}">Add</a>
             </td>
          </tr>
       </c:forEach>
     </table>
     
     <a href="createAthlet" class="button">Athlet hinzufügen</a>
     
     <h3>Meine Athleten</h3>
     <table> 
       <tr>
          <th>Id</th>
          <th>Nachname</th>
          <th>Vorname</th>
          <th>Jahrgang</th>
          <th>Geschlecht</th>
          <th>Club</th>
          <th></th>
       </tr>
       <c:forEach items="${athletMyList}" var="athletMy" >
          <tr>
             <td>${athletMy.id}</td>
             <td>${athletMy.lastName}</td>
             <td>${athletMy.firstName}</td>
             <td>${athletMy.year}</td>
             <td>${athletMy.gender}</td>
             <td>${athletMy.clubId}</td>
             <td>
                <a href="removeMyAthlet?id=${athletMy.id}">Entfernen</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>