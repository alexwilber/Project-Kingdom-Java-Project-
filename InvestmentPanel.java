/*
	This class handles all of the Cathedrals, Palaces, Wooden Mills, Markets and Soilders owned.
It displays a price for each one with a button to purchase that item. It also displays your
treasury amount. Currently none of this is implemented but this is what the class is supposed to do
the next button will also loop back to the Harvest Phase which does work currently.
*/



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InvestmentPanel extends JPanel implements ActionListener
{
	private JButton nextButton;
	private JLabel backgroundPicture;
	private JLabel playerLabel = new JLabel();
	private JLabel yearLabel = new JLabel();
	private KingdomController Parent;
	public InvestmentPanel(KingdomController parent)
	{
		setLayout(null);
		Parent = parent;
		nextButton = new JButton("Next");
		backgroundPicture = new JLabel();
		backgroundPicture.setIcon(new ImageIcon("Investments.png"));
		backgroundPicture.setBounds(0,-13,615,555);
		nextButton.setBounds(360,420,200,50);
		yearLabel.setBounds(200,-175,400,400);
		playerLabel.setBounds(200,-60,400,400);
		playerLabel.setFont(new Font("Vivaldi", Font.BOLD, 16));
		playerLabel.setForeground(Color.BLACK);
		yearLabel.setFont(new Font("Vivaldi", Font.BOLD, 16));
		yearLabel.setForeground(Color.BLACK);
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
			Parent.loopPhase();
			Harvest.addYear();
			yearLabel.setText("Year " + Harvest.getYear());
		}
	}
	//updates Information so it can be displayed properly.
	public void updateInformation()
	{
		playerLabel.setText(Player.getGender() + Player.getName() + " of " + Player.getRuledLocation());
		yearLabel.setText("Year " + Harvest.getYear());
	}
}