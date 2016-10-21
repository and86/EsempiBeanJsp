<%@page import="it.alfasoft.andrea.UtenteBean"%>
<%@page import="it.alfasoft.andrea.dao.UtenteDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="utente" class="it.alfasoft.andrea.UtenteBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Elenco Utenti</h1>
	<table border="1">
<%-- 	${UtenteBean.nomeaAttributo} --%>
	
		<thead>

			<tr>
				<th>n.</th>
				<th>nome</th>
				<th>cognome</th>
			</tr>

		</thead>

		<%
			UtenteDao uDao = new UtenteDao();
			int i = 1;
			for (UtenteBean u : uDao.getTuttiUtenti()) {
				utente.setNome(u.getNome());
				utente.setCognome(u.getCognome());
		%>

		<tr>
			<td><%=i %></td>
			<td> <${utente.nome}></td>
			<td> <${utente.cognome}> </td>
		</tr>

		<%
			i++;
			}
		%>


	</table>

</body>
</html>