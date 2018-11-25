//tree.java
//Joseph Charles Serrano
//Assignment 14
// 4/17/16
// type up tree.java, then add two methods to find the minimum and maximum values in the tree

import java.io.*;
import java.util.*;

class Node
{
	public int iData;
	public double dData;
	public Node leftChild;
	public Node rightChild;
	
	public void displayNode()
	{
		System.out.print('{');
		System.out.print(iData);
		System.out.print(", ");
		System.out.print(dData);
		System.out.print("} ");
		System.out.println("");
	}
}

class Tree
{
	private Node root;
	
	public Tree()
	{
		root = null;
	}
	
	public Node find(int key)
	{
		 Node current = root;
		 while(current.iData != key)
		 {
			 if(key < current.iData)
				 current = current.leftChild;
			 else
				 current = current.rightChild;
			 if(current == null)
				 return null;
		 }
	return current;
	}
	
	public void insert(int id, double dd)
	{
		Node newNode = new Node();
		newNode.iData = id;
		newNode.dData = dd;
		if(root==null)
			root = newNode;
		else
		{
			Node current = root;
			Node parent;
			while(true)
			{
				parent = current;
				if(id < current.iData)
				{
					current = current.leftChild;
					if(current == null)
					{
						parent.leftChild = newNode;
						return;
					}
				}
				else
				{
					current = current.rightChild;
					if(current == null)
					{
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public boolean delete(int key)
	{
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.iData != key)
		{
			parent = current;
			if(key < current.iData)
			{
				isLeftChild = true;
				current = current.leftChild;
			}
			else
			{
				isLeftChild = false;
				current = current.leftChild;
			}
			if(current == null)
				return false;
		}
		
		if(current.leftChild==null && current.rightChild==null)
		{
			if(current == root)
				root = null;
			else if(isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
		
		else if(current.rightChild==null)
			if(current == root)
				root = current.leftChild;
			else if(isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
			
			else if(current.leftChild==null)
				if(current == root)
					root = current.rightChild;
				else if(isLeftChild)
					parent.leftChild = current.rightChild;
				else
					parent.rightChild = current.rightChild;
				
				else
				{
					Node successor = getSuccessor(current);
					
					if(current == root)
						root = successor;
					else if(isLeftChild)
						parent.leftChild = successor;
					else
						parent.rightChild = successor;
					
					successor.leftChild = current.leftChild;
				}
				return true;
	}
	
	private Node getSuccessor(Node delNode)
	{
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while(current != null)
		{
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		
		if(successor != delNode.rightChild)
		{
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
	
	public void traverse(int traverseType)
	{
		switch(traverseType)
		{
			case 1: System.out.print("\nPreorder traversal: ");
			preOrder(root);
			break;
			case 2: System.out.print("\nInorder traversal: ");
			inOrder(root);
			break;
			case 3: System.out.print("\nPostorder traversal: ");
			postOrder(root);
			break;
		}
		System.out.println();
	}
	
	private void preOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	private void inOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}
	
	private void postOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}	
	}
	
	public void displayTree()
	{
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("..............................................");
		while(isRowEmpty==false)
		{
			Stack localStack = new Stack();
			isRowEmpty = true;
			
			for(int j=0; j<nBlanks; j++)
				System.out.print(' ');
			
			while(globalStack.isEmpty()==false)
			{
				Node temp = (Node)globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					
					if(temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<nBlanks*2-2; j++)
					System.out.print(' ');
			}
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
				globalStack.push( localStack.pop() );
		}
		System.out.println(".........................................");
	}
	
	private Node getMinimum(Node localRoot)
	{
		Node min = null;
		if (localRoot != null)
		{
			min = getMinimum(localRoot.leftChild);
			if (localRoot.leftChild == null)
			{
				return localRoot;
			}
		}
		return min;
	}
	//minimum()
 	public Node minimum()
	{
		return getMinimum(root);
	}
	
	private Node getMaximum(Node localRoot)
	{
		Node max = null;
		if (localRoot != null)
		{
			max = getMaximum(localRoot.rightChild);
			if (localRoot.rightChild == null)
			{
				return localRoot;
			}
		}
		return max;
	}
	//maximum()
	public Node maximum()
	{
		return getMaximum(root);
	} 
}

class TreeApp
{
	public static void main(String[] args) throws IOException
	{
		int value;
		Tree theTree = new Tree();
		
		theTree.insert(50, 1.5);
		theTree.insert(25, 1.2);
		theTree.insert(75, 1.7);
		theTree.insert(12, 1.5);
		theTree.insert(37, 1.2);
		theTree.insert(43, 1.7);
		theTree.insert(30, 1.5);
		theTree.insert(33, 1.2);
		theTree.insert(87, 1.7);
		theTree.insert(93, 1.5);
		theTree.insert(97, 1.5);
		
		while(true)
		{
			System.out.print("Enter letter:  ");
			System.out.print("(s)how, (i)nsert, (f)ind, (d)elete, (t)raverse, (m)inimum or ma(x)imum: ");
			int choice = getChar();
			switch(choice)
			{
				case 's':
					theTree.displayTree();
					break;
				case 'i':
					System.out.print("Enter value to insert: ");
					value = getInt();
					theTree.insert(value, value + 0.9);
					break;
				case 'f':
					System.out.print("Enter value to find: ");
					value = getInt();
					Node found = theTree.find(value);
					if(found != null)
					{
						System.out.print("Found: ");
						found.displayNode();
						System.out.print("\n");
					}
					else
						System.out.print("Could not find ");
						System.out.print(value + '\n');
					break;
				case 'd':
					System.out.print("Enter value to delete: ");
					value = getInt();
					boolean didDelete = theTree.delete(value);
					if(didDelete)
					{
						System.out.print("Deleted " + value + '\n');
					}
					else
						System.out.print("Could not delete ");
						System.out.print(value + '\n');
					break;
				case 't':
					System.out.print("Enter type 1, 2, or 3: ");
					value = getInt();
					theTree.traverse(value);
					break;
					// displaying minimum and maximum
				case 'm':
					Node min = theTree.minimum();
					min.displayNode();
					break;
				case 'x':
					Node max = theTree.maximum();
					max.displayNode();
					break;
				default:
					System.out.print("Invalid Empty");
			}
		}
	}
	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	
	public static int getInt() throws IOException
	{
		String s = getString(); 
		return Integer.parseInt(s);
	}
}

/* 
C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>javac tree.java
Note: tree.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

C:\Users\Charles\Documents\Charles_rec\JAVA lesson_2>java TreeApp
Enter letter:  (s)how, (i)nsert, (f)ind, (d)elete, (t)raverse, (m)inimum or ma(x)imum: s
..............................................
                                50
                25                              75
        12              37              --              87
    --      --      30      43      --      --      --      93
  --  --  --  --  --  33  --  --  --  --  --  --  --  --  --  97
.........................................
Enter letter:  (s)how, (i)nsert, (f)ind, (d)elete, (t)raverse, (m)inimum or ma(x)imum: i
Enter value to insert: 5
Enter letter:  (s)how, (i)nsert, (f)ind, (d)elete, (t)raverse, (m)inimum or ma(x)imum: s
..............................................
                                50
                25                              75
        12              37              --              87
    5      --      30      43      --      --      --      93
  --  --  --  --  --  33  --  --  --  --  --  --  --  --  --  97
.........................................
Enter letter:  (s)how, (i)nsert, (f)ind, (d)elete, (t)raverse, (m)inimum or ma(x)imum: m
{5, 5.9}
Enter letter:  (s)how, (i)nsert, (f)ind, (d)elete, (t)raverse, (m)inimum or ma(x)imum: x
{97, 1.5}
Enter letter:  (s)how, (i)nsert, (f)ind, (d)elete, (t)raverse, (m)inimum or ma(x)imum: i
Enter value to insert: 100
Enter letter:  (s)how, (i)nsert, (f)ind, (d)elete, (t)raverse, (m)inimum or ma(x)imum: x
{100, 100.9}
Enter letter:  (s)how, (i)nsert, (f)ind, (d)elete, (t)raverse, (m)inimum or ma(x)imum: s
..............................................
                                50
                25                              75
        12              37              --              87
    5      --      30      43      --      --      --      93
  --  --  --  --  --  33  --  --  --  --  --  --  --  --  --  97
 --------------------------------------------------------------100
.........................................
Enter letter:  (s)how, (i)nsert, (f)ind, (d)elete, (t)raverse, (m)inimum or ma(x)imum: t
Enter type 1, 2, or 3: 1

Preorder traversal: 50 25 12 5 37 30 33 43 75 87 93 97 100
Enter letter:  (s)how, (i)nsert, (f)ind, (d)elete, (t)raverse, (m)inimum or ma(x)imum: t
Enter type 1, 2, or 3: 2

Inorder traversal: 5 12 25 30 33 37 43 50 75 87 93 97 100
Enter letter:  (s)how, (i)nsert, (f)ind, (d)elete, (t)raverse, (m)inimum or ma(x)imum: t
Enter type 1, 2, or 3: 3

Postorder traversal: 5 12 33 30 43 37 25 100 97 93 87 75 50
Enter letter:  (s)how, (i)nsert, (f)ind, (d)elete, (t)raverse, (m)inimum or ma(x)imum: */