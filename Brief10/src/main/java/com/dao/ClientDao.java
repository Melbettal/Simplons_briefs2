package com.dao;

import java.util.List;

import com.model.Client;

public interface ClientDao {
	
	public void saveClient(Client client) ;
	public void updateClient(Client client) ;
	public Client getClientById(long id);
	public List<Client> getAllClients();
	public Client deleteClient(long id);
	public boolean validate(String email, String mdp);
	public String doHashing(String mdp);

}
