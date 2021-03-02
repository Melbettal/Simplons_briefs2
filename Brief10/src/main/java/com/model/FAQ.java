package com.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FAQ")
public class FAQ {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_faq")
	private int id_faq;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "reponse")
	private String reponse;

	/*@ManyToOne
	@JoinColumn(name = "id")
    private User user;
	*/
		
	public FAQ(int id_faq, String question, String reponse) {
		super();
		this.id_faq = id_faq;
		this.question = question;
		this.reponse = reponse;
	}


	public int getId_faq() {
		return id_faq;
	}


	public void setId_faq(int id_faq) {
		this.id_faq = id_faq;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getReponse() {
		return reponse;
	}


	public void setReponse(String reponse) {
		this.reponse = reponse;
	}


}
