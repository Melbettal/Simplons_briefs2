package com.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Client;
import com.dao.ClientDao;
import com.util.HibernateUtil;


public class ClientDaoImpl implements ClientDao {

	// save client
	
		public void saveClient(Client client) {
	        Transaction transaction = null;
	        try {
	        	
	        	Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the user object
	            session.save(client);
	            // commit transaction
	            transaction.commit();
	            
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
		
		
		public void updateClient(Client client) {
	        Transaction transaction = null;
	        try {
	        	Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // update the user object
	            session.saveOrUpdate(client);
	            // commit transaction
	            transaction.commit();
	            
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	
		public Client getClientById(long id) {
	        Transaction transaction = null;
	        Client client = null;
	        try {
	        	
	        	Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // update the user object
	            client = session.get(Client.class, id);
	            
	            // commit transaction
	            transaction.commit();
	            
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
		return client;
		}
	

		@SuppressWarnings("unchecked")
		public List<Client> getAllClients() {
			Transaction transaction = null;
			List<Client> clients = null;
			try {
    	
				Session session = HibernateUtil.getSessionFactory().openSession();
        // start a transaction
        transaction = session.beginTransaction();
        // update the user object
        clients = session.createQuery("from Client").list();
        
        // commit transaction
        transaction.commit();
        
			} catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
			}
				return clients;
			}

		
		public Client deleteClient(long id) {
			Transaction transaction = null;
			Client client = null;
			try {
    	
				Session session = HibernateUtil.getSessionFactory().openSession();
        // start a transaction
        transaction = session.beginTransaction();
        // update the user object
                
        client = session.get(Client.class, id);
        session.delete(client);
        // commit transaction
        transaction.commit();
        
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
			return client;
		}


		//login check
		public boolean validate(String email, String mdp) {

		Transaction transaction = null;
		Client client = null;
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
        // start a transaction
        transaction = session.beginTransaction();
        // get an user object
        client = (Client) session.createQuery("FROM Client C WHERE C.email = :email").setParameter("email", email)
            .uniqueResult();

        if (client != null && client.getMdp().equals(mdp)) {
            return true;
        }
        // commit transaction
        transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
            transaction.rollback();
        }
			e.printStackTrace();
		}
			return false;
		}


		public  String doHashing(String mdp) {
			try {
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				
				messageDigest.update(mdp.getBytes());
				
				byte[] resultByteArray = messageDigest.digest();
				
				StringBuilder sb = new StringBuilder();
				
				for (byte b : resultByteArray) {
					sb.append(String.format("%02x", b));
				}
				
				return sb.toString();
			}
			catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			return "";
		}
}


