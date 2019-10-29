/*
	This class displays the character create panel. You are prompted with a text box where you can enter your name, a drop down menu where you can choose our city-state
and a radio button option where you can choose "Boy" or "Girl to decide your gender. This information is seen on the playerLabel which can be seen on every panel after
this one. Once this information is entered it can not be changed. There is one button on this panel Labeled "Next" which you click to advance to the next panel.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CharacterCreatePanel extends JPanel implements ActionListener
{
	private KingdomController Parent;
	//Array of Strings for the city state JComboBox
	private String[] cStrings = { "Monaco", "Singapore", "Vatican City", "Hong Kong", "Macau" };
	private ButtonGroup genderButtons = new ButtonGroup();
	private JRadioButton jBoy = new JRadioButton("Boy");
	private JRadioButton jGirl = new JRadioButton("Girl");
	private JLabel logo = new JLabel();
    private JLabel name = new JLabel("Enter your rulers name:");
    private JLabel cState = new JLabel("Choose your City-State:");
    private JLabel genderLabel = new JLabel("Choose your Gender:");
    private JButton nextButton = new JButton("Next");
    private JTextField ruler = new JTextField();
    private JComboBox cStateList = new JComboBox(cStrings);

	public CharacterCreatePanel(KingdomController parent)
	{
		setLayout(null);
		Parent = parent;
		logo.setIcon(new ImageIcon("logo.png"));
		genderLabel.setBounds(25,325,200,25);
		jBoy.setBounds(25,350,200,25);
		jGirl.setBounds(25,375,200,25);
		cStateList.setBounds(300,225,200,22);
		cState.setBounds(300,200,200,20);
		logo.setBounds(25,0,600,173);
		ruler.setBounds(25,225,200,25);
		name.setBounds(25,200,200,25);
		nextButton.setBounds(360,420,200,50);
		cState.setFont(new Font("Serif", Font.BOLD, 16));
		cState.setForeground(Color.BLACK);
		name.setFont(new Font("Serif", Font.BOLD, 16));
		name.setForeground(Color.BLACK);
		genderLabel.setFont(new Font("Serif", Font.BOLD, 16));
		genderLabel.setForeground(Color.BLACK);
		genderButtons.add(jBoy);
		genderButtons.add(jGirl);
		add(nextButton);
		add(jBoy);
		add(jGirl);
		add(name);
		add(cState);
		add(genderLabel);
		add(cStateList);
		add(logo);
		add(ruler);
		nextButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == nextButton)
		{
			//Sets the player name, Gender and Place ruled and sets them in the Player class
			Player.setName(ruler.getText());
			if(jBoy.isSelected())
			{
				Player.setGender(true);
			}
			else
			{
				Player.setGender(false);
			}
			Player.setRuledLocation((String)cStateList.getSelectedItem());
			Parent.updateInformation();
			Parent.havestPhase();
		}
	}
}