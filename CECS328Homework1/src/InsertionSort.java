/*
 * Casey Sombrano, Irvin Flores, Jesus Ojeda
 * CECS 328 Homework 1
 * Problem Statement: Implement insertion sort using linked list. 
 * It must output the following: 
 * 1. The input (unsorted sequence)
 * 2. The output (sorted sequence)
 * Program must use linked list
 */
import java.util.Scanner;
class Node
{
	public String data;
	public Node next;
	//default constructor
	public Node()
	{
		
	}
	/*
	 * returns data in node
	 * @param N/A
	 * @return string data
	 */
	public String getData()
	{
		return data;
	}
	/*
	 * sets node data
	 * @param String s
	 * @return N/A
	 */
	public void setData(String s)
	{
		s = data;
	}

}

class LinkedList
{
	private Node head;
	//default constructor
	public void LinkedList()
	{
		
	}
	/*
	 * adds to the head of linked list
	 * @param String data
	 * @return N/A
	 */
	public void addHead(String data)
	{
		Node temp = new Node();
		temp.data = data;
		temp.next = head;
		head = temp;
	}
	/*
	 * adds to the end of linkedlist
	 * @param String data
	 * @return N/A
	 */
	public void addTail(String data)
	{
		Node current = head;
		if(current == null)
		{
			addHead(data);
		}
		else
		{
			while(current.next != null)
			{
				current = current.next;
			}
			Node temp = new Node();
			temp.data = data;
			current.next = temp;
		}
	}
	/*
	 * Implements insertion sort
	 * @param N/A
	 * @return N/A
	 */
	public void sort()
	{
		Node node = head;
		if(node == null)
		{
			return; 
		}
		Node sortedList = node;
		node = node.next;
		sortedList.next = null;
		while(node != null)
		{
			final Node current = node;
			node = node.next;
			if(current.data.compareTo(sortedList.data) < 0)
			{
				current.next = sortedList;
				sortedList = current;
			}
			else
			{
				Node search = sortedList;
				while(search.next != null && current.data.compareTo(search.next.data) > 0)
				{
					search = search.next;
				}
				current.next = search.next;
				search.next = current;
			}
		}
		head = sortedList;
	}
	/*
	 * gets current node at an index
	 * @param int x
	 * @return N/A
	 */
	public Node getNode(int x)
	{
		Node current = head;
		int count = 0;
		while(current != null)
		{
			if(count == x)
			{
				return current;
			}
			count++;
			current = current.next;
		}
		
		return null;
	}
	/*
	 * returns head of linked list
	 * @param N/A
	 * @return head
	 */
	public Node getHead()
	{
		return head;
	}
	
	/*
	 * prints linked list
	 * @param N/A
	 * @return String result
	 */
	public String toString()
	{
		String result = "";
		Node current = head;
		while(current != null)
		{
			result += current.data + " ";
			current = current.next;
		}
		return result;
	}
}
//InsertionSort Class
public class InsertionSort
{
	public static void main(String[] args)
	{
		LinkedList ll = new LinkedList();
		
		String str = "what if cat really spelled dog i dont know what else to put so this just a filler so yeah";
		System.out.println("Original: " + str);
		Scanner s = new Scanner(str).useDelimiter("\\s");  
		while( s.hasNext() )
		{  
			ll.addTail(s.next());//adding words to tail of linkedlist
		}  
	    s.close();  
	    //sorting and printing sorted sentence
	    ll.sort();
	    System.out.println("Sorted: " + ll.toString());
		
	}
}