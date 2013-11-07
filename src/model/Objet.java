package model;

import java.util.Vector;

public abstract class Objet {
	Groupe groupe;
	Repertoire repertoireParent;
	protected String nom;
	
	public Objet(String nom){
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return this.nom;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Repertoire getRepertoireParent() {
		return repertoireParent;
	}
	public void setRepertoireParent(Repertoire repertoireParent) {
		this.repertoireParent = repertoireParent;
	}
	
	
}
