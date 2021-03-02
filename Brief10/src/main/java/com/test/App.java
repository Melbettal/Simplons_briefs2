package com.test;


import java.time.LocalDateTime;

import com.dao.ClientDao;
import com.dao.ClientDaoImpl;
import com.dao.FAQDaoImpl;
import com.dao.RDVDaoImpl;
import com.model.Client;
import com.model.FAQ;
import com.model.RDV;
import com.model.Vet;

public class App {


		public static void main(String[] args) {
			
			FAQDaoImpl FAQDao = new FAQDaoImpl();
			//test de save client
			FAQ faq = new FAQ(3, "question", "reponse");
			FAQDao.saveFAQ(faq);
			
			/*Vet vet = new Vet("vet", "vet@gmail.com", "123vet");
			clientDao.saveVet(vet);*/
			
			//test pour update
			/*vet.setNom_complet("Elbett");
			vetDao.updateVet(vet);
			
			//test get client by id
			Vet vet2 = vetDao.getVetById(vet.getId());
			
			//test get all client
			List<Vet> vets = vetDao.getAllVets();
			vets.forEach(vet1 -> System.out.println(vet1.getId()));
			
			//test delete
			vetDao.deleteVet(vet.getId());*/
		}
}