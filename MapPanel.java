/*
	This map panel is responsible for handling everything involving the map. It supposed to set images of markets,
wooden mills, Cathedrals and palaces to be visible when you buy them. Each time you buy one of these you gain points.
If you gain enough points then your Name will be changed from 'Sir' to a higher ranking until you become king and win
the game. Points are set in the Player class.

Not Done:
Currently the Player class does not have the appropriate variables and methods to handle the points.
No name upgrades coded in yet.
You cannot buy or sell markets yet.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MapPanel extends JPanel implements ActionListener
{
	private JButton nextButton;
	private JLabel backgroundPicture;
	private JLabel playerLabel = new JLabel();
	private JLabel yearLabel = new JLabel();
	private KingdomController Parent;
	public MapPanel(KingdomController parent)
	{
		setLayout(null);
		Parent = parent;
		nextButton = new JButton("Next");
		backgroundPicture = new JLabel();
		backgroundPicture.setIcon(new ImageIcon("Map.png"));
		backgroundPicture.setBounds(0,-13,615,555);
		nextButton.setBounds(360,420,200,50);
		yearLabel.setBounds(200,-175,400,400);
		playerLabel.setBounds(360,-130,400,400);
		playerLabel.setFont(new Font("Vivaldi", Font.BOLD, 16));
		playerLabel.setForeground(Color.WHITE);
		yearLabel.setFont(new Font("Vivaldi", Font.BOLD, 16));
		yearLabel.setForeground(Color.WHITE);
		add(nextButton);
		add(playerLabel);
		add(yearLabel);
		add(backgroundPicture);
		nextButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == nextButton)
		{
			//runs the method that swtiches the panels
			Parent.investmentPhase();
		}
	}
	public void updateInformation()
	{
		playerLabel.setText(Player.getGender() + Player.getName() + " of " + Player.getRuledLocation());
		yearLabel.setText("Year " + Harvest.getYear());
	}
}