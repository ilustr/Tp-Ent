package model;

import java.util.Vector;

public abstract class Objet {
	Vector<Groupe> listeGroupes;
	Repertoire repertoireParent;
	
	public Vector<Groupe> getListeGroupes() {
		return listeGroupes;
	}
	public void setListeGroupes(Vector<Groupe> listeGroupes) {
		this.listeGroupes = listeGroupes;
	}
	public Repertoire getRepertoireParent() {
		return repertoireParent;
	}
	public void setRepertoireParent(Repertoire repertoireParent) {
		this.repertoireParent = repertoireParent;
	}
	
	
}
