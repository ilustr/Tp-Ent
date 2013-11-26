package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		Objet objet1 = linkForm.getObjet1();
		Objet objet2 = linkForm.getObjet2();

		Link link = new Link(objet1, objet2, linkForm.GetCategorie());

		linkForm.dispose();
	}

}
