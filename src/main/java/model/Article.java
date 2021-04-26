package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Article {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
int ida;
String ref,titre,auteur,img;
int prix;
@ManyToOne
@JoinColumn(name = "refcat")
private Categorie cat;

public int getIda() {
	return ida;
}
public void setIda(int ida) {
	this.ida = ida;
}
public String getRef() {
	return ref;
}
public void setRef(String ref) {
	this.ref = ref;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getAuteur() {
	return auteur;
}
public void setAuteur(String auteur) {
	this.auteur = auteur;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public int getPrix() {
	return prix;
}
public void setPrix(int prix) {
	this.prix = prix;
}
public Categorie getCat() {
	return cat;
}
public void setCat(Categorie cat) {
	this.cat = cat;
}



}
