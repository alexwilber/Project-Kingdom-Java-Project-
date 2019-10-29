/*
	This panel is meant to display the Customs Duty, Sales Tax, Wealth Tax, and set the rate for each, which will increase
your florins in each phase accordingly. You can also set the Customs Duty, Sales Tax, Wealth Tax,to 1 of 4 options using a comobo box to :Very fair which will give you
-200f each stage or Moderate which will give you 100f each phase HARSH will give you 400f each phase. It will then
display the tax revenue of each phase. the fairer the tax, the more serfs that will migrate to your land.

Not Finished:
Customs Duty, Sales Tax, Wealth Tax
Justice level

*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaxPanel extends JPanel implements ActionListener
{
	private JButton nextButton;
	private JLabel backgroundPicture;
	private JLabel playerLabel = new JLabel();
	private JLabel yearLabel = new JLabel();
	private KingdomController Parent;
	public TaxPanel(KingdomController parent)
	{
		setLayout(null);
		Parent = parent;
		nextButton = new JButton("Next");
		backgroundPicture = new JLabel();
		backgroundPicture.setIcon(new ImageIcon("Taxbg.png"));
		backgroundPicture.setBounds(0,-13,615,555);
		nextButton.setBounds(360,420,200,50);
		playerLabel.setBounds(200,-156,400,400);
		yearLabel.setBounds(200,-175,400,400);
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
			Parent.mapPhase();
		}
	}
	//updates Information so it can be displayed properly.
	public void updateInformation()
	{
		playerLabel.setText(Player.getGender() + Player.getName() + " of " + Player.getRuledLocation());
		yearLabel.setText("Year " + Harvest.getYear());
	}
}