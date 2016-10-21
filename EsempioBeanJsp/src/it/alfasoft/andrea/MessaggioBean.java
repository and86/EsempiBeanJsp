package it.alfasoft.andrea;

import java.io.Serializable;

public class MessaggioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String messaggio="";

	
	public MessaggioBean() {

	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
	public void passwordErrata(){
		this.messaggio = "La username e/o la password sono errati!";
	}
	
	public void utenteEsiste(){
		this.messaggio = "Utente già registrato!";
	}
	
	public void usernameEsiste(){
		this.messaggio = "Username non disponibile!";
	}
	
	public void campiNonValidi(){
		this.messaggio = "Campi non validi!";
	}

}
