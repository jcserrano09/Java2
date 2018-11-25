

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

class SinglyLinkList
{
	private Link current;
	
	public SinglyLinkList(int id, double dd)
	{
		current = new Link(id,dd);
		current.next = current;
	}
	
	public void insert(int id, double dd)
	{
		Link newLink = new Link(id,dd);
		newLink.next = current;
		current = newLink;
	}
	
	public Link delete()
	{
		Link temp = current;
		current = current.next;
		return temp;
	}
	
	public void step()
	{
		current = current.next;
	}
	
	public void displayList()
	{
		current.displayLink();
		step();
		System.out.println("");
	}
}

class SinglyLinkListApp
{
	public static void main(String[] args)
	{
		SinglyLinkList theList = new SinglyLinkList(22, 2.99);
		theList.insert(33,3.99);
		
		theList.displayList();
		theList.displayList();
		theList.displayList();
		theList.displayList();
	}
}