
import java.util.Random;
public class Harvest{
	private static Random r = new Random();
	private static Random grainRand = new Random();
	private static int grain = 0;
	private static int land = 10000;
	private static int serfs = 2000;
	private static int steres = 0;
	private static double landPrice = 0;
	private static double grainPrice = grainRand.nextDouble()*(0.1)+1;
	private static int grainDemand = 0;
	private static int grainReserve = r.nextInt(100000-50000 + 1) + 50000;
	private static double treasury = 1000;
	private static int sellGrain = 0;
	private static int buyGrain = 0;
	private static int sellLand = 0;
	private static int buyLand= 0;
	private static int destoryedGrain = 0;
	private static int year = 1400;

	public static int getGrain(){
		return grain;
	}
	public static int getLand(){
		return land;
	}
	public static int getSerfs(){
		return serfs;
	}
	public static int getSteres(){
		return steres;
	}
	public static double getLandPrice(){
		return landPrice;
	}
	public static double getGrainPrice(){
		return grainPrice;
	}
	public static int getGrainDemand(){
		return grainDemand;
	}
	public static int getGrainReserve(){
		return grainReserve;
	}
	public static double getTreasury(){
		return treasury;
	}
	public static int getSellGrain(){
		return sellGrain;
	}
	public static int getBuyGrain(){
		return buyGrain;
	}
	public static int getSellLand(){
		return sellLand;
	}
	public static int getBuyLand(){
		return buyLand;
	}
	public static int getDestoryedGrain(){
		return destoryedGrain;
	}
	public static int getYear(){
		return year;
	}
	public static void setGrain(int aGrain){
		grain = aGrain;
	}
	public static void setLand(int aLand){
		land = aLand;
	}
	public static void setSerfs(int aSerfs){
		serfs = aSerfs;
	}
	public static void setSteres(int aSteres){
		steres = aSteres;
	}
	public static void setLandPrice(double aLandPrice){
		landPrice = aLandPrice;
	}
	public static void setGrainPrice(double aGrainPrice){
		grainPrice = aGrainPrice;
	}
	public static void setGrainDemand(int aGrainDemand){
		grainDemand = aGrainDemand;
	}
	public static void setGrainReserve(int aGrainReserve){
		grainReserve = aGrainReserve;
	}
	public static void subtractGrainReserve(int aGrain){
		int newGrain;
		newGrain = grainReserve - aGrain;
		grainReserve = newGrain;
	}
	public static void addGrainReserve(int aGrain){
		int newGrain;
		newGrain = grainReserve + aGrain;
		grainReserve = newGrain;
	}
	public static void setTreasury(double aTreasury){
		treasury = aTreasury;
		}
	public static void setSellGrain(int aSellGrain){
		sellGrain = aSellGrain;
	}
	public static void setBuyGrain(int aBuyGrain){
		buyGrain = aBuyGrain;
	}
	public static void setSellLand(int aSellLand){
		sellLand = aSellLand;
	}
	public static void setBuyLand(int aBuyLand){
		buyLand = aBuyLand;
	}
	public static void setDestoryedGrain(int aDestoryedGrain){
		destoryedGrain = aDestoryedGrain;
	}
	public static void addYear()
	{
		year++;
	}

	public String toString(){

		String aString = "";
		aString = aString + "Grain " + this.getGrain() + "\n";
		aString = aString + "Land " + this.getLand() + "\n";
		aString = aString + "Serfs " + this.getSerfs() + "\n";
		aString = aString + "Steres " + this.getSteres() + "\n";
		aString = aString + "Land Price " + this.getLandPrice() + "\n";
		aString = aString + "Grain Price " + this.getGrainPrice() + "\n";
		aString = aString + "Grain Demand " + this.getGrainDemand() + "\n";
		aString = aString + "Grain Reserve " + this.getGrainReserve() + "\n";
		aString = aString + "Treasury " + this.getTreasury() + "\n";
		aString = aString + "Sell Grain " + this.getSellGrain() + "\n";
		aString = aString + "Buy Grain " + this.getBuyGrain() + "\n";
		aString = aString + "Sell Land " + this.getSellLand() + "\n";
		aString = aString + "Buy Land " + this.getBuyLand() + "\n";
		aString = aString + "Destoryed Grain " + this.getDestoryedGrain() + "\n";

			return aString;
		}


}