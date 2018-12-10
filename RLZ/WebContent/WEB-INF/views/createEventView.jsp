<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Neuer Event</title>
      <link rel="stylesheet" href="css/style.css">
   </head>
   <body>
    
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Neues Rennen erfassen</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/createEvent">
         <table>
            <tr>
               <td>Saison</td>
               <td><input type="text" name="saison" value="${event.saison}" /></td>
            </tr>
            <tr>
               <td>Durchführung</td>
               <td><input type="text" name="execDate" value="${event.execDate}" /></td>
            </tr>
            <tr>
               <td>Name</td>
               <td><input type="text" name="name" value="${event.name}" /></td>
            </tr>
            <tr>
               <td>Beschreibung</td>
               <td><input type="text" name="descn" value="${event.descn}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="eventList">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>