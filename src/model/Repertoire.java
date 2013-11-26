package model;

import java.util.ArrayList;

public class Repertoire extends Objet {

	private ArrayList<Objet> listeObjet = new ArrayList<Objet>();

	public void addObjet(Objet e) {
		e.setRepertoireParent(this);
		listeObjet.add(e);

		this.setChanged();
		this.notifyObservers();
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

	public void removeObjet(Objet objet) {

		if (listeObjet.contains(objet)) {
			for (Link l : objet.getLinks()) {
				l.getObjetA().removeLink(l);
				l.getObjetB().removeLink(l);
			}
			listeObjet.remove(objet);
			this.setChanged();
			this.notifyObservers();
		} else {
			for (Objet nObjet : listeObjet) {
				if (nObjet instanceof Repertoire)
					((Repertoire) nObjet).removeObjet(objet);
			}
		}
	}

}
