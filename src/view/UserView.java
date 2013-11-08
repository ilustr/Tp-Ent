package view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Groupe;
import model.Objet;
import model.Utilisateur;
import controller.CreerGroupeAction;

public class UserView extends JFrame implements Observer {

	private JList<Groupe> jListGroupe;
	private JList<Objet> jListObjet;
	private Utilisateur utilisateur;

	public UserView(Utilisateur utilisateur) {
		super();

		// Caractéristique générales de la fenetre
		this.utilisateur = utilisateur;
		this.utilisateur.addObserver(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(" Ent - " + utilisateur.getName());
		setSize(600, 200);
		setLayout(new BorderLayout());

		// Creation des panel pour le layout
		JPanel pBas = new JPanel();
		pBas.setLayout(new BorderLayout());

		JPanel pDroit = new JPanel();
		pDroit.setLayout(new BorderLayout());

		// Action pour le bouton
		JButton buttonAjout = new JButton("Ajouter");
		buttonAjout.addActionListener(new CreerGroupeAction(this, utilisateur));
		pBas.add(buttonAjout, BorderLayout.CENTER);

		// Liste des objets
		Objet[] objets = new Objet[0];
		jListObjet = new JList<Objet>(objets);
		jListObjet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPaneObjet = new JScrollPane();
		scrollPaneObjet.setViewportView(jListObjet);
		pDroit.add(scrollPaneObjet, BorderLayout.CENTER);

		// Liste des groupes
		Groupe[] groupes = utilisateur.getListeGroupes();
		jListGroupe = new JList<Groupe>(groupes);
		jListGroupe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListGroupe.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (jListGroupe.getSelectedValue() != null)
					jListObjet.setListData(jListGroupe.getSelectedValue()
							.getListeObjet());
				else
					jListObjet.setListData(new Objet[0]);
			}
		});
		JScrollPane scrollPaneGroupe = new JScrollPane();
		scrollPaneGroupe.setViewportView(jListGroupe);

		// Ajout à la frame
		this.add(scrollPaneGroupe, BorderLayout.CENTER);
		this.add(pBas, BorderLayout.SOUTH);
		this.add(pDroit, BorderLayout.EAST);
		// we was here

		show();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.jListGroupe.setListData(this.utilisateur.getListeGroupes());
	}

}
