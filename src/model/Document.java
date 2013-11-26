package model;

import model.Objet.sousType;

public class Document extends Objet {

	public Document(String nom, sousType type) {
		super(nom, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + " [Document]";
	}
}
