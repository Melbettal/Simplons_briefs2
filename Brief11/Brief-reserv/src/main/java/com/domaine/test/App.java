package com.domaine.test;


import java.time.LocalDateTime;

import com.domaine.dao.GestionResrvDaoImpl;
import com.domaine.dao.UserDaoImpl;
import com.domaine.model.GestionResrv;
import com.domaine.model.Utilisateur;


public class App {


		public static void main(String[] args) {
			
			UserDaoImpl userDao = new UserDaoImpl();
			//test de save client
			Utilisateur user = new Utilisateur("meryame", "meryame@gmail.com", "admin123", "encadrant");
			userDao.saveUser(user);
			LocalDateTime date = LocalDateTime.now();
			
			GestionResrvDaoImpl gresrv = new GestionResrvDaoImpl();
			//test de save client
			GestionResrv resr = new GestionResrv(25, date);
			gresrv.saveUser(resr);
			
			/*UserDaoImpl userDao = new UserDaoImpl();
			//test de save client
			Utilisateur user = new Utilisateur("meryame", "meryame@gmail.com", "admin123", "encadrant");
			userDao.saveUser(user);*/
			
			
		}
}