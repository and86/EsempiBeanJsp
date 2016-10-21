<%@page import="it.alfasoft.andrea.UtenteBean"%>
<%@page import="it.alfasoft.andrea.servizi.ServizioRegistrazione"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="utente" class="it.alfasoft.andrea.UtenteBean"
	scope="request" />
<jsp:useBean id="messaggio" class="it.alfasoft.andrea.MessaggioBean"
	scope="request" />
<jsp:setProperty property="*" name="utente" />


<%
	ServizioRegistrazione su=new ServizioRegistrazione();
	UtenteBean u = su.getUtente(utente.getUsername());
	
		
	if (utente.isValid() == true) {
		//campi inseriti validi
		if(u!=null){	//username disponibile
				
			//prendo password che stata inserita da utente
			String pass=utente.getPassword();
				
			//modifico password con algoritmo di codofica
			pass=su.convertiPassword(pass);
		
			// lo setto di nuovo dentro bean 
    	
    		utente.setPassword(pass);
		
			//salvo utente dentro dt
			su.registraUtente(utente);
%>
<jsp:forward page="RegistrazioneConSuccesso.jsp" />

<%
	} else {
		//user non disponibile
		messaggio.usernameEsiste();
%>
<jsp:forward page="formRegistrazione.jsp" />

<%
	}
	}
	else{ //campi non validi
		messaggio.campiNonValidi();
	%>
<jsp:forward page="formRegistrazione.jsp" />
<%
	
	}
		
	
%>