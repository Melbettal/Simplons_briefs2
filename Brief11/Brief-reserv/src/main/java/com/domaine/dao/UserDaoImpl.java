package com.domaine.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domaine.model.Utilisateur;
import com.domaine.util.HibernateUtil;


public class UserDaoImpl implements UserDao {

	// save client
	
		public void saveUser(Utilisateur utilisateur) {
	        Transaction transaction = null;
	        try {
	        	
	        	Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the user object
	            session.save(utilisateur);
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


