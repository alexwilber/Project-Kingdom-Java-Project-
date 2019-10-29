/*
	This class sets grain destroyed by the rats with a random number from 1 - 50 and takes away that percentage amount from your grain reserve.
It then displays the Grain Percentage destroyed by rats and your grain reserve. This uses static variables and methods from the Harvest class and displays
that information to the label. The Grain Demand is displayed here which has not been fully coded into the game. Grain Price is also displayed in this class using
a static variable from the Harvest class. Currently Grain Price is set as a random double type variable which generates a number from 1-2. This feature isn't fully
completed but it would be based off of the amount of serfs you have and how much Land you had. The land variable is also displayed in this class, each time you
start off with 10000 hectares of land. The land price is displayed in the panel. Treasury is also displayed and each time you start with 1000 florins.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.text.DecimalFormat;
public class HarvestPanel extends JPanel implements ActionListener
{
	Random r = new Random();
	Random landPriceNum = new Random();
	//Creates a random number for the rats to destroy grain from 1 - 50%
	private int grainDestroyed = r.nextInt(49)+1;
	private KingdomController Parent;
	private JLabel leaves = new JLabel();
	private JLabel harvestPhaseLogo = new JLabel();
	private JLabel playerLabel = new JLabel();
	private JLabel ratLabel = new JLabel();
	private JLabel landPrice = new JLabel();
	private JLabel grainReserve = new JLabel();
	private JLabel grainDemand = new JLabel();
	private JLabel grainPrice = new JLabel();
	private JLabel land = new JLabel();
	private JLabel treasury = new JLabel();
	private JButton nextButton = new JButton("Next");
	DecimalFormat df = new DecimalFormat("#.##");
	public HarvestPanel(KingdomController parent)
	{
		setLayout(null);
		Parent = parent;
		setBackground(Color.BLACK);
		leaves.setIcon(new ImageIcon("leaves.gif"));
		harvestPhaseLogo.setIcon(new ImageIcon("HarvestPhaseLogo.png"));
		leaves.setBounds(45,-15,615,555);
		harvestPhaseLogo.setBounds(25,0,600,173);
		nextButton.setBounds(360,420,200,50);
		ratLabel.setBounds(10,-20,600,400);
		grainReserve.setBounds(10,30,600,400);
		grainDemand.setBounds(10,80,600,400);
		grainPrice.setBounds(10,130,600,400);
		land.setBounds(10,180,600,400);
		landPrice.setBounds(10,230,600,400);
		treasury.setBounds(10,280,600,400);
		playerLabel.setBounds(370,-60,400,400);
		ratLabel.setFont(new Font("Vivaldi", Font.BOLD, 20));
		ratLabel.setForeground(Color.WHITE);
		grainReserve.setFont(new Font("Vivaldi", Font.BOLD, 18));
		grainReserve.setForeground(Color.WHITE);
		grainDemand.setFont(new Font("Vivaldi", Font.BOLD, 18));
		grainDemand.setForeground(Color.WHITE);
		grainPrice.setFont(new Font("Vivaldi", Font.BOLD, 18));
		grainPrice.setForeground(Color.WHITE);
		land.setFont(new Font("Vivaldi", Font.BOLD, 18));
		land.setForeground(Color.WHITE);
		landPrice.setFont(new Font("Vivaldi", Font.BOLD, 18));
		landPrice.setForeground(Color.WHITE);
		treasury.setFont(new Font("Vivaldi", Font.BOLD, 20));
		treasury.setForeground(Color.WHITE);
		playerLabel.setFont(new Font("Vivaldi", Font.BOLD, 16));
		playerLabel.setForeground(Color.WHITE);
		Harvest.setDestoryedGrain(grainDestroyed);
		//sets a random land price between 2-3
		Harvest.setLandPrice(landPriceNum.nextDouble()*(1.0)+2);
		//Destroys grain based on the rats percentage.
		Harvest.setGrainReserve(Harvest.getGrainReserve() * grainDestroyed/100);
		ratLabel.setText("Grain destroyed by rats: "+ Harvest.getDestoryedGrain()+ "%");
		add(playerLabel);
		add(ratLabel);
		add(landPrice);
		add(grainReserve);
		add(grainDemand);
		add(grainPrice);
		add(land);
		add(landPrice);
		add(treasury);
		add(nextButton);
		add(harvestPhaseLogo);
		add(leaves);
		nextButton.addActionListener(this);
		System.out.println(Player.getName());(ActionEvent e)
	{
		if(e.getSource() == nextButton)
		{
			//runs the method that swtiches the panels
			Parent.buySellPhase();
		}
	}
	//updates Information so it can be displayed properly.
	public void updateInformation()
	{
		playerLabel.setText(Player.getGender() + Player.getName() + " of " + Player.getRuledLocation());
		grainReserve.setText("Grain Reserve: " + Harvest.getGrainReserve());
		grainDemand.setText("Grain Demand: " + Harvest.getGrainDemand());
		grainPrice.setText("Grain Price: " + Harvest.getGrainPrice() + "ƒ");
		land.setText("Land: " + Harvest.getLand());
		landPrice.setText("Land Price: " + Harvest.getLandPrice() + "ƒ");
		treasury.setText("Treasury: " + Harvest.getTreasury() + "ƒ");

	}
}