package com.dao;

import java.util.List;

import com.model.Vet;

public interface VetDao {
	
	public void saveVet(Vet vet);
	public void updateVet(Vet vet) ;
	public Vet getVetById(long id);
	public List<Vet> getAllVetts();
	public Vet deleteVet(long id);

}
