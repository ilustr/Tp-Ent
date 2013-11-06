package model;

import java.util.Vector;

public class Groupe {
 Vector<Objet> listeObjet;
 Vector<Utilisateur> listeMembres;
 Vector<Utilisateur> listeGestionnaire;
 
public Vector<Objet> getListeObjet() {
	return listeObjet;
}
public void setListeObjet(Vector<Objet> listeObjet) {
	this.listeObjet = listeObjet;
}
public Vector<Utilisateur> getListeMembres() {
	return listeMembres;
}
public void setListeMembres(Vector<Utilisateur> listeMembres) {
	this.listeMembres = listeMembres;
}
public Vector<Utilisateur> getListeGestionnaire() {
	return listeGestionnaire;
}
public void setListeGestionnaire(Vector<Utilisateur> listeGestionnaire) {
	this.listeGestionnaire = listeGestionnaire;
}
 
}
