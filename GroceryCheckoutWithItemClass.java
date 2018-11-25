//GroceryCheckoutWithItemClass.java 
//Joseph Charles Serrano
// 2/14/16
//Review Exercise, Assignment 1

import java.io.InputStream;
import java.util.Scanner;

class GroceryCheckoutWithItemClass 
{
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		int maxSize;
		String input;
		
		System.out.print( "How many items?  " );
		input = scanner.nextLine();
		
		maxSize = Integer.parseInt(input);
		
		ItemArray arr = new ItemArray(maxSize);
		
		int j;
		for (j=0; j < maxSize; j++)
		{
			System.out.print( "enter next item and price:  " );
			input = scanner.nextLine();
			String[] splited = input.split(" ");
			
			String itemName = splited[0];
			double itemCost = Double.parseDouble(splited[1]);
			//System.out.println( "itemname: " + splited[0]);
			//System.out.println( "itemprice: " + splited[1]);
			
			arr.insert(itemName, itemCost);
		}
		
		arr.display();
		
		System.out.println( "");
		
		arr.displayReverseOrder();
	}

}

/* C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java GroceryCheckoutWithItemClass
How many items?  5
enter next item and price:  grapes 2.4
enter next item and price:  cheese 5.2
enter next item and price:  peas 4.0
enter next item and price:  butter 5.9
enter next item and price:  milk 1.25
Thank you. Your items were:
grapes 2.4
cheese 5.2
peas 4.0
butter 5.9
milk 1.25

Thank you. Your items in reverse order were:
milk 1.25
butter 5.9
peas 4.0
cheese 5.2
grapes 2.4
average price: 3.75 */