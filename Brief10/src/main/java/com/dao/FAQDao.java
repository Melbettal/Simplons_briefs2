package com.dao;

import java.util.List;

import com.model.FAQ;

public interface FAQDao {
	
	public void saveFAQ(FAQ faq);
	public void updateFAQ(FAQ faq) ;
	public FAQ getFAQById(long id);
	public List<FAQ> getAllFAQs();
	public FAQ deleteFAQ(long id);

}
