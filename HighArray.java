//highArray.java
//Joseph Charles Serrano
// 2/14/16
//Chapter 2, Assignment 2
//To the HighArray class in the highArray.java program, add a method called getMax() that returns the value of the highest key in the array, or –1 if the array is empty. Add some code in main() to exercise this method.

class HighArray
{
	private long[] a;
	private int nElems;

	public HighArray(int max)
	{
		a = new long[max];
		nElems = 0;
	}

	public boolean find(long searchKey)
	{
		int j;
		for(j=0; j<nElems; j++) 
			if(a[j] == searchKey) 
				break; 
		
		if(j == nElems)
			return false; 
		else
			return true;  
	}

	public void insert(long value)
	{
		a[nElems] = value;             
		nElems++;  //nElems = nElems + 1;                    
	}

	public boolean delete(long value)
	{
		int j;
		for(j=0; j<nElems; j++)        
			if( value == a[j] )
				break;
		
		if(j==nElems)                  
			return false;
		else                           
		{
			for(int k=j; k<nElems; k++) 
				a[k] = a[k+1];
			nElems--;                   
			return true;
		}
	} 

	public long getMax()
	{
		int j;
		long maxValue = -1;
		
		for(j=0; j<nElems; j++)
			if (a[j] > maxValue)
				maxValue = a[j];
		
		//Max Value is going to be deleted
		delete(maxValue);
		return maxValue;
	}
	
	public long getMin()
	{
		int j;
		long minValue = -1;
		
		for(j=0; j>nElems; j++)
			if (a[j] < minValue)
				minValue = a[j];
		
		//Min Value is going to be deleted
		delete(minValue);
		return minValue;
	}

	public void display()            
	{
		for(int j=0; j<nElems; j++)       
			System.out.print(a[j] + " ");  
		System.out.println("");
		//System.out.println("nElems is " + nElems);
	}

}

