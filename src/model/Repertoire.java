package model;

import java.util.ArrayList;

public class Repertoire extends Objet {

	private ArrayList<Objet> listeObjet = new ArrayList<Objet>();
	
	public boolean addObjet(Objet e) {
		e.setRepertoireParent(this);
		return listeObjet.add(e);
	}

	public int indexOfObjet(Object o) {
		return listeObjet.indexOf(o);
	}

	public Objet getObjet(int index) {
		return listeObjet.get(index);
	}

	public int countObjet() {
		return listeObjet.size();
	}

	public ArrayList<Objet> getListeObjet() {
		return listeObjet;
	}

	public void setListeObjet(ArrayList<Objet> listeObjet) {
		this.listeObjet = listeObjet;
	}

	public Repertoire(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + " [Repertoire]";
	}
}
