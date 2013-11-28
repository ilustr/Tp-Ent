package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Categorie;
import view.CreerCategorieView;
import view.UserView;

public class CreerCategorieAction implements ActionListener {

	private CreerCategorieView linkView;

	public CreerCategorieAction(CreerCategorieView creerAbstractLinkView) {
		this.linkView = creerAbstractLinkView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Categorie categorie = new Categorie(linkView.getNomLink(),linkView.getNomLinkInverse(), linkView.getListeTypeInput(), linkView.getListeTypeOutput());
		
		linkView.getGroupe().addCategorie(categorie);
		
		linkView.dispose();
	}

}
