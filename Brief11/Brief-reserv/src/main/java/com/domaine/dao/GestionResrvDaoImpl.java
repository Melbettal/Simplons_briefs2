package com.domaine.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domaine.model.GestionResrv;
import com.domaine.model.Utilisateur;
import com.domaine.util.HibernateUtil;

public class GestionResrvDaoImpl implements GestionResrvDao {

	// save reservation
	
		public void saveUser(GestionResrv gestionResrv) {
	        Transaction transaction = null;
	        try {
	        	
	        	Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the user object
	            session.save(gestionResrv);
	            // commit transaction
	            transaction.commit();
	            
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	
	

}
