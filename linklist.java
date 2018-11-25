//linklist.java program
//Joseph Charles Serrano
// 3/6/16
//Chapter 5, Assignment 7
//Modify main() so that it continuously inserts links into the list until memory is exhausted
//Compile - javac linklist.java
//To run - java LinkListApp

class Link
{
	public int iData;
	public double dData;
	public Link next;
	
	public Link(int id, double dd)
	{
		iData = id;
		dData = dd;
	}
	
	public void displayLink()
	{
		System.out.print("{" + iData + "," + dData + "}");
	}
}

class LinkList
{
	private Link first;
	
	public LinkList()
	{
		first = null;
	}
	
	public boolean isEmpty()
	{
		return (first==null);
	}
	
	public void insertFirst(int id, double dd)
	{
		Link newLink = new Link(id,dd);
		newLink.next = first;
		first = newLink;
	}
	
	public Link deleteFirst()
	{
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList()
	{
		System.out.print("List (first -> last): ");
		Link current = first;
		while(current != null)
		{
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}

class LinkListApp
{
	public static void main(String[] args)
	{
		/* 
		LinkList theList = new LinkList();
		
		theList.insertFirst(22, 2.99);
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);
		
		theList.displayList();
		
		while( !theList.isEmpty() )
		{
			Link aLink = theList.deleteFirst();
			System.out.print("Deleted ");
			aLink.displayLink();
			System.out.println("");
		}
		theList.displayList(); 
		*/
		int iCnt = 0;
		for (int iCounter = 0; iCounter < 1000000000; iCounter++)
		{
			LinkList theList = new LinkList();
			theList.insertFirst(iCounter, 1.99);
			if (iCounter % 1000 == 0)
			{
				System.out.println("Number of data in LinkList is: " + iCounter);
			}
			iCnt = iCounter;
		}
		System.out.println("Number of data in LinkList is: " + iCnt);
	}
}
