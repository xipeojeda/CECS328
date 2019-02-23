import java.util.Arrays;
import java.util.Scanner;
public class MaxPriorityQueue
{
	private int arraySize;
	private int A[];
	
	//default constructor
	public MaxPriorityQueue()
	{
		
	}
	/*
	 * Find the index for its parent
	 * @param int i
	 * @return index of parent
	 */
	public int parent(int i)
	{
		return (i-1)/2;
	}
	
	/*
	using algorithm from book
	@param int arr[] - array of elements
	@return N/A
	*/
	public void buildMaxHeap(int a[])
	{
		for(int i = a.length / 2 - 1; i >= 0; i--)
		{
			maxHeapify(a, i);
		}
	}
	
	public void maxHeapify(int arr[], int i)
	{
		int largest = i; //initializing the largest index as root
		int l = 2 * i + 1;//left
		int r = 2 * i + 2;//right
		
		//if the left child is the larger than the root
		if(l < arr.length && arr[l] > arr[i])
			largest = l;
		else
			largest = i;
		//if the right child is the largest
		if(r < arr.length && arr[r] > arr[largest])
			largest = r;
		//if the largest is not the root
		if(largest != i)
		{
			//swapping a[i] with a[largest]
			int temp = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = temp; 
            //recursively max-heapify
			maxHeapify(arr, largest);
		}
	}
	
	/*
	 * Returns maximum node
	 * @param integer array a
	 * @return maximum
	 */
	public int maximum(int a[])
	{
		return a[0]; //returning index at zero, binary tree root
	}
	/*
	 * Removes maximum
	 * @param integer array a
	 * @return maximum
	 */
	public int extractMax(int a[])
	{
		int size = a.length;
		if (size <= 0)
		{
			System.out.println("Heap Underflow");
			return -1;
		}
		int max = a[0];
		a[0] = a[size-1];
		size--;
		maxHeapify(a, 0);
		return max;
	}
	
	public void increaseKey(int a[], int i, int key)
	{
		int temp = 0;
		if (key < a[i]) //if key is smaller print error and exit method
		{	
			System.out.println("ERROR: New key is smaller than current key");
		}	
		a[i] = key;
		while(i > 0 && a[parent(i)] < a[i])
		{
			temp = a[parent(i)];
			a[parent(i)] = a[i];
			a[i] = temp;
			i = parent(i);
		}
	}
	
	/*
	 * inserts new node into tree
	 * @param a[]
	 * @param key
	 * @return N/A
	 */
	public void insert(int a[], int key)
	{
		//book algorithm
		int size = a.length + 1;
		a[size-1] = Integer.MIN_VALUE;
		increaseKey(a,size,key);
	}
	
	/*
	prints array elements
	@param int a[] - array of elements
	@return String result - prints elements of array
	*/
	public String toString(int a[])
	{
        String result = Arrays.toString(a).replace(",", "").replace("[", "").replace("]", "");
		return result;
	}
	public static void main(String[] args)
	{
		MaxPriorityQueue mpq = new MaxPriorityQueue();
		
	}
}