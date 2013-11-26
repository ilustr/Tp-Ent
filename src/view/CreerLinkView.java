package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import model.Categorie;
import model.Groupe;
import model.Objet;
import model.TreeModelPerso;
import controller.AjouterLinkAction;

public class CreerLinkView extends JFrame {

	private TreeModelPerso treeModelPersoLeft;
	private TreeModelPerso treeModelPersoDroit;
	private JComboBox<Categorie> comboBox;
	private JTree treeRight;
	private JTree treeLeft;

	public CreerLinkView(Groupe groupe) {
		super();
		setTitle(" Ent ");
		setSize(300, 150);
		setLayout(new FlowLayout());

		comboBox = new JComboBox<Categorie>();
		for (Categorie s : groupe.getListeLink())
			comboBox.addItem(s);

		JButton button = new JButton("Valider");
		button.addActionListener(new AjouterLinkAction(this));

		treeModelPersoLeft = new TreeModelPerso();
		treeModelPersoLeft.setGroupe(groupe);

		treeLeft = new JTree();
		treeLeft.setModel(treeModelPersoLeft);
		treeLeft.setSize(150, 150);
		treeLeft.setRootVisible(false);
		treeLeft.revalidate();
		treeLeft.repaint();
		final JScrollPane scrollPaneObjetLeft = new JScrollPane(treeLeft);
		scrollPaneObjetLeft.setPreferredSize(new Dimension(200, 100));

		treeModelPersoDroit = new TreeModelPerso();
		treeModelPersoDroit.setGroupe(groupe);
		treeRight = new JTree();
		treeRight.setModel(treeModelPersoDroit);
		treeRight.setSize(150, 150);
		treeRight.setRootVisible(false);
		treeRight.revalidate();
		treeRight.repaint();
		final JScrollPane scrollPaneObjetRight = new JScrollPane(treeRight);
		scrollPaneObjetRight.setPreferredSize(new Dimension(200, 100));

		this.add(scrollPaneObjetLeft);
		this.add(comboBox);
		this.add(scrollPaneObjetRight);
		this.add(button);

		pack();
		show();
	}

	public void closeWindow() {
		this.dispose();
	}

	public Objet getObjet1() {
		if (treeLeft.getSelectionPath() != null)
			if (treeLeft.getSelectionPath().getLastPathComponent() != null)
				return (Objet) treeLeft.getSelectionPath()
						.getLastPathComponent();
		return null;
	}

	public Objet getObjet2() {
		if (treeRight.getSelectionPath() != null)
			if (treeRight.getSelectionPath().getLastPathComponent() != null)
				return (Objet) treeRight.getSelectionPath()
						.getLastPathComponent();
		return null;
	}

	public Categorie GetCategorie() {
		return (Categorie) comboBox.getSelectedItem();
	}

}
