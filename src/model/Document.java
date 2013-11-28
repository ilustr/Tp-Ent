package model;

import model.Objet.natureObjet;

public class Document extends Objet {

	public Document(String nom, natureObjet type) {
		super(nom, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + " [Document]";
	}
}
