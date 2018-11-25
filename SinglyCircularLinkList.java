//SinglyCircularLinkList.java
//Joseph Charles Serrano
// 3/13/16
//Chapter 5, Assignment 10
/* se the Circular List from Assignment 8 to insert the following Links
theList.insert(10); 
theList.insert(2); 
theList.insert(33); 
theList.insert(-40); 
theList.insert(55); 
theList.insert(-66); 
theList.insert(7);
Use the Circular List from Assignment 8 to insert the following Links
Create methods min() , max(), and sum() for the CircList class. */

/* To Compile = javac SinglyCircularLinkList
To run = java SinglyCircularLinkListApp */

class SinglyCircularLinkList
{
	private int data;
	private SinglyCircularLinkList current;
	
	public SinglyCircularLinkList()
	{
		data = 0;
		current = this;
	}
	
	public SinglyCircularLinkList(int value)
	{
		data = value;
		current = this;
	}
	
	public SinglyCircularLinkList insert(int value)
	{
		SinglyCircularLinkList node = new SinglyCircularLinkList(value);
		
		if(this.current == this)
		{
			node.current = this;
			this.current = node;
		}
		
		else
		{
			SinglyCircularLinkList temp = this.current;
			node.current = temp;
			this.current = node;
		}
		return node;
	}
	
	public int delete()
	{
		if(this.current == this)
		{
			System.out.println("The node can not be deleted as there is only one node in the circular list");
			return 0;
		}
		
		SinglyCircularLinkList node = this.current;
		this.current = this.current.current;
		node = null;
		return 1;
	}
	
	public void step()
	{
		step(this);
	}
	
	public void step(SinglyCircularLinkList node)
	{
		if (node == null)
			node = this;
		
		System.out.println("Stepping in Forward Direction");
		SinglyCircularLinkList startnode = node;
		
		do
		{
			System.out.println(node.data);
			node = node.current;
		}
		while (node != startnode);
	}
	
	public int getcount()
	{
		return getcount(this);
	}
	
	public int getcount(SinglyCircularLinkList node)
	{
		if (node == null)
			node = this;
		
		int count = 0;
		SinglyCircularLinkList startnode = node;
		
		do
		{
			count++;
			node = node.current;
		}
		while (node != startnode);
		
		System.out.println("Current Node Value: " + node.data);
		System.out.println("Total nodes in Circular List: " + count);
		
		return count;
	}
	
	public int min()
	{
		return min(this);
	}
	
	public int min(SinglyCircularLinkList node)
	{
		if (node == null)
			node = this;
		
		int imin = 999999;
		SinglyCircularLinkList startnode = node;
		
		do
		{
			if (node.data < imin)
			{
				imin = node.data;
			}
			node = node.current;
		}
		while (node != startnode);
		
		System.out.println("min: " + imin);
		
		return imin;
	}
	
	public int max()
	{
		return max(this);
	}
	
	public int max(SinglyCircularLinkList node)
	{
		if (node == null)
			node = this;
		
		int imax = -999999;
		SinglyCircularLinkList startnode = node;
		
		do
		{
			if (node.data > imax)
			{
				imax = node.data;
			}
			node = node.current;
		}
		while (node != startnode);
		
		System.out.println("max: " + imax);
		
		return imax;
	}
	
	public int sum()
	{
		return sum(this);
	}
	
	public int sum(SinglyCircularLinkList node)
	{
		if (node == null)
			node = this;
		
		int isum = 0;
		SinglyCircularLinkList startnode = node;
		
		do
		{
			isum += node.data;
			node = node.current;
		}
		while (node != startnode);
		
		System.out.println("sum: " + isum);
		
		return isum;
	}
}

class SinglyCircularLinkListApp
{
	public static void main(String[] args)
	{
		SinglyCircularLinkList theList = new SinglyCircularLinkList();
		
	theList.insert(10); 
	theList.insert(2); 
	theList.insert(33); 
	theList.insert(-40); 
	theList.insert(55); 
	theList.insert(-66); 
	theList.insert(7);
	
	theList.step();
	
	theList.min();
	theList.max();
	theList.sum();
	}
}

/* C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac SinglyCircularLinkList.java

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java SinglyCircularLinkListApp
Stepping in Forward Direction
0
7
-66
55
-40
33
2
10
min: -66
max: 55
sum: 1 */
