package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Code;
import controller.CodeListener;

/**
 * The pane at the bottom of the Title Screen for starting the game, exiting,
 * or loading in the tutorial.
 * 
 * @author Devon Pirestni
 * @author Andre Green
 * @author Miguel Fuentes
 */
public class TitleNavigation extends JPanel implements ActionListener {

	private JButton start;
	private JButton exit;
	private JButton tutorial;
	private CodeListener codeListener;
	private Font font;

	/**
	 * Constructor for TitleNavigation
	 * 
	 * @param cl The CodeListener
	 * @param width The width of the pane
	 */
	public TitleNavigation(CodeListener cl, int width) {
		codeListener = cl;
		font = new Font("Arial", Font.PLAIN, width / 40);

		// This moves you to the EstuaryModel
		start = new JButton("Start");
		start.setFont(font);
		start.addActionListener(this);

		// This exits the game
		exit = new JButton("Exit");
		exit.setFont(font);
		exit.addActionListener(this);

		// Starts the tutorial
		tutorial = new JButton("How To Play");
		tutorial.setFont(font);
		tutorial.addActionListener(this);

		setLayout(new FlowLayout());

		add(start);
		add(exit);
		add(tutorial);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent buttonPress) {
		JButton pressed = (JButton) buttonPress.getSource();
		if (pressed == start) {
			codeListener.codeEmitted(Code.NEXT);
		} else if (pressed == exit) {
			codeListener.codeEmitted(Code.EXIT);
		} else if (pressed == tutorial) {
			codeListener.codeEmitted(Code.TUTORIAL);
		}
	}

}
