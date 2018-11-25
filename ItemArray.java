//ItemArray.java 
//Joseph Charles Serrano
// 2/14/16
//Review Exercise, Assignment 1

class ItemArray 
{
	private Item[] arrItems;
	private int nElems;
	
	public ItemArray(int max) 
	{
		arrItems = new Item[max];
		nElems = 0;
	}
	
	public void insert(String itemName, double itemCost)
	{
		Item newItem = new Item(itemName, itemCost);
		arrItems[nElems] = newItem;
		nElems++;
	}
	
	public void display()            
	{
		System.out.println("Thank you. Your items were: ");
		
		for(int j=0; j<nElems; j++)       
		{
			Item i = arrItems[j];
			System.out.println(i.ItemName + " " + i.ItemCost);
		}
	}
	
	public void displayReverseOrder()            
	{
		System.out.println("Thank you. Your items in reverse order were: ");
		double totalcost = 0;
		boolean showAverage = false;
		
		for(int j=nElems-1; j>=0; j--)       
		{
			Item i = arrItems[j];
			System.out.println(i.ItemName + " " + i.ItemCost);
			totalcost = totalcost + i.ItemCost;
			
			if(i.ItemName.equalsIgnoreCase("peas"))
				showAverage = true;
			
		}
		
		if(showAverage)
			System.out.println("average price: " + (totalcost / nElems)); 
		else 
			System.out.println("no average output");
		
			
	}
}