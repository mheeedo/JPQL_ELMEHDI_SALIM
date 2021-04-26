package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
int refcat;
String cat;
public int getRefcat() {
	return refcat;
}
public void setRefcat(int refcat) {
	this.refcat = refcat;
}
public String getCat() {
	return cat;
}
public void setCat(String cat) {
	this.cat = cat;
}
}
