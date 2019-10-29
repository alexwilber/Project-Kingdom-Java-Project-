/*
	The serf report panel is meant to show the number of serfs you gained, the number of serfs that haved died and
the number of clergymen and merchants you have gained. Currently serfs are not coded into the game but if they were
they would be used to determine land price, grain price, and the amount of money you make from them.

Currently not working:
Serfs
Clergymen and Merchants
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SerfPanel extends JPanel implements ActionListener
{
	private int numSerfsDead = 0;
	private int numSerfsGained = 0;
	private JButton nextButton;
	private JLabel backgroundPicture;
	private JLabel playerLabel = new JLabel();
	private JLabel yearLabel = new JLabel();
	private JLabel serfLabel = new JLabel();
	private JLabel serfsDead = new JLabel();
	private JLabel serfsGained = new JLabel();
	private KingdomController Parent;
	public SerfPanel(KingdomController parent)
	{
		setLayout(null);
		Parent = parent;
		nextButton = new JButton("Next");
		backgroundPicture = new JLabel();
		backgroundPicture.setIcon(new ImageIcon("SerfReport.png"));
		backgroundPicture.setBounds(0,-13,615,555);
		nextButton.setBounds(360,420,200,50);
		playerLabel.setBounds(168,-155,400,400);
		serfLabel.setBounds(130,150,400,400);
		yearLabel.setBounds(200,-175,400,400);
		serfsDead.setBounds(130,50,400,400);
		serfsGained.setBounds(330,50,400,400);
		playerLabel.setFont(new Font("Vivaldi", Font.BOLD, 16));
		playerLabel.setForeground(Color.BLACK);
		serfLabel.setFont(new Font("Vivaldi", Font.BOLD, 20));
		serfLabel.setForeground(Color.BLACK);
		serfsDead.setFont(new Font("Vivaldi", Font.BOLD, 20));
		serfsDead.setForeground(Color.BLACK);
		serfsGained.setFont(new Font("Vivaldi", Font.BOLD, 20));
		serfsGained.setForeground(Color.BLACK);
		yearLabel.setFont(new Font("Vivaldi", Font.BOLD, 16));
		yearLabel.setForeground(Color.BLACK);
		serfsDead.setText("Serfs Dead: " + numSerfsDead);
		serfsGained.setText("Serfs Gained: " + numSerfsDead);
		add(nextButton);
		add(serfLabel);
		add(serfsDead);
		add(serfsGained);
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
			Parent.taxPhase();
		}
	}
	//Updates Information so it can be displayed properly.
	public void updateInformation()
	{
		playerLabel.setText(Player.getGender() + Player.getName() + " of " + Player.getRuledLocation());
		serfLabel.setText("Total Serfs: " + Harvest.getSerfs());
		yearLabel.setText("Year " + Harvest.getYear());
	}
}