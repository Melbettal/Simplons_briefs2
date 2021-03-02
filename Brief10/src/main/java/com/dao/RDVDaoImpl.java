package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.RDV;
import com.util.HibernateUtil;


public class RDVDaoImpl implements RDVDao {

	// save client
	
		public void saveRDV(RDV rdv) {
	        Transaction transaction = null;
	        try {
	        	
	        	Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the user object
	            session.save(rdv);
	            // commit transaction
	            transaction.commit();
	            
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

		public void updateRDV(RDV rdv) {
			// TODO Auto-generated method stub
			
		}

		public RDV getRDVById(long id) {
			// TODO Auto-generated method stub
			return null;
		}

		public List<RDV> getAllRDVs() {
			// TODO Auto-generated method stub
			return null;
		}

		public RDV deleteRDV(long id) {
			// TODO Auto-generated method stub
			return null;
		}
}