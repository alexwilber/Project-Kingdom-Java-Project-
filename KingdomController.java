/*
	This is the controller where the code is run. It also contains methods that swtich the panel and a method to update the information. This class links all
of the panels together so that they can be added to the frame. This class also acts as the Frame and contains a method that sets the size of the frame and makes the
frame visible.
*/
import javax.swing.JFrame;
import javax.swing.JPanel;
public class KingdomController extends JFrame
{
	//Defines objects of all of the panels.
	private IntroPanel introPanel;
	private BuySellPanel buySellPanel;
	private CharacterCreatePanel characterCreatePanel;
	private HarvestPanel harvestPanel;
	private GranaryPanel granaryPanel;
	private TaxPanel taxPanel;
	private MapPanel mapPanel;
	private InvestmentPanel investmentPanel;
	private SerfPanel serfPanel;
	public static void main(String [] args)
	{
		//runs constructor method
		new KingdomController();
	}
	//constructor method, creates the objects of the panels and adds the intro panel to the frame.
	public KingdomController()
	{
		introPanel = new IntroPanel(this);
		characterCreatePanel = new CharacterCreatePanel(this);
		buySellPanel = new BuySellPanel(this);
		harvestPanel = new HarvestPanel(this);
		granaryPanel = new GranaryPanel(this);
		taxPanel = new TaxPanel(this);
		mapPanel = new MapPanel(this);
		serfPanel = new SerfPanel(this);
		investmentPanel = new InvestmentPanel(this);
		add(introPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Grain Quest");
		setSize(615,555);
	}
	//Starts the game by removing the intro panel and adding the character creation panel.
	public void startGame()
	{
		remove(introPanel);
		add(characterCreatePanel);
		//refreshes the ContentPane
		getContentPane().invalidate();
		getContentPane().validate();
	}
	//Starts the harvest phase by removing the character creation panel and adding the harvest panel.
	public void havestPhase()
	{
		remove(characterCreatePanel);
		characterCreatePanel.setVisible(false);
		add(harvestPanel);
		harvestPanel.setVisible(true);
		//refreshes the ContentPane
		getContentPane().invalidate();
		getContentPane().validate();
	}
	//Starts Buy/Sell Phase buy adding the BuySell Panel and removing the Harvest panel
	public void buySellPhase()
	{
		remove(harvestPanel);
		harvestPanel.setVisible(false);
		add(buySellPanel);
		buySellPanel.setVisible(true);
		//refreshes the ContentPane
		getContentPane().invalidate();
		getContentPane().validate();
	}
	public void sellGrainPhase()
	{
		remove(buySellPanel);
		buySellPanel.setVisible(false);
		add(granaryPanel);
		granaryPanel.setVisible(true);
		//refreshes the ContentPane
		getContentPane().invalidate();
		getContentPane().validate();
	}
	public void serfReport()
	{
		remove(granaryPanel);
		granaryPanel.setVisible(false);
		add(serfPanel);
		serfPanel.setVisible(true);
		//refreshes the ContentPane
		getContentPane().invalidate();
		getContentPane().validate();
	}
	public void taxPhase()
	{
		remove(serfPanel);
		serfPanel.setVisible(false);
		add(taxPanel);
		taxPanel.setVisible(true);
		//refreshes the ContentPane
		getContentPane().invalidate();
		getContentPane().validate();
	}
	public void mapPhase()
	{
		remove(taxPanel);
		taxPanel.setVisible(false);
		add(mapPanel);
		mapPanel.setVisible(true);
		//refreshes the ContentPane
		getContentPane().invalidate();
		getContentPane().validate();
	}
	public void investmentPhase()
	{
		remove(mapPanel);
		mapPanel.setVisible(false);
		add(investmentPanel);
		investmentPanel.setVisible(true);
		//refreshes the ContentPane
		getContentPane().invalidate();
		getContentPane().validate();
	}
	public void loopPhase()
	{
		remove(investmentPanel);
		investmentPanel.setVisible(false);
		add(harvestPanel);
		harvestPanel.setVisible(true);

		//refreshes the ContentPane
		getContentPane().invalidate();
		getContentPane().validate();
	}
	//Updates information so it can be displayed properly.
	public void updateInformation()
	{
		harvestPanel.updateInformation();
		mapPanel.updateInformation();
		taxPanel.updateInformation();
		investmentPanel.updateInformation();
		granaryPanel.updateInformation();
		buySellPanel.updateInformation();
		serfPanel.updateInformation();
	}
}
