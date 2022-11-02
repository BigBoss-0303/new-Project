
import java.util.ArrayList;

/**
 * @author user 
 * class of runneble that checks the array workes with threds
 *
 */
public class ThreadCheckArray implements Runnable 
{
	private boolean flag;
	private boolean [] winArray;
	SharedData sd;
	ArrayList<Integer> array;
	int b;
	
	/**
	 * @param sd
	 * constractor that gets the array and accespts data from class
	 */
	public ThreadCheckArray(SharedData sd) 
	{
		this.sd = sd;	
		synchronized (sd) 
		{
			array = sd.getArray();
			b = sd.getB();
		}		
		winArray = new boolean[array.size()]; //gets size of array 
	}
	
	/**
	 * @param n
	 * @param b
	 * gets flag and integer and using threads runs it and syncronizes the data
	 */
	void rec(int n, int b)
	{
		synchronized (sd) 
		{
			if (sd.getFlag())
				return;
		}	
		if (n == 1)
		{
			if(b == 0 || b == array.get(array.size()-n-1))
			{
				flag = true;
				synchronized (sd) 
				{
					sd.setFlag(true);
				}			
			}
			if (b == array.get(array.size()-n-1))
				winArray[n-1] = true;
			return;
		}
		
		rec(n-1, b - array.get(n-1));
		if (flag)
			winArray[n-1] = true;
		synchronized (sd) 
		{
			if (sd.getFlag())
				return;
		}	
		rec(n-1, b);
	}

	/**
	 *void method dosent return a thing uses rec method in order to use the threds and sync actions
	 */
	public void run() {
		if (array.size() != 1)
			if (Thread.currentThread().getName().equals("thread1"))
				rec(array.size()-1, b - array.get(array.size()-1));
			else 
				rec(array.size()-1, b);
		if (array.size() == 1)
			if (b == array.indexOf(0) && !flag)
			{
				winArray[0] = true;
				flag = true;
				synchronized (sd) 
				{
					sd.setFlag(true);
				}
			}
		if (flag)
		{
			if (Thread.currentThread().getName().equals("thread1"))
				winArray[array.size() - 1] = true;
			synchronized (sd) 
			{
				sd.setWinArray(winArray);
			}	
		}
	}
}


