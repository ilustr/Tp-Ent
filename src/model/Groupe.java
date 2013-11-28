package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class Groupe extends Observable implements Observer {
	private String name;
	private ArrayList<Objet> listeObjet = new ArrayList<>();
	private ArrayList<Categorie> listeCategories = new ArrayList<>();

	public boolean addCategorie(Categorie categorie) {
		return listeCategories.add(categorie);
	}

	public boolean removeCategorie(Categorie categorie) {
		return listeCategories.remove(categorie);
	}

	public ArrayList<Categorie> getListeLink() {
		return listeCategories;
	}

	private ArrayList<Utilisateur> listeMembres = new ArrayList<>();

	public Groupe(String name) {
		super();
		this.name = name;
	}

	public abstract boolean isGestionnaire(Utilisateur user);

	public abstract ArrayList<Utilisateur> getListeGestionnaire();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int indexOfObjet(Object o) {
		return listeObjet.indexOf(o);
	}

	public Objet[] getListeObjet() {
		return listeObjet.toArray(new Objet[0]);
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

	public Objet getObjet(int index) {
		return listeObjet.get(index);
	}

	public int countObjet() {
		return listeObjet.size();
	}

	public void addObjet(Objet e) {
		e.setGroupe(this);
		listeObjet.add(e);
		e.addObserver(this);
		this.setChanged();
		this.notifyObservers();
	}

	public void setListeObjet(ArrayList<Objet> listeObjet) {
		this.listeObjet = listeObjet;
	}

	public ArrayList<Utilisateur> getListeMembres() {
		return listeMembres;
	}

	public void setListeMembres(ArrayList<Utilisateur> listeMembres) {
		this.listeMembres = listeMembres;
	}

	/**
	 * Methode pour ajouter un utilisateur à un groupe. Ce groupe est
	 * automatiquement ajouté à la liste des groupes de l'utilisateur
	 * 
	 * @param e
	 *            : Utilisateur à ajouter
	 * @return
	 */
	public boolean addUtilisateur(Utilisateur e) {
		e.addGroupe(this);
		return listeMembres.add(e);
	}

	public int countUtilisateur() {
		return listeMembres.size();
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setChanged();
		this.notifyObservers();
	}

}
