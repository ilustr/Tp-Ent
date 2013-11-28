package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Categorie;
import model.Link;
import model.Objet;
import view.CreerLinkView;

public class AjouterLinkAction implements ActionListener {

	private CreerLinkView linkForm;

	public AjouterLinkAction(CreerLinkView creerLinkView) {
		linkForm = creerLinkView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Categorie categorie = linkForm.GetCategorie();
		
		Objet objet1 = linkForm.getObjet1();
		Objet objet2 = linkForm.getObjet2();

		if(categorie.getInputType() == objet1.getType() && categorie.getOutputType() == objet2.getType())
		{
			Link link = new Link(objet1, objet2, categorie);
	
			linkForm.dispose();
		}
		else
			JOptionPane.showMessageDialog(linkForm, "Types incorrects.", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

}
