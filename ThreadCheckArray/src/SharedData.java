import java.util.ArrayList;
/**
 * Class responsible for abaling sharing data using an ArrayList
 * @author user
 */
public class SharedData 
{
	private ArrayList<Integer> array;
	private boolean [] winArray;
	private boolean flag;
	private final int b;
	
	/**
	 * constractor that creates a list of integers and declares a parameter
	 * @param array
	 * @param b
	 */
	public SharedData(ArrayList<Integer> array, int b) {
		
		this.array = array;
		this.b = b; // number to look for
	}

	/**
	 * @return an array
	 */
	public boolean[] getWinArray() 
	{
		return winArray;
	}
	
	/**
	 * @param winArray, void method dosent return anything , sets boolean array  
	 */
	public void setWinArray(boolean [] winArray) 
	{
		this.winArray = winArray;
	}

	/**
	 * @return ArrayList of integers
	 */
	public ArrayList<Integer> getArray() 
	{
		return array;
	}

	/**
	 * @return the int b
	 */
	public int getB() 
	{
		return b;
	}

	/**
	 * @return a boolean value that represented as flag
	 */
	public boolean getFlag() 
	{
		return flag;
	}

	/**
	 * @param flag sets value of flag 
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}


