package com.domaine.dao;


import java.time.LocalDateTime;

import com.domaine.model.Admin;


public class App {


		public static void main(String[] args) {
			
			UserDaoImpl AdminDao = new UserDaoImpl();
			//test de save client
			Admin admin = new Admin("meryame", "meryame@gmail.com", "admin123", "encadrant");
			AdminDao.saveAdmin(admin);
			
			
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