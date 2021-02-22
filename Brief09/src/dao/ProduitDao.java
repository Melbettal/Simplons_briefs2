package dao;

import java.util.List;

import com.entities.Produit;

public interface ProduitDao {


	Produit update(Produit p);
	List<Produit> search(String s);
	Produit save(Produit p);
	Produit getProduit(int id);
	Produit deleteProduit(int id);

}
