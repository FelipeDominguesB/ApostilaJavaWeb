<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>	

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="java.util.*,  entities.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<jsp:useBean id="dao" class="DAO.ContatoDAO"/>
		  
		  
		<table border="1">
		    <c:forEach var="contato" items="${dao.lista}" varStatus="id">
		      <tr>
			    <td>${contato.nome}</td>
			    <td>${contato.email}</td>
			    <td>${contato.endereco}</td>
			    <td>${contato.dataNascimento.time}</td>
			  </tr>
		    </c:forEach>
		 </table>

  			
    </body>

</html>