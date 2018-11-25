//DoubleLinkedDeque.java
//Joseph Charles Serrano
// 3/20/16
//Project 1
//Complete Double Linked, Double Ended Queue  Test your program extensively, and submit all test runs as a multiline comment /* */ at the bottom of your code in order to show how it works.
//To compile DoubleLinkedDeque.java
//To Run doublelinkedDoubleEndedQueueApp
 
 class aLink
 {
	public int data;
	public aLink next;
	public aLink previous;
	 
	public aLink(int x) 
	{
		data = x;
		next = null;
		previous = null;
	}
 }
 
class doublelinkedDoubleEndedQueue
{
	private aLink first;
	private aLink last;

	public doublelinkedDoubleEndedQueue() 
	{
		
	}
	
	public void showQueue()
	{
		aLink tmp = first;
		
		System.out.print("Queue data: ");
		
		do
		{
			System.out.print(tmp.data + " ");
			
			if (tmp.next != null)
			{
				tmp = tmp.next;
			}
		}
		while (tmp != last);
		
		System.out.print(last.data + " ");
		
		System.out.println("");
		
	}

	public void insertFirstLeft(int x)
	{
		aLink lnk = new aLink(x);
		
		if (first == null) 
		{
			first = lnk;
			last = lnk;
		}
		else 
		{
			aLink tmp = first;
			lnk.next = tmp;
			tmp.previous = lnk;
			
			first = lnk;
		}
	}

	public void insertFirstRight(int x)
	{
		aLink lnk = new aLink(x);
		
		if (last == null) 
		{
			first = lnk;
			last = lnk;
		}
		else 
		{
			aLink tmp = last;
			lnk.previous = tmp;
			tmp.next = lnk;
		
			last = lnk;
		}
		
	}

	public void removeFirstLeft()
	{
		if (first == null)
		{
			System.out.println("Queue is empty");
		}
		else 
		{
			aLink tmp = first;
			first = tmp.next;
			tmp = null;
		}
	}

	public void removeFirstRight()
	{
		if (last == null)
		{
			System.out.println("Queue is empty");
		}
		else 
		{
			aLink tmp = last;
			last = tmp.previous;
			tmp = null;
		}
	}

	public void insertinAscendingOrder(int x)
	{
		aLink lnk = new aLink(x);
		
		aLink tmp = first;
		
		do
		{
			if (x > tmp.data & x < tmp.next.data)
			{
				lnk.next = tmp.next;
				lnk.previous = tmp;
				tmp.next = lnk;
				
				break;
			}
			
			if (tmp.next != null)
			{
				tmp = tmp.next;
			}
		}
		while (tmp != last);
		
		if (tmp == last)
		{
			insertFirstRight(x);
		}
	}

	public void removeLink(int x)
	{	
		aLink tmp = first;
		boolean isFound = false;
		
		do
		{
			if (x == tmp.data)
			{
				aLink lnk = tmp.previous;
				lnk.next = tmp.next;
				tmp = null;
				isFound = true;
				break;
			}
			
			if (tmp.next != null)
			{
				tmp = tmp.next;
			}
		}
		while (tmp != last);
		
		if (x == last.data)
		{
			aLink lnk = last;
			last = lnk.previous;
			lnk = null;
			isFound = true;
		}
		
		if (!isFound)
		{
			System.out.println("Link is not found");
		}
	}
 }
 
class doublelinkedDoubleEndedQueueApp 
{
	public static void main(String[] args)
	{
		System.out.println("Initialize Queue");
		doublelinkedDoubleEndedQueue linkList = new doublelinkedDoubleEndedQueue();
		linkList.insertFirstLeft(100);	
		linkList.insertFirstLeft(50);
		linkList.insertFirstLeft(40);	
		linkList.insertFirstLeft(30);
		linkList.insertFirstLeft(20);
		linkList.insertFirstLeft(10);
		linkList.insertFirstLeft(5);	
		linkList.insertFirstLeft(-100);
		linkList.showQueue();
		System.out.println("");
		
		System.out.println("insertFirstLeft(-200)");
		linkList.insertFirstLeft(-200);
		linkList.showQueue();
		System.out.println("");
		
		System.out.println("insertFirstRight(200)");
		linkList.insertFirstRight(200);
		linkList.showQueue();
		System.out.println("");
		
		System.out.println("insertinAscendingOrder(6)");
		linkList.insertinAscendingOrder(6);
		linkList.showQueue();
		System.out.println("");
		
		System.out.println("removeFirstLeft");
		linkList.removeFirstLeft();
		linkList.showQueue();
		System.out.println("");
		
		System.out.println("removeFirstRight");
		linkList.removeFirstRight();
		linkList.showQueue();
		System.out.println("");
		
		System.out.println("removeLink(40)");
		linkList.removeLink(40);
		linkList.showQueue();
		System.out.println("");
		
		//removing 40 a second time
		System.out.println("removeLink(40)");
		linkList.removeLink(40);
		linkList.showQueue();
		System.out.println("");

	}
}

