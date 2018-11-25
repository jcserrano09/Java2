//ArrayIns.java
// A part of the insertSort.java program
//Joseph Charles Serrano
// 2/21/16
// Add a method called median() to the ArrayIns class  
// To the insertSort.java program (Listing 3.3), add a method called noDups() 

class ArrayIns
{
	private long[] a;
	private int nElems;
	
	public ArrayIns(int max)
	{
		a = new long[max];
		nElems = 0;
	}
	
	public void insert(long value)
	{
		a[nElems] = value;
		nElems++;
	}
	
	public void display()
	{
		for(int j=0; j<nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println("");
	}
	
	public void insertionSort()
	{
		int in, out;
		
		for(out=1; out<nElems; out++)
		{
			long temp = a[out];
			in = out;
			while(in>0 && a[in-1] >= temp)
			{
				a[in] = a[in-1];
				--in;
			}
			a[in] = temp;
		}	
	}
	//median() method
	public long median() 
	{
		if (nElems % 2 == 0) 
		{ // finding if array is even
			int index1 = nElems/2-1;
			return (a[index1]+a[index1+1]) / 2;
		}
		else 
		{ // finding if array is odd
			return a[nElems/2]; 
		}
	} // end of median()
	
	//noDups() method
	public void noDups() 
	{
		int i = 0;
		int j = 1;
		int k = 0;
		int dups = 0;
		while (k < (nElems - 1)) 
		{
			while (a[k+1] <= a[i]) 
			{  
				k++;
				dups++;
			}
			a[j] = a[k+1];
			k = k + 1;
			i = j;
			j = i + 1;
		}
	nElems = nElems - dups;
	} // end of noDups()

}
//end of class ArrayIns
