/*This class is responsible for releasing grain to your serfs. Currently serfs are not coded into the game yet.
Currently what is working is when you enter an amount of grain in the text feild and click "Release!" It will
subtract the number of grain from your reserve. Doing this will also enable the next button which will allow you
to continue to the next panel.

What needs to be added:
A formula for the serfs to be born / die based on the amount of grain you release
A limit on how much grain you can use (You can currently go into negative grain)
A limit on the amount you can keep(at least 20%)
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GranaryPanel extends JPanel implements ActionListener
{
	private JButton nextButton;
	private JButton releaseButton = new JButton("Release!");
	private JLabel backgroundPicture;
	private JLabel playerLabel = new JLabel();
	private KingdomController Parent;
	private JLabel grainReserve = new JLabel();
	private JLabel grainDemand = new JLabel();
	private JLabel yearLabel = new JLabel();
	private JLabel grainReleasedLabel = new JLabel();
	private JTextField releaseGrain = new JTextField();
	public GranaryPanel(KingdomController parent)
	{
		setLayout(null);
		Parent = parent;
		nextButton = new JButton("Next");
		nextButton.setEnabled(false);
		backgroundPicture = new JLabel();
		backgroundPicture.setIcon(new ImageIcon("Granarybg.png"));
		backgroundPicture.setBounds(0,-13,615,555);
		nextButton.setBounds(360,420,200,50);
		releaseButton.setBounds(238,250,100,30);
		grainReserve.setBounds(50,350,200,50);
		grainDemand.setBounds(50,400,200,50);
		releaseGrain.setBounds(190,210,200,30);
		grainReleasedLabel.setBounds(150,145,400,300);
		playerLabel.setBounds(200,-160,400,400);
		yearLabel.setBounds(200,-175,400,400);
		playerLabel.setFont(new Font("Vivaldi", Font.BOLD, 16));
		yearLabel.setFont(new Font("Vivaldi", Font.BOLD, 16));
		yearLabel.setForeground(Color.BLACK);
		playerLabel.setForeground(Color.BLACK);
		grainReserve.setFont(new Font("Vivaldi", Font.BOLD, 18));
		grainReserve.setForeground(Color.BLACK);
		grainDemand.setFont(new Font("Vivaldi", Font.BOLD, 18));
		grainDemand.setForeground(Color.BLACK);
		grainReleasedLabel.setFont(new Font("Vivaldi", Font.BOLD, 18));
		grainReleasedLabel.setForeground(Color.BLACK);
		add(playerLabel);
		add(grainDemand);
		add(grainReserve);
		add(releaseGrain);
		add(grainReleasedLabel);
		add(nextButton);
		add(releaseButton);
		add(yearLabel);
		add(backgroundPicture);
		nextButton.addActionListener(this);
		releaseButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == nextButton)
		{
			//runs the method that swtiches the panels
			Parent.serfReport();
		}
		if(e.getSource() == releaseButton)
		{
			//Releases the amount of grain you input.
			int rGrain = Integer.parseInt(releaseGrain.getText());
			Harvest.subtractGrainReserve(rGrain);
			grainReleasedLabel.setText("You have released " + rGrain + " grain to your serfs!");
			grainReserve.setText("Grain Reserve: " + Harvest.getGrainReserve());
			nextButton.setEnabled(true);
		}
	}
	//Updates information so it can be displayed properly.
	public void updateInformation()
	{
		playerLabel.setText(Player.getGender() + Player.getName() + " of " + Player.getRuledLocation());
		grainReserve.setText("Grain Reserve: " + Harvest.getGrainReserve());
		grainDemand.setText("Grain Demand: " + Harvest.getGrainDemand());
		yearLabel.setText("Year " + Harvest.getYear());
	}
}