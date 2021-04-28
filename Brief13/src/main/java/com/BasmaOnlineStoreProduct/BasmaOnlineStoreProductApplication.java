package com.BasmaOnlineStoreProduct;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.BasmaOnlineStoreProduct.beans.Categorie;
import com.BasmaOnlineStoreProduct.beans.Produit;
import com.BasmaOnlineStoreProduct.repository.CategorieRepository;
import com.BasmaOnlineStoreProduct.repository.ProduitRepository;

@SpringBootApplication
public class BasmaOnlineStoreProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasmaOnlineStoreProductApplication.class, args);
	}
	
	/*@Bean
    CommandLineRunner start(ProduitRepository pr,    CategorieRepository cr)
    {
        return args->{
            Categorie category = cr.save(new Categorie(null, "plantes", "img", new ArrayList<Produit>()));
            ArrayList<String> listImage = new ArrayList<String>();
            listImage.add("img1");
            listImage.add("img2");
            listImage.add("img3");
            listImage.add("img4");
        pr.save(new Produit(null, "cactus", Math.random()*100, 20, listImage, category));

        };*/
    }


