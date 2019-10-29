/*
	Contains the gets and sets for the gender, locataion and gender name. This information is globaly displayed through each panel.
*/

public class Player
{
	static Boolean playerGender = true;
	static String genderName = "";
	static String playerLocation = "";
	static String playerName = "";
	static int points = 0;
	public static void setGender(Boolean gender)
	{
		playerGender = gender;
	}
	public static void setRuledLocation(String location)
	{
		playerLocation = location;
	}
	public static void setName(String name)
	{
		playerName = name;
	}
	public static String getGender()
	{
		//picks your gender based on a boolean which is set in the CharacterCreatePanel and sets it as you gender
		if(playerGender == true)
		{

			genderName = "Sir ";
		}
		else
		{
			genderName = "Dame ";
		}
		return genderName;
	}
	public static String getRuledLocation()
	{
		return playerLocation;
	}
	public static String getName()
	{
		return playerName;
	}
}