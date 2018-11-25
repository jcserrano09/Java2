//InsertSortApp.java
// A part of the insertSort.java program
//Joseph Charles Serrano
// 2/21/16
/* To run in the cmd prompt
javac ArrayIns.java
javac InsertSortApp.java
java InsertSortApp */

class InsertSortApp
{
	public static void main(String[] args)
	{
		int maxSize = 100;            
		ArrayIns arr;                
		arr = new ArrayIns(maxSize); 

		arr.insert(77);              
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		
		// the duplicates
		arr.insert(77);
		arr.insert(77);
		arr.insert(77);
		
		
		arr.display();
		
		arr.insertionSort();
		
		arr.display();
		
		arr.noDups();

		System.out.println("After delete dupliactes: \n");
		arr.display();

		long median = arr.median(); 
		System.out.println("The median is: " + median);
	}
}

//Output:
/* C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac ArrayIns.java

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac InsertSortApp.java

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java InsertSortApp
77 99 44 55 22 88 11 0 66 33 77 77 77
0 11 22 33 44 55 66 77 77 77 77 88 99
After delete dupliactes:

0 11 22 33 44 55 66 77 88 99
The median is: 49 */
