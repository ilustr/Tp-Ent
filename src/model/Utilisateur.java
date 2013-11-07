package model;

import java.util.ArrayList;
import java.util.Vector;

public class Utilisateur {
	
	private String name;
	private ArrayList<Groupe> listeGroupes = new ArrayList<>();

	public Utilisateur(String name) {
		this.name = name;
	}

	public Groupe[] getListeGroupes() {
		return listeGroupes.toArray(new Groupe[0]);
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
