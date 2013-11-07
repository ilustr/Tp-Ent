package model;

import java.util.ArrayList;
import java.util.Vector;

public class Groupe {
	private String name;
private ArrayList<Objet> listeObjet = new ArrayList<>();
private ArrayList<Utilisateur> listeMembres = new ArrayList<>();




public Groupe(String name) {
	super();
	this.name = name;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public ArrayList<Objet> getListeObjet() {
	return listeObjet;
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
public boolean addUtilisateur(Utilisateur e) {
	return listeMembres.add(e);
}
public int countUtilisateur() {
	return listeMembres.size();
}
 
 
 

}
