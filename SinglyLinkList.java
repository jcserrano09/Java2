//SinglyLinkList.java
//Joseph Charles Serrano
// 3/6/16
//Chapter 5, Assignment 8 
// Make a class for a singly linked circular list that has no end and no beginning. The only access to the list is a single reference, current, that can point to any link on the list. This reference can move around the list as needed
//javac SinglyLinkList.java
//java SinglyLinkListApp

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
	
	public boolean equals(Link other)
	{
		return (other.iData == this.iData && other.dData == this.dData);
	}
	
	public void displayLink()
	{
		System.out.print("{" + iData + "," + dData + "}");
	}
}

class SinglyLinkList
{
	private Link current;
	private Link head;
	
	public SinglyLinkList()
	{
		current = null;
		head = null;
	}
	
	public boolean isEmpty()
	{
		return (current==null);
	}
	
	public void insert(int id, double dd)
	{
		Link newLink = new Link(id,dd);
		newLink.next = current;
		current = newLink;
		
		if (head == null)
		{ head = newLink; }
	}
	
	public Link delete()
	{
		Link temp = current;
		current = current.next;
		return temp;
	}
	
	public void search(Link tmp)
	{
		while (!current.equals(tmp))
		{ step(); }
	}
	
	public void step()
	{
		current = current.next;
		if (current == null)
		{ current = head; }
	}
	
	public void displayList()
	{
		Link tmp = current;
		while (tmp != null)
		{
			tmp.displayLink();
			tmp = tmp.next;
		}
		System.out.println("");
	}
	
	public void displayHead()
	{
		System.out.println("Head data is " + "{" + head.iData + "," + head.dData + "}");
	}
	
	public void displayCurrent()
	{
		System.out.println("Current data is " + "{" + current.iData + "," + current.dData + "}");
	}

}

class SinglyLinkListApp
{
	public static void main(String[] args)
	{
		SinglyLinkList theList = new SinglyLinkList();
		theList.insert(11,1.99);
		theList.insert(22,2.99);
		theList.insert(33,3.99);
		theList.insert(44,4.99);
		
		theList.displayList();	
		theList.displayHead();
		theList.displayCurrent();
		theList.delete();
		theList.displayList();
		theList.displayCurrent();
		
		Link tmp = new Link(22,2.99);
		theList.search(tmp);
		theList.displayCurrent();
	}
}

/* C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java SinglyLinkListApp
{44,4.99}{33,3.99}{22,2.99}{11,1.99}
Head data is {11,1.99}
Current data is {44,4.99}
{33,3.99}{22,2.99}{11,1.99}
Current data is {33,3.99}
Current data is {22,2.99}
 */