package model;

import java.util.ArrayList;
import java.util.Observable;

public abstract class Objet extends Observable {

	public static enum typeObjet {
		Application, Document, Repertoire
	};

	Groupe groupe;
	Repertoire repertoireParent;
	protected String nom;
	private ArrayList<Link> links = new ArrayList<>();

	public Objet(String nom) {
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
			text += link + "\n";
		}
		return text;
	}

}
