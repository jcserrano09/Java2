//HighArrayApp.java
//Joseph Charles Serrano
// 2/14/16
//Chapter 2, Assignment 2
//To the HighArray class in the highArray.java program, add a method called getMax() that returns the value of the highest key in the array, or –1 if the array is empty. Add some code in main() to exercise this method.

class HighArrayApp
{
	public static void main(String[] args)
	{
		int maxSize = 100;            
		HighArray arr;                
		arr = new HighArray(maxSize); 

		arr.insert(77);              
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(150);
		arr.insert(66);
		arr.insert(33);
		arr.insert(2);

		arr.display();
		
		//get the max value
		long maxValue = arr.getMax();
		System.out.println("maxValue: " + maxValue);
		
		arr.display();
		
		//get the min value
		long minValue = arr.getMin();
		System.out.println("minValue: " + minValue);
		
		arr.display();
		
		int searchKey = 35;          
		if( arr.find(searchKey) )
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);

		//added another searchKey
		searchKey = 66;          
		if( arr.find(searchKey) )
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);
		
		arr.delete(00);	
		arr.delete(55);
		arr.delete(99);
		arr.display();
	}  
}  
/* 
C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java HighArrayApp
77 99 44 55 22 88 11 0 150 66 33
maxValue: 150
77 99 44 55 22 88 11 0 66 33
Can't find 35
Found 66
77 44 22 88 11 66 33 
*/