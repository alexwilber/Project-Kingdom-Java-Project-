/*
	This class handles all of the buying and selling of the grain logic. This currently works, although thr
prices for the land and grain are random numbers and not based on the amount of serfs and land like it should be.
The amount of land that can be bought or sold is currently no limit so it is possible to go into negative money. BUYINg
and selling does work though by taking money from your funds using a formula. It displays all the variables that are displayed
in your haarvest panel to the right of the screen except % of destroyed grain and displays two more variables than the
harevst phase does which are grain price and land price.

What needs to be Added:
A proper way of generating the right grain and land price with a formula thats based on the number of serfs you have
A Limit on how much you can sell/buy ( currently no limit on anything)

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BuySellPanel extends JPanel implements ActionListener
{
	private JButton nextButton;
	private JButton buyGrainButton = new JButton("Buy Grain");
	private JButton sellGrainButton = new JButton("Sell Grain");
	private JButton buyLandButton = new JButton("Buy Land");
	private JButton sellLandButton = new JButton("Sell Land");
	private JLabel backgroundPicture;
	//Creates a new instance of kingdom controller and names it Parent
	private KingdomController Parent;
	private JLabel playerLabel = new JLabel();
	private JLabel yearLabel = new JLabel();
	private JLabel buyGrainLabel = new JLabel("Grain (steres): ");
	private JLabel sellGrainLabel = new JLabel("Grain (steres): ");
	private JLabel buyLandLabel = new JLabel("Land (hectares): ");
	private JLabel sellLandLabel = new JLabel("Land (hectares): ");
	private JLabel grainReserve = new JLabel();
	private JLabel grainDemand = new JLabel();
	private JLabel grainPrice = new JLabel();
	private JLabel land = new JLabel();
	private JLabel landPrice = new JLabel();
	private JLabel treasury = new JLabel();
	private JTextField buyGrain = new JTextField();
	private JTextField sellGrain = new JTextField();
	private JTextField buyLand = new JTextField();
	private JTextField sellLand = new JTextField();
	public BuySellPanel(KingdomController parent)
	{
		setLayout(null);
		Parent = parent;
		nextButton = new JButton("Next");
		backgroundPicture = new JLabel();
		backgroundPicture.setIcon(new ImageIcon("marketbg.png"));
		backgroundPicture.setBounds(0,-13,615,555);
		nextButton.setBounds(360,420,200,50);
		buyGrainLabel.setBounds(20,180,200,50);
		sellGrainLabel.setBounds(20,210,200,50);;
		buyLandLabel.setBounds(20,240,200,50);
		sellLandLabel.setBounds(20,270,200,50);
		buyGrain.setBounds(140,198,100,18);
		sellGrain.setBounds(140,228,100,18);
		buyLand.setBounds(149,258,100,18);
		sellLand.setBounds(149,288,100,18);
		grainReserve.setBounds(374,170,200,50);
		grainDemand.setBounds(374,200,200,50);
		grainPrice.setBounds(374,230,200,50);
		land.setBounds(374,260,200,50);
		landPrice.setBounds(374,290,200,50);
		treasury.setBounds(374,320,200,50);
		buyGrainButton.setBounds(20,350,100,20);
		sellGrainButton.setBounds(140,350,100,20);
		buyLandButton.setBounds(20,390,100,20);
		sellLandButton.setBounds(140,390,100,20);
		playerLabel.setBounds(200,-157,400,400);
		yearLabel.setBounds(200,-175,400,400);
		buyGrainLabel.setFont(new Font("Vivaldi", Font.BOLD, 18));
		buyGrainLabel.setForeground(Color.BLACK);
		sellGrainLabel.setFont(new Font("Vivaldi", Font.BOLD, 18));
		sellGrainLabel.setForeground(Color.BLACK);
		buyLandLabel.setFont(new Font("Vivaldi", Font.BOLD, 18));
		buyLandLabel.setForeground(Color.BLACK);
		sellLandLabel.setFont(new Font("Vivaldi", Font.BOLD, 18));
		sellLandLabel.setForeground(Color.BLACK);
		playerLabel.setFont(new Font("Vivaldi", Font.BOLD, 16));
		playerLabel.setForeground(Color.WHITE);
		yearLabel.setFont(new Font("Vivaldi", Font.BOLD, 16));
		yearLabel.setForeground(Color.WHITE);
		grainReserve.setFont(new Font("Vivaldi", Font.BOLD, 18));
		grainReserve.setForeground(Color.BLACK);
		grainDemand.setFont(new Font("Vivaldi", Font.BOLD, 18));
		grainDemand.setForeground(Color.BLACK);
		grainPrice.setFont(new Font("Vivaldi", Font.BOLD, 18));
		grainPrice.setForeground(Color.BLACK);
		land.setFont(new Font("Vivaldi", Font.BOLD, 18));
		land.setForeground(Color.BLACK);
		landPrice.setFont(new Font("Vivaldi", Font.BOLD, 18));
		landPrice.setForeground(Color.BLACK);
		treasury.setFont(new Font("Vivaldi", Font.BOLD, 18));
		treasury.setForeground(Color.BLACK);
		add(nextButton);
		add(buyGrainButton);
		add(sellGrainButton);
		add(buyLandButton);
		add(sellLandButton);
		add(grainReserve);
		add(grainDemand);
		add(grainPrice);
		add(land);
		add(landPrice);
		add(treasury);
		add(playerLabel);
		add(buyGrainLabel);
		add(sellGrainLabel);
		add(buyLandLabel);
		add(sellLandLabel);
		add(buyGrain);
		add(sellGrain);
		add(buyLand);
		add(sellLand);
		add(yearLabel);
		add(backgroundPicture);
		nextButton.addActionListener(this);
		buyGrainButton.addActionListener(this);
		sellGrainButton.addActionListener(this);
		buyLandButton.addActionListener(this);
		sellLandButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == nextButton)
		{
			//runs panel switching method
			Parent.sellGrainPhase();
		}
		if(e.getSource() == buyGrainButton)
		{
			//Runs a formula to buy the grain. Treasury minus the amount of grain you want to by multiplied by the grain price.
			int bGrain = Integer.parseInt(buyGrain.getText());
			double bGrainTransaction = Harvest.getTreasury() - (bGrain*Harvest.getGrainPrice());
			//adds Grain to reserve
			Harvest.addGrainReserve(bGrain);
			grainReserve.setText("Grain Reserve: " + Harvest.getGrainReserve());
			Harvest.setTreasury(bGrainTransaction);
			treasury.setText("Treasury: " + Harvest.getTreasury() + "ƒ");
		}
		if(e.getSource() == sellGrainButton)
		{
			//Runs a formula to sell the grain. Treasury plus the amount of grain you want to by multiplied by the grain price.
			int sGrain = Integer.parseInt(sellGrain.getText());
			double sGrainTransaction = Harvest.getTreasury() + (sGrain*Harvest.getGrainPrice());
			//subtracts Grain from reserve
			Harvest.subtractGrainReserve(sGrain);
			Harvest.setTreasury(sGrainTransaction);
			grainReserve.setText("Grain Reserve: " + Harvest.getGrainReserve());
			treasury.setText("Treasury: " + Harvest.getTreasury() + "ƒ");
		}
		if(e.getSource() == buyLandButton)
		{
			//Runs a formula to buy the land. Treasury minus the amount of land you want to by multiplied by the land price.
			int bLand = Integer.parseInt(buyLand.getText());
			double buyLandTransaction = Harvest.getTreasury() - (bLand*Harvest.getLandPrice());
			Harvest.setTreasury(buyLandTransaction);
			//adds Land your bought to your land
			Harvest.setLand(Harvest.getLand() + bLand);
			land.setText("Land: " + Harvest.getLand());
			treasury.setText("Treasury: " + Harvest.getTreasury() + "ƒ");
		}
		if(e.getSource() == sellLandButton)
		{
			//Runs a formula to sell the land. Treasury plus the amount of land you want to by multiplied by the land price.
			int sLand = Integer.parseInt(sellLand.getText());
			double transaction = Harvest.getTreasury() + (sLand*Harvest.getLandPrice());
			//subtracts the Land you sold from your land
			Harvest.setLand(Harvest.getLand() - sLand);
			Harvest.setTreasury(transaction);
			land.setText("Land: " + Harvest.getLand());
			treasury.setText("Treasury: " + Harvest.getTreasury() + "ƒ");
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
		yearLabel.setText("Year " + Harvest.getYear());

	}
}