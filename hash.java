//hash.java
// Joseph Charles Serrano
// Assignment 15, Chapter 11
// 4/24/16
// Modify hash.java to use quadratic probing

import java.io.*;

class DataItem
{
	private int iData;
	
	public DataItem(int ii)
	{
		iData = ii;
	}
	
	public int getKey()
	{
		return iData;
	}
}

class HashTable
{
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;
	
	public HashTable(int size)
	{
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}
	
	public void displayTable()
	{
		System.out.print("Table: ");
		for(int j=0; j<arraySize; j++)
		{
			if(hashArray[j] != null)
				System.out.print(hashArray[j].getKey() + " ");
			else
				System.out.print("*** ");
		}
		System.out.println(" ");
	}
	
	public int hashFunc(int key)
	{
		return key % arraySize;
	}
	
	public void insert(DataItem item)
	{
		int key = item.getKey();
		int hashVal = hashFunc(key);
		int stepNumber = 1;
		
		while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1)
		{
			//++hashVal;
			//---added---
			hashVal += stepNumber*stepNumber;
			stepNumber++;
			//-----------
			hashVal %= arraySize;
		}
		hashArray[hashVal] = item;
	}
	
	public DataItem delete(int key)
	{
		int hashVal = hashFunc(key);
		int stepNumber = 1;
		
		while(hashArray[hashVal] != null)
		{
			if(hashArray[hashVal].getKey() == key)
			{
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;
			}
			//++hashVal;
			//---added---
			hashVal += stepNumber*stepNumber;
			stepNumber++;
			//-----------
			hashVal %= arraySize;
		}
		return null;
	}
	
	public DataItem find(int key)
	{
		int hashVal = hashFunc(key);
		int stepNumber = 1;
		
		while(hashArray[hashVal] != null)
		{
			if(hashArray[hashVal].getKey() == key)
				return hashArray[hashVal];
			//++hashVal;
			//---added---
			hashVal += stepNumber*stepNumber;
			stepNumber++;
			//-----------
			hashVal %= arraySize;
		}
		return null;
	}
}

class HashTableApp
{
	public static void main(String[] args) throws IOException
	{
		DataItem aDataItem;
		int aKey, size, n, keysPerCell;
		
		System.out.print("Enter size of hash table: ");
		size = getInt();
		System.out.print("Enter initial number of items: ");
		n = getInt();
		keysPerCell = 10;
		
		HashTable theHashTable = new HashTable(size);
		
		for(int j=0; j<n; j++)
		{
			aKey = (int)(java.lang.Math.random() * keysPerCell * size);
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aDataItem);
		}
		
		while(true)
		{
			System.out.print("Enter the first letter of ");
			System.out.print("show, insert, delete, or find: ");
			char choice = getChar();
			switch(choice)
			{
				case 's':
					theHashTable.displayTable();
					break;
				case 'i':
				System.out.print("Enter key value to insert: ");
					aKey = getInt();
					aDataItem = new DataItem(aKey);
					theHashTable.insert(aDataItem);
					break;
				case 'd':
					System.out.print("Enter key value to delete: ");
					aKey = getInt();
					theHashTable.delete(aKey);
					break;
				case 'f':
					System.out.print("Enter key value to find: ");
					aKey = getInt();
					aDataItem = theHashTable.find(aKey);
					if(aDataItem != null)
						System.out.println("Found " + aKey);
					else
						System.out.println("Could not find " + aKey);
					break;
				default:
					System.out.print("Invalid Entry\n");
			}
		}
	}
	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
}

/* 
C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac hash.java

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java HashTableApp
Enter size of hash table: 10
Enter initial number of items: 5
Enter the first letter of show, insert, delete, or find: s
Table: 70 *** *** *** 84 95 66 66 *** ***
Enter the first letter of show, insert, delete, or find: i
Enter key value to insert: 100
Enter the first letter of show, insert, delete, or find: s
Table: 70 100 *** *** 84 95 66 66 *** ***
Enter the first letter of show, insert, delete, or find: i
Enter key value to insert: 90
Enter the first letter of show, insert, delete, or find: s
Table: 70 100 *** *** 84 95 66 66 *** 90
Enter the first letter of show, insert, delete, or find: f
Enter key value to find: 95
Found 95
Enter the first letter of show, insert, delete, or find: d
Enter key value to delete: 66
Enter the first letter of show, insert, delete, or find: s
Table: 70 100 *** *** 84 95 -1 66 *** 90
Enter the first letter of show, insert, delete, or find: f
Enter key value to find: 66
Found 66
Enter the first letter of show, insert, delete, or find: d
Enter key value to delete: 66
Enter the first letter of show, insert, delete, or find: s
Table: 70 100 *** *** 84 95 -1 -1 *** 90
Enter the first letter of show, insert, delete, or find: f
Enter key value to find: 66
Could not find 66
Enter the first letter of show, insert, delete, or find: i
Enter key value to insert: 68
Enter the first letter of show, insert, delete, or find: s
Table: 70 100 *** *** 84 95 -1 -1 68 90
Enter the first letter of show, insert, delete, or find: i
Enter key value to insert: 25
Enter the first letter of show, insert, delete, or find: s
Table: 70 100 *** *** 84 95 25 -1 68 90
Enter the first letter of show, insert, delete, or find:
 */