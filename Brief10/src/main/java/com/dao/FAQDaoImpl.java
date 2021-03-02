package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.FAQ;
import com.model.Vet;
import com.util.HibernateUtil;


public class FAQDaoImpl implements FAQDao {

	public void saveFAQ(FAQ faq) {
        Transaction transaction = null;
        try {
        	
        	Session session = HibernateUtil.getSessionFactory().openSession();

        	
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            session.save(faq);
            // commit transaction
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


	public void updateFAQ(FAQ faq) {
		// TODO Auto-generated method stub
		
	}

	public FAQ getFAQById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<FAQ> getAllFAQs() {
		// TODO Auto-generated method stub
		return null;
	}

	public FAQ deleteFAQ(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}