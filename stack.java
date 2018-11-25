// stack.java
// Joseph Charles Serrano
// 2/28/16
// Chapter 4, Assignment 6
// Write a program that implements a stack class that is based on the Deque class
//To compile - javac stack.java
//To run - java stackApp

class stack
{
	private int maxSize;
	private long[] stackArray;
	private int top;
	private int nItems;
	
	public stack(int maxSize)
	{
		this.maxSize = maxSize;
		stackArray = new long[maxSize];
		nItems = 0;
		top = 0;
	}
	
	public boolean isEmpty()
	{
		if (nItems == 0)
			return true;
		else
			return false;
	}
	
	public boolean isFull()
	{
		if (nItems == maxSize)
			return true;
		else
			return false;
	}
	
	
	
	// push()	
	public void push(long j)
	{
	if(isFull())
			throw new RuntimeException("It's full");
		
		if (top == 0)
			top = maxSize;
		
		stackArray[--top] = j;
		nItems++;
		
		System.out.print(j + " ");
	}
	
	// pop()
	public long pop()
	{
		if (isEmpty())
			throw new RuntimeException("It's empty");
		
		long temp = stackArray[top];
		top++;
		
		if (top == maxSize)
			top = maxSize - 1;
	
		nItems--;
		return temp;
	}
	
	// peek()
	public long peek()
	{
		return stackArray[top];
	}
				
}

class stackApp
{
public static void main(String[] args)
	{
		stack theStack = new stack(2);
		
		System.out.print("Is it empty?: " + theStack.isEmpty());
		
		System.out.println("\n \n 2 Items Being Added ");
		
		theStack.push(12);
		theStack.push(22);
		
		System.out.print("\n Is it empty now?: " + theStack.isEmpty());
		
		System.out.print("\n Is it Full?: " + theStack.isFull());
	}
}

/* C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac stack.java

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java stackApp
Is it empty?: true

 2 Items Being Added
12 22
 Is it empty now?: false
 Is it Full?: true */