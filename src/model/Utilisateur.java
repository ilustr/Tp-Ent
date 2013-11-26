package model;

import java.util.ArrayList;
import java.util.Observable;

public class Utilisateur extends Observable {

	private String name;
	private ArrayList<Groupe> listeGroupes = new ArrayList<>();

	public Utilisateur(String name) {
		this.name = name;
	}

	public Groupe[] getListeGroupes() {
		return listeGroupes.toArray(new Groupe[0]);
	}

	public void addGroupe(Groupe g) {
		listeGroupes.add(g);
		this.setChanged();
		this.notifyObservers();
	}

	public boolean removeGroupe(Groupe groupe) {
		boolean result = listeGroupes.remove(groupe);
		this.setChanged();
		this.notifyObservers();
		return result;
	}

	public void setListeGroupes(ArrayList<Groupe> listeGroupes) {
		this.listeGroupes = listeGroupes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
