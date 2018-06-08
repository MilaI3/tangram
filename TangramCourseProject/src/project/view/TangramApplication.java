package project.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;

import project.model.Model;

/**
 * GUI frame converted to be amenable to EBC requirements.
 */

public class TangramApplication extends JFrame {

	JPanel contentPane;
	
	/** Represents model for application domain. */
	Model model;
	
	/** View for Tangram pieces. */
	PiecesView piecesView;
	
	public PiecesView getPiecesView() { return piecesView; }

	/**
	 * Create the frame.
	 */
	public TangramApplication(Model m) {
		this.model = m;
		
		setTitle("Tangram Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 479);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTangram = new JMenu("Tangram");
		menuBar.add(mnTangram);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnTangram.add(mntmQuit);
		
		JMenu mnPuzzle = new JMenu("Puzzle");
		menuBar.add(mnPuzzle);
		
		JMenuItem mntmResetPuzzle = new JMenuItem("Reset Puzzle");
		mntmResetPuzzle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mnPuzzle.add(mntmResetPuzzle);
		
		JMenuItem mntmSelectPuzzle = new JMenuItem("Select Puzzle...");
		mntmSelectPuzzle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnPuzzle.add(mntmSelectPuzzle);
		
		JMenuItem mntmStorePuzzle = new JMenuItem("Store Puzzle...");
		mntmStorePuzzle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnPuzzle.add(mntmStorePuzzle);
		
		JMenuItem mntmCreatePuzzle = new JMenuItem("Create Puzzle...");
		mntmCreatePuzzle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mnPuzzle.add(mntmCreatePuzzle);
		
		JMenu mnAbout = new JMenu("Help");
		menuBar.add(mnAbout);
		
		JMenuItem mntmAboutTangram = new JMenuItem("About Tangram");
		mntmAboutTangram.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnAbout.add(mntmAboutTangram);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JScrollPane tangramSetPane = new JScrollPane();
		
		// Install PiecesView in the left scrolling panel.
		piecesView = new PiecesView(model);
		tangramSetPane.setViewportView(piecesView);

		JScrollPane solutionSetPane = new JScrollPane(); 

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tangramSetPane, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(solutionSetPane, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(solutionSetPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
						.addComponent(tangramSetPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	// Only here for WindowBuilder
	TangramApplication() {
		this (Model.defaultModel());
	}
}