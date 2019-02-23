/*
CECS 328 Project 3
Programmers: Casey Sombrano, Irvin Flores, Jesus Ojeda
Program Requirements: Implement Build Max Heap using an array.
Output must follow:
1. Input Sequence
2. The output of max heap sequence
3. Height of the max heap.
NOTE: Output will not be a sorted array, it will be the max heap, with the highest
value in A[i]. Has to be able to handle 1-10 elements.
*/
import java.util.Arrays;
public class BuildMaxHeap
{
	int height;
	//default constructor
	public BuildMaxHeap()
	{
		
	}
	
	/*
	finds the height of heap tree
	@param int n - number of elements in array
	@return N/A
	*/
	public void calcHeight(int n)
	{
		int height = 0;
		//calculating the height
		//(log(base 2) n + 1)) - 1
		height = (int)Math.ceil(Math.log(n + 1) / Math.log(2)) - 1;
		setHeight(height);//setting height
	}
	/*
	sets the height
	@param int height - height if the heap tree
	@return N/A
	*/
	public void setHeight(int height)
	{
		this.height = height;
	}
	/*
	Returns height of the heap
	@param N/A
	@return int height - height of heap
	*/
	public int getHeight()
	{
		return height;
	}
	/*
	using algorithm from book
	@param int arr[] - array of elements
	@param int i - index of array
	@return N/A
	*/
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
	using algorithm from book
	@param int arr[] - array of elements
	@return N/A
	*/
	public void buildMaxHeap(int arr[])
	{
		for(int i = arr.length / 2 - 1; i >= 0; i--)
		{
			maxHeapify(arr, i);
		}
	}
	/*
	prints array elements
	@param int arr[] - array of elements
	@return String result - prints elements of array
	*/
	public String toString(int arr[])
	{
        String result = Arrays.toString(arr).replace(",", "").replace("[", "").replace("]", "");
		return result;
	}
	//main 
	public static void main(String[] args)
	{
		BuildMaxHeap bMH1 = new BuildMaxHeap();
		BuildMaxHeap bMH2 = new BuildMaxHeap();
		BuildMaxHeap bMH3 = new BuildMaxHeap();
		
		//using example provided
		int arr1[] = {4,5,1,7,3,3,8};
		//to test single element array
		int arr2[] = {5};
		//to test a 10 element array with duplicates
		int arr3[] = {2, 20, 15, 11, 7, 8, 15, 2, 5, 4};
		
		//prints contents of array 1
		System.out.println("Input Array:\n" + bMH1.toString(arr1));
		//building max heap and printing array
		bMH1.buildMaxHeap(arr1);
		//printing max heap array
		System.out.println("Max Heap Array:\n" + bMH1.toString(arr1));
		
		bMH1.calcHeight(arr1.length);
		//printing height of heap tree
		System.out.println("Height: " + bMH1.getHeight() + "\n");
		
		
		//prints contents of array 2
		System.out.println("Input Array:\n" + bMH2.toString(arr2));
		//building max heap and printing array
		bMH2.buildMaxHeap(arr2);
		//printing max heap array
		System.out.println("Max Heap Array:\n" + bMH2.toString(arr2));
		//calculating height
		bMH2.calcHeight(arr2.length);
		//printing height of heap tree
		System.out.println("Height: " + bMH2.getHeight() + "\n");
		
		
		//prints contents of array 3 
		System.out.println("Input Array:\n" + bMH3.toString(arr3));
		//building max heap and printing array
		bMH3.buildMaxHeap(arr3);
		//printing max heap array
		System.out.println("Max Heap Array:\n" + bMH3.toString(arr3));
		
		bMH3.calcHeight(arr3.length);
		//printing height of heap tree
		System.out.println("Height: " + bMH3.getHeight() + "\n");
		
	}
}