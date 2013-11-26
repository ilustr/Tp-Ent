package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Groupe;
import model.Objet;
import model.TreeModelPerso;
import model.Utilisateur;
import controller.AjouterObjetAction;
import controller.CreerGroupeAction;
import controller.CreerLinkAction;
import controller.DeleteGroupeAction;
import controller.DeleteObjetAction;
import controller.OpenWindowAction;
import controller.ShowObjetLinkAction;

public class UserView extends JFrame implements Observer {

	private JList<Groupe> jListGroupe;
	private Utilisateur utilisateur;
	private AjouterObjetAction ajouterObjetAction;
	private OpenWindowAction openWindowAction;
	private UserView moi = this;
	private TreeModelPerso treeModelPerso;
	private JTree tree;

	public UserView(final Utilisateur utilisateur) {
		super();

		// Caractéristique générales de la fenetre
		this.utilisateur = utilisateur;
		this.utilisateur.addObserver(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(" Ent - " + utilisateur.getName());
		setSize(600, 200);
		setLayout(new BorderLayout());

		JMenuBar menuBar = new JMenuBar();

		// File Menu, F - Mnemonic
		final JMenu linkMenu = new JMenu("Lien");
		linkMenu.setMnemonic(KeyEvent.VK_F);

		menuBar.add(linkMenu);
		moi.setJMenuBar(menuBar);
		// File->New, N - Mnemonic
		final JMenuItem newMenuItem = new JMenuItem("Nouveau", KeyEvent.VK_N);
		final JMenuItem seeMenuItem = new JMenuItem("Voir", KeyEvent.VK_N);
		newMenuItem.addActionListener(new CreerLinkAction(this));
		seeMenuItem.addActionListener(new ShowObjetLinkAction(this));

		linkMenu.add(newMenuItem);
		linkMenu.add(seeMenuItem);
		// Creation des panel pour le layout
		JPanel pBas = new JPanel();
		pBas.setLayout(new BorderLayout());

		final JPanel pDroit = new JPanel();
		pDroit.setLayout(new BorderLayout());

		// Action pour les boutons
		final JButton buttonAjoutObjet = new JButton("Ajouter Objet");
		ajouterObjetAction = new AjouterObjetAction(this);
		buttonAjoutObjet.addActionListener(ajouterObjetAction);
		buttonAjoutObjet.setEnabled(false);

		JButton buttonAjout = new JButton("Ajouter Groupe");
		buttonAjout.addActionListener(new CreerGroupeAction(this, utilisateur));

		JButton buttonCreerLink = new JButton("Ajouter un lien");
		openWindowAction = new OpenWindowAction(this);
		buttonCreerLink.addActionListener(openWindowAction);

		pBas.add(buttonAjoutObjet, BorderLayout.EAST);
		pBas.add(buttonCreerLink, BorderLayout.CENTER);
		pBas.add(buttonAjout, BorderLayout.WEST);

		tree = new JTree();

		treeModelPerso = new TreeModelPerso();
		tree.setModel(treeModelPerso);
		tree.setSize(150, 150);
		tree.setRootVisible(false);

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
				if (jListGroupe.getSelectedValue() != null) {

					seeMenuItem.setEnabled(true);

					if (!jListGroupe.getSelectedValue().isGestionnaire(
							utilisateur)) {
						newMenuItem.setEnabled(false);
					} else {
						newMenuItem.setEnabled(true);
					}
					ajouterObjetAction.setGroupe(jListGroupe.getSelectedValue());
					openWindowAction.setGroupe(jListGroupe.getSelectedValue());

					buttonAjoutObjet.setEnabled(true);
					((Groupe) jListGroupe.getSelectedValue()).addObserver(moi);

					treeModelPerso.setGroupe((Groupe) jListGroupe
							.getSelectedValue());
					tree.setModel(treeModelPerso);

					tree.revalidate();
					tree.repaint();

				} else {
					buttonAjoutObjet.setEnabled(false);
					seeMenuItem.setEnabled(false);
					newMenuItem.setEnabled(true);
				}
			}
		});

		jListGroupe.addKeyListener(new DeleteGroupeAction(this));
		tree.addKeyListener(new DeleteObjetAction(this));

		JScrollPane scrollPaneGroupe = new JScrollPane();
		scrollPaneGroupe.setViewportView(jListGroupe);

		// Ajout à la frame
		this.add(scrollPaneGroupe, BorderLayout.CENTER);
		this.add(pBas, BorderLayout.SOUTH);
		this.add(pDroit, BorderLayout.EAST);

		show();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.jListGroupe.setListData(this.utilisateur.getListeGroupes());
	}

	public Objet getSelectedObjet() {
		if (tree.getSelectionPath() != null)
			if (tree.getSelectionPath().getLastPathComponent() != null)
				return (Objet) tree.getSelectionPath().getLastPathComponent();
		return null;
	}

	public Component getComponent() {
		return this;
	}

	public Groupe getSelectedGroupe() {
		return jListGroupe.getSelectedValue();
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
