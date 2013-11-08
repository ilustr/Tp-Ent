package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Groupe;
import model.Objet;
import model.Portail;
import model.TreeModelPerso;
import model.Utilisateur;
import controller.AjouterObjetAction;
import controller.CreerGroupeAction;

public class UserView extends JFrame implements Observer {

	private JList<Groupe> jListGroupe;
	private JList<Objet> jListObjet;
	private Utilisateur utilisateur;
	private AjouterObjetAction ajouterObjetAction;
	private UserView moi = this;
	private TreeModelPerso treeModelPerso;

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

		final JPanel pDroit = new JPanel();
		pDroit.setLayout(new BorderLayout());

		// Action pour les boutons
		final JButton buttonAjoutObjet = new JButton("Ajouter Objet");
		ajouterObjetAction = new AjouterObjetAction();
		buttonAjoutObjet.addActionListener(ajouterObjetAction);
		buttonAjoutObjet.setEnabled(false);
		pBas.add(buttonAjoutObjet, BorderLayout.WEST);
		
		JButton buttonAjout = new JButton("Ajouter Groupe");
		buttonAjout.addActionListener(new CreerGroupeAction(this, utilisateur));
		pBas.add(buttonAjout, BorderLayout.EAST);
		

		
		
		
		// Tree des objets
		final JTree tree = new JTree();
		
		treeModelPerso = new TreeModelPerso();
		tree.setModel(treeModelPerso);
		tree.setSize(150, 150);
		final JScrollPane scrollPaneObjet = new JScrollPane(tree);
		scrollPaneObjet.setPreferredSize(new Dimension(200, 100));
		pDroit.add(scrollPaneObjet, BorderLayout.CENTER);
		

		// Liste des groupes
		Groupe[] groupes = utilisateur.getListeGroupes();
		jListGroupe = new JList<Groupe>(groupes);
		jListGroupe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListGroupe.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (jListGroupe.getSelectedValue() != null){
					buttonAjoutObjet.setEnabled(false);
					((Groupe) jListGroupe.getSelectedValue()).addObserver(moi);
					ajouterObjetAction.setGroupe(jListGroupe.getSelectedValue());	
					treeModelPerso.setGroupe((Groupe) jListGroupe.getSelectedValue());
					tree.setModel(treeModelPerso);
					tree.revalidate();
					tree.repaint();
				}
				else
					jListObjet.setListData(new Objet[0]);
					buttonAjoutObjet.setEnabled(true);
			}
		});
		JScrollPane scrollPaneGroupe = new JScrollPane();
		scrollPaneGroupe.setViewportView(jListGroupe);

		// Ajout à la frame
		this.add(scrollPaneGroupe, BorderLayout.CENTER);
		this.add(pBas, BorderLayout.SOUTH);
		this.add(pDroit, BorderLayout.EAST);
		// we was here
		
		
		
		
		// TODO penser à regarder si on est sur un repertoire pour l'ajout de nouveaux Objet
		
		
		
		show();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.jListGroupe.setListData(this.utilisateur.getListeGroupes());
	}

}
