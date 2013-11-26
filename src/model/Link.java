package model;

public class Link {

	private Objet objetA;
	private Objet objetB;
	private Categorie categorie;

	public Link(Objet objetA, Objet objetB, Categorie categorie) {
		super();
		this.objetA = objetA;
		this.objetB = objetB;
		this.categorie = categorie;

		this.objetA.addLink(this);
		this.objetB.addLink(this);
	}

	public Objet getObjetA() {
		return objetA;
	}

	public void setObjetA(Objet objetA) {
		this.objetA = objetA;
	}

	public Objet getObjetB() {
		return objetB;
	}

	public void setObjetB(Objet objetB) {
		this.objetB = objetB;
	}

	@Override
	public String toString() {
		return objetA + " " + categorie + " " + objetB;
	}

}
