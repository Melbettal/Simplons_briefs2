package dao;

import com.entities.Produit;
import com.entities.User;
import com.entities.Vote;
import com.service.ContrVote;

public class Test {
	
	public static void main(String[] args) {
		
		ContrVote cv = new ContrVote();
		Vote v = new Vote(null,1,1);
		cv.saveVote(v);
		
		System.out.println(cv.checkVote(v));
		
	}

}
