<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Neuer Athlet</title>
      <link rel="stylesheet" href="css/style.css">
   </head>
   <body>
    
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Neuer Athlet erfassen</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/createAthlet">
         <table>
            <tr>
               <td>Nachname</td>
               <td><input type="text" name="lastName" value="${athlet.lastName}" /></td>
            </tr>
            <tr>
               <td>Vorname</td>
               <td><input type="text" name="firstName" value="${athlet.firstName}" /></td>
            </tr>
            <tr>
               <td>Jahrgang</td>
               <td><input type="text" name="year" value="${athlet.year}" /></td>
            </tr>
            <tr>
               <td>Geschlecht</td>
               <td><input type="text" name="gender" value="${athlet.gender}" /></td>
            </tr>
            <tr>
               <td>Kontakt</td>
               <td><input type="text" name="contact" value="${athlet.contactId}" /></td>
            </tr>
            <tr>
               <td>Ski-Club</td>
               <td><input type="text" name="club" value="${athlet.clubId}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="athletList">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>