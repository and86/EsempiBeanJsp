<%@page import="it.alfasoft.andrea.servizi.ServizioRegistrazione"%>
<%@page import="it.alfasoft.andrea.UtenteBean"%>
<%@page import="it.alfasoft.andrea.dao.UtenteDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="utente" class="it.alfasoft.andrea.UtenteBean" scope="session" />
<jsp:useBean id="messaggio" class="it.alfasoft.andrea.MessaggioBean" scope="request" />

<jsp:setProperty property="*" name="utente" />

<%
	ServizioRegistrazione su = new ServizioRegistrazione();
	UtenteBean u = su.getUtente(utente.getUsername());

	if (u != null) {
		String pass_web = su.convertiPassword(utente.getPassword()); //pass che inserisco nella pagina login ancora da crittografare
		String pass_db = u.getPassword(); //pass nel db già crittografata 
		if (pass_web.equals(pass_db)) {
%>
<jsp:forward page="Welcome.jsp" />

<%
	} else {
			//User e/o password errata: torna alla pagina login
			messaggio.passwordErrata();
%>
<jsp:forward page="Login.jsp" />

<%
	}
	} else {
		messaggio.campiNonValidi();
%>
<jsp:forward page="Login.jsp" />
<%
	}
	
%>

