// Deque.java
// Joseph Charles Serrano
// 2/28/16
// Chapter 4, Assignment 5 
// Create a Deque class including insertLeft(), insertRight(), removeLeft(), removeRight(), isEmpty(), and isFull()
// To compile = javac Deque.java
// To run = java DequeApp

class Deque
{
	private int maxSize;
	private long[] queArray;
	private int left;
	private int right;
	private int nItems;
	
	public Deque(int maxSize)
	{
		this.maxSize = maxSize;
		queArray = new long[maxSize];
		nItems = 0;
		left = 0;
		right = maxSize - 1;
	}
	
	// isEmpty()
	public boolean isEmpty()
	{
		if (nItems == 0)
			return true;
		else
			return false;	
	}
	
	// isFull()
	public boolean isFull()
	{
		if (nItems == maxSize)
			return true;
		else
			return false;
	
	}
	
	// insertLeft()
	public void insertLeft(long l)
	{
		if(isFull())
			throw new RuntimeException("It's full");
		
		if (left == 0)
			left = maxSize;
		
		queArray[--left] = l;
		nItems++;
		
		System.out.print(l + " ");
	}
	
	// insertRight()
	public void insertRight(long r)
	{
		if(isFull())
			throw new RuntimeException("It's full");
		
		if (right == maxSize - 1)
			right = -1;
		
		queArray[++right] = r;
		nItems++;
		
		System.out.print(r + " ");
	}
	
	// removeLeft()
	public long removeLeft()
	{
		if (isEmpty())
			throw new RuntimeException("It's empty");
		
		long temp = queArray[left];
		left++;
		
		if (left == maxSize)
			left = maxSize - 1;
		
		
		nItems--;
		return temp;
	}
	
	// removeRight()
	public long removeRight()
	{
		if(isEmpty())
			throw new RuntimeException("It's empty");
		
		long temp = queArray[right];
		right--;
		
		if (right < 0)
			right = 0;
		
		nItems--;
		return temp;
		
	}	
}

class DequeApp
{
	public static void main(String[] args)
	{
		Deque theDeque = new Deque(5);
		
		System.out.print("Is it empty?: " + theDeque.isEmpty());
		
		System.out.println("\n \n 4 Items Being Added ");
		
		theDeque.insertLeft(12);
		theDeque.insertLeft(22);
		theDeque.insertLeft(32);
		theDeque.insertLeft(42);
		
		
		
		System.out.print("\n Is it empty now?: " + theDeque.isEmpty());
		
		System.out.println("\n \n Adding last Item ");
		theDeque.insertRight(52);
		
		System.out.print("\n Is it Full?: " + theDeque.isFull());
		
		long l;
		long r;
		
		System.out.println("\n \n Removing Items ");
		l = theDeque.removeLeft();
		System.out.println("Left Item: " + l);
		r = theDeque.removeRight();
		System.out.println("Right Item: " + r);
		
		System.out.print("\n Is it Full?: " + theDeque.isFull());
	}
}

/* C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac Deque.java

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java DequeApp
Is it empty?: true

 4 Items Being Added
12 22 32 42
 Is it empty now?: false

 Adding last Item
52
 Is it Full?: true

 Removing Items
Left Item: 42
Right Item: 52

 Is it Full?: false */


