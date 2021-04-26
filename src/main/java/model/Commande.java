package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idc;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "ida")
	private Article article;
	public int getIdc() {
		return idc;
	}
	public void setIdc(int idc) {
		this.idc = idc;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Commande( Client client, Article article) {
		super();
	
		this.client = client;
		this.article = article;
	}
	public Commande() {
		super();
	}
	

}