/* C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac DoubleLinkedDeque.java

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java doublelinkedDoubleEndedQueueApp
Queue data: -100 5 10 20 30 40 50 100
Queue data: -200 -100 5 10 20 30 40 50 100
Queue data: -200 -100 5 10 20 30 40 50 100 200
Queue data: -200 -100 5 6 10 20 30 40 50 100 200

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac DoubleLinkedDeque.java

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java doublelinkedDoubleEndedQueueApp
Queue data: -100 5 10 20 30 40 50 100
Queue data: -200 -100 5 10 20 30 40 50 100
Queue data: -200 -100 5 10 20 30 40 50 100 200
Queue data: -200 -100 5 6 10 20 30 40 50 100 200
Queue data: -200 -100 5 6 10 20 30 40 50 100 200 300

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac DoubleLinkedDeque.java

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java doublelinkedDoubleEndedQueueApp
Queue data: -100 5 10 20 30 40 50 100
Queue data: -200 -100 5 10 20 30 40 50 100
Queue data: -200 -100 5 10 20 30 40 50 100 200
Queue data: -200 -100 5 6 10 20 30 40 50 100 200
Queue data: -100 5 6 10 20 30 40 50 100 200
Queue data: -100 5 6 10 20 30 40 50 100

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac DoubleLinkedDeque.java

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java doublelinkedDoubleEndedQueueApp
Initialize Queue
Queue data: -100 5 10 20 30 40 50 100

insertFirstLeft(-200)
Queue data: -200 -100 5 10 20 30 40 50 100

insertFirstRight(200)
Queue data: -200 -100 5 10 20 30 40 50 100 200

insertinAscendingOrder(6)
Queue data: -200 -100 5 6 10 20 30 40 50 100 200

removeFirstLeft
Queue data: -100 5 6 10 20 30 40 50 100 200

removeFirstRight
Queue data: -100 5 6 10 20 30 40 50 100


C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac DoubleLinkedDeque.java

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java doublelinkedDoubleEndedQueueApp
Initialize Queue
Queue data: -100 5 10 20 30 40 50 100

insertFirstLeft(-200)
Queue data: -200 -100 5 10 20 30 40 50 100

insertFirstRight(200)
Queue data: -200 -100 5 10 20 30 40 50 100 200

insertinAscendingOrder(6)
Queue data: -200 -100 5 6 10 20 30 40 50 100 200

removeFirstLeft
Queue data: -100 5 6 10 20 30 40 50 100 200

removeFirstRight
Queue data: -100 5 6 10 20 30 40 50 100

removeLink(40)
Link is not found
Queue data: -100 5 6 10 20 30 50 100


C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac DoubleLinkedDeque.java

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java doublelinkedDoubleEndedQueueApp
Initialize Queue
Queue data: -100 5 10 20 30 40 50 100

insertFirstLeft(-200)
Queue data: -200 -100 5 10 20 30 40 50 100

insertFirstRight(200)
Queue data: -200 -100 5 10 20 30 40 50 100 200

insertinAscendingOrder(6)
Queue data: -200 -100 5 6 10 20 30 40 50 100 200

removeFirstLeft
Queue data: -100 5 6 10 20 30 40 50 100 200

removeFirstRight
Queue data: -100 5 6 10 20 30 40 50 100

removeLink(40)
Queue data: -100 5 6 10 20 30 50 100


C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac DoubleLinkedDeque.java

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java doublelinkedDoubleEndedQueueApp
Initialize Queue
Queue data: -100 5 10 20 30 40 50 100

insertFirstLeft(-200)
Queue data: -200 -100 5 10 20 30 40 50 100

insertFirstRight(200)
Queue data: -200 -100 5 10 20 30 40 50 100 200

insertinAscendingOrder(6)
Queue data: -200 -100 5 6 10 20 30 40 50 100 200

removeFirstLeft
Queue data: -100 5 6 10 20 30 40 50 100 200

removeFirstRight
Queue data: -100 5 6 10 20 30 40 50 100

removeLink(40)
Queue data: -100 5 6 10 20 30 50 100

removeLink(40)
Link is not found
Queue data: -100 5 6 10 20 30 50 100


C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2> */

//I had way more stuff tested, but it got lost



