package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class Objet extends ObjetPrototype {

	public static enum natureObjet {
		Correction, TP, TD, Cours, Matiére, Conteneur, Divers
	};

	private ObservablePerso observer;
	Groupe groupe;
	Repertoire repertoireParent;
	natureObjet type;
	protected String nom;
	private ArrayList<Link> links = new ArrayList<>();

	public Objet(String nom, natureObjet type) {
		this.nom = nom;
		this.type = type;
		this.observer = new ObservablePerso();
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
	
	public natureObjet getType() {
		return type;
	}

	public void setType(natureObjet type) {
		this.type = type;
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

	public boolean addLink(Link e) {
		return links.add(e);
	}

	public boolean removeLink(Object o) {
		return links.remove(o);
	}

	public Link[] getLinks() {
		return links.toArray(new Link[0]);
	}

	public String getLinkAsText() {
		String text = "";

		for (Link link : links) {
			text += link.toString(this) + "\n";
		}
		return text;
	}
	
	public ObservablePerso getObserver() {
		return observer;
	}
	
	public void addObserver(Observer o){
		getObserver().addObserver(o);
	}
}
