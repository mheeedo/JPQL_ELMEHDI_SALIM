package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String email,nom,prenom,adresse,ville;
	int codepostal;
	long mdp;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}

public long getMdp() {
	return mdp;
}
public void setMdp(long mdp) {
	this.mdp = mdp;
}

public int getCodepostal() {
	return codepostal;
}
public void setCodepostal(int codepostal) {
	this.codepostal = codepostal;
}
public Client( String email, String nom, String prenom, String adresse, int codepostal, String ville,  long mdp) {
	super();
	
	this.email = email;
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
	this.ville = ville;
	this.codepostal = codepostal;
	this.mdp = mdp;
}
public Client() {
	super();
}
}
