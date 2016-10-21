package it.alfasoft.andrea.dao;




import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateUtil.HibernateUtil;
import it.alfasoft.andrea.UtenteBean;

public class UtenteDao {
	
	// 1- c:create

	public boolean inserisciUtente(UtenteBean u) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.persist(u);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
	
	//2a- r:read con Username 
	public UtenteBean getUtenteConUsername(String username) {
		UtenteBean u=null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query=session.createQuery("from UtenteBean where username=:usernameInserito");
			query.setString("usernameInserito", username);
			u=(UtenteBean) query.uniqueResult();
			tx.commit();
			
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return u;
	}
	
	
		
		//2b- r:read con nome e cognome 
				public UtenteBean getUtenteConNomeCognome(String nome,String cognome) {
					UtenteBean u=null;

					Session session = HibernateUtil.openSession();
					Transaction tx = null;

					try {
						tx = session.getTransaction();
						tx.begin();

						Query query=session.createQuery("from UtenteBean where nome=:nomeInserito and cognome=:cognomeInserito");
						query.setString("nomeInserito", nome);
						query.setString("cognomeInserito", cognome);
						u=(UtenteBean) query.uniqueResult();;
						tx.commit();
						
					} catch (Exception ex) {
						tx.rollback();
					} finally {
						session.close();
					}
					return u;
				}
				
				//2c- r:read con id_utente 
				public UtenteBean getUtenteConId(long id_u) {
					UtenteBean u=null;

					Session session = HibernateUtil.openSession();
					Transaction tx = null;

					try {
						tx = session.getTransaction();
						tx.begin();

						u=session.get(UtenteBean.class, id_u);
						tx.commit();
						
					} catch (Exception ex) {
						tx.rollback();
					} finally {
						session.close();
					}
					return u;
				}
				
				//2d- r:read allUtenti
				
				@SuppressWarnings("unchecked")
				public List<UtenteBean> getTuttiUtenti() {

					List<UtenteBean> u = null;
					
					Session session = HibernateUtil.openSession();
					Transaction tx = null;
						
					try{
						tx = session.getTransaction();
						tx.begin();
							
						// INIZIO ELABORAZIONE DATI
					
						Query query = session.createQuery("from UtenteBean");
						
						 u = (List<UtenteBean>) query.list();
						
						tx.commit(); //INSERISCE NEL DATABASE
							
						
					}catch(Exception e){ 
							
						tx.rollback(); // SE LANCIA ECCEZIONE, CANCELLA TUTTA L'ELABORAZIONE FATTA SOPRA
							
					}finally{
							
						session.close();
							
					}
						
						return u;
						
				}
		
	//3 - u:update
				public boolean aggiornaUtente(UtenteBean u) {
					boolean res = false;

					Session session = HibernateUtil.openSession();
					Transaction tx = null;

					try {
						tx = session.getTransaction();
						tx.begin();

						session.update(u);
						tx.commit();
						res = true;
					} catch (Exception ex) {
						tx.rollback();
					} finally {
						session.close();
					}
					return res;
				}

	// 4 - d:delete
	public boolean eliminaUtente(UtenteBean u) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.delete(u);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

}
