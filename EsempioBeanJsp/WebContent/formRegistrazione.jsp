<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="messaggio" class="it.alfasoft.andrea.MessaggioBean" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration Page</h1>

<form action="doRegistrazioneUtente.jsp" method="post">
nome:<input type="text" name="nome"/><br>
cognome:<input type="text" name="cognome" /><br>
username:<input type="text" name="username"/><br>
password:<input type="password" name="password"/><br>

<input type="submit" value="Registra"/>


</form>
<%=messaggio.getMessaggio() %><br>
</body>
</html>