/*
	The intro panel displays an image as the splash screen and prompts the user with a start button. The purpose of this class is to greet the user with the name of the
game and the option to start the game. Once the user clicks the "Start Game!" button, the panels switch from the Intro Panel to the Character Create Panel
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class IntroPanel extends JPanel implements ActionListener
{
	private JButton startButton;
	private JLabel backgroundPicture;
	private KingdomController Parent;
	public IntroPanel(KingdomController parent)
	{
		setLayout(null);
		Parent = parent;
		startButton = new JButton("Start!");
		backgroundPicture = new JLabel();
		backgroundPicture.setIcon(new ImageIcon("intro.png"));
		backgroundPicture.setBounds(0,-13,615,555);
		startButton.setBounds(360, 420,200,50);
		add(startButton);
		add(backgroundPicture);
		startButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == startButton)
		{
			//runs the method that swtiches the panels
			Parent.startGame();
		}
	}
}