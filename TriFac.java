//TriFac.java
//Joseph Charles Serrano
//Assignment 11
// 3/27/16
// fint the n-th triangular number and the n-th factorial number

//To compile:javac TriFac.java To run:java TriangleFactorApp
class TriangleFactorApp
{
	public static int recursiveTriangularNumbers(int n)
	{
		if(n==1)
			return 1;
		else
			return(n + recursiveTriangularNumbers(n-1) );
	}

	public static int recursiveFactorials(int n)
	{
		if(n==0)
			return 1;
		else
			return (n * recursiveFactorials(n-1) );
	}

	public static int iterativeTriangularNumbers(int n)
	{
		int total = 0;
		
		while(n > 0)
		{
			total = total + n;
			--n;
		}
		return total;
	}

	public static int iterativeFactorials(int n)
	{
		int total = 1;
		
		while(n > 0)
		{
			total = total * n;
			--n;
		}
		return total;
	}
	
	public static void main(String[] args) 
	{
		int result = 0;
		
		result = iterativeTriangularNumbers(7);
		System.out.println("iterativeTriangularNumbers(7): " + result);
		
		result = recursiveTriangularNumbers(7);
		System.out.println("recursiveTriangularNumbers(7): " + result);
		
		result = iterativeFactorials(5);
		System.out.println("iterativeFactorials(5): " + result);
		
		result = recursiveFactorials(5);
		System.out.println("recursiveFactorials(5): " + result);
	}
}

/* C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac TriFac.java

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java TriangleFactorApp
iterativeTriangularNumbers(7): 28
recursiveTriangularNumbers(7): 28
iterativeFactorials(5): 120
recursiveFactorials(5): 120 */