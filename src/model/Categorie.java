package model;

import model.Objet.natureObjet;

public class Categorie {
	private String name;
	private String nameInverse;

	private Objet.natureObjet inputType;
	private Objet.natureObjet outputType;

	public Categorie(String name, String nameInverse, natureObjet inputType,
			natureObjet outputType) {
		super();
		this.name = name;
		this.nameInverse = nameInverse;
		this.inputType = inputType;
		this.outputType = outputType;
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

	public Objet.natureObjet getInputType() {
		return inputType;
	}

	public void setInputType(Objet.natureObjet inputType) {
		this.inputType = inputType;
	}

	public Objet.natureObjet getOutputType() {
		return outputType;
	}

	public void setOutputType(Objet.natureObjet outputType) {
		this.outputType = outputType;
	}

	public String getNameInverse() {
		return nameInverse;
	}

	public void setNameInverse(String nameInverse) {
		this.nameInverse = nameInverse;
	}

}
