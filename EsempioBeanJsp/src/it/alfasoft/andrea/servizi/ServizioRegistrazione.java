package it.alfasoft.andrea.servizi;

import utility.CodificationOfPassword;
import it.alfasoft.andrea.UtenteBean;
import it.alfasoft.andrea.dao.UtenteDao;

public class ServizioRegistrazione {
	
	public boolean registraUtente (UtenteBean u) {
		UtenteDao uDao=new UtenteDao();
		return uDao.inserisciUtente(u);
	}
	
		
	public String convertiPassword(String pass){
		return CodificationOfPassword.codificatePass(pass);
	}
	
	public UtenteBean getUtente(String username){
		UtenteDao uDao=new UtenteDao();
		UtenteBean u=uDao.getUtenteConUsername(username);
		return u;
	}
	
	public UtenteBean getUtenteNomeCognome(String nome, String cognome){
		UtenteDao uDao=new UtenteDao();
		UtenteBean u=uDao.getUtenteConNomeCognome(nome, cognome);
		return u;
	}
	
	

}
