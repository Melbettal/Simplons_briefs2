package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Vet;
import com.util.HibernateUtil;

import com.dao.VetDao;

public class VetDaoImpl implements VetDao {

	public void saveVet(Vet vet) {
        Transaction transaction = null;
        try {
        	
        	Session session = HibernateUtil.getSessionFactory().openSession();

        	
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            session.save(vet);
            // commit transaction
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	
	public void updateVet(Vet vet) {
        Transaction transaction = null;
        try {
        	
        	Session session = HibernateUtil.getSessionFactory().openSession();

            // start a transaction
            transaction = session.beginTransaction();
            // update the user object
            session.saveOrUpdate(vet);
            // commit transaction
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	public Vet getVetById(long id) {
        Transaction transaction = null;
        Vet vet = null;
        try {
        	Session session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // update the user object
            vet = session.get(Vet.class, id);
            
            // commit transaction
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	return vet;
	}


@SuppressWarnings("unchecked")
public List<Vet> getAllVets() {
Transaction transaction = null;
List<Vet> vets = null;
try {
	
	Session session = HibernateUtil.getSessionFactory().openSession();

	
    // start a transaction
    transaction = session.beginTransaction();
    // update the user object
    vets = session.createQuery("from Vet").list();
    
    // commit transaction
    transaction.commit();
    
} catch (Exception e) {
    if (transaction != null) {
        transaction.rollback();
    }
    e.printStackTrace();
}
return vets;
}

public Vet deleteVet(long id) {
Transaction transaction = null;
Vet vet = null;
try {
	
	Session session = HibernateUtil.getSessionFactory().openSession();

	
    // start a transaction
    transaction = session.beginTransaction();
    // update the user object
            
    vet = session.get(Vet.class, id);
    session.delete(vet);
    // commit transaction
    transaction.commit();
    
} catch (Exception e) {
    if (transaction != null) {
        transaction.rollback();
    }
    e.printStackTrace();
}
return vet;
}


public List<Vet> getAllVetts() {
	// TODO Auto-generated method stub
	return null;
}


}
