package com.dao;

import java.util.List;

import com.model.RDV;

public interface RDVDao {
	
	public void saveRDV(RDV rdv) ;
	public void updateRDV(RDV rdv) ;
	public RDV getRDVById(long id);
	public List<RDV> getAllRDVs();
	public RDV deleteRDV(long id);

}
