package model;

public class GroupePersonnel extends Groupe{

	private Utilisateur gestionnaire;
	
	public GroupePersonnel(String name, Utilisateur utilisateurJJacques) {
		super(name);
		utilisateurJJacques.addGroupe(this);
		this.gestionnaire = utilisateurJJacques;
	}

	
}
