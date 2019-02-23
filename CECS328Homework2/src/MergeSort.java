import java.util.Arrays;

/*
 * Casey Sombrano, Irvin Flores, Jesus Ojeda
 * CECS 328 Homework 2
 * Problem Statement: Implement merge sort using arrays. 
 * It must output the following: 
 * 1. The input (unsorted sequence)
 * 2. The output (sorted sequence)
 * 3. The number of comparisons.
 * Program must use recursion
 */
public class MergeSort 
{	
	static int compCount;
	//default constructor
	public MergeSort()
	{
		
	}
	public void resetCounter()
	{
		compCount = 0;
	}
	/*
	performs merging portion of algorithm
	@param a[], p, q, r
	@return void
	*/
	public void merge(int a[], int p, int q, int r)
	{
		int n1 = q - p + 1;//size of left array
		int n2 = r - q; //size of right array
			
		int L[] = new int[n1 + 1];
		int R[] = new int[n2 + 1];
			
		for(int i = 0; i < n1; ++i)
		{
				L[i] = a[p + i];	
		}

		for(int j = 0; j < n2; ++j)
		{
				R[j] = a[q + j + 1];
		}

		//sentinel values
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
			
		int i = 0;
		int j = 0;
		int k = p;
		/* Constructing the final sorted array from
		 * previously sorted arrays
		 */
		for(k=p;i < n1 && j < n2;k++)
		{
			if (L[i] <= R[j])
			{
				a[k] = L[i];
				i = i + 1;
				compCount++;
			}

			else
			{
				a[k] = R[j];
				j = j + 1;
				compCount++;
			}
			
		}
		
		//just in case some swaps are missing
		while(i < n1)
		{
			a[k] = L[i];
			i = i + 1;
		}
		
		while(j < n2)
		{
			a[k] = R[j];
			j = j + 1;
		}
	}
	/*
	performs sorting portion of algorithm
	@param a[], p, r
	@return void
	*/
	public void sort(int a[],int p,int r)
	{
		if(p < r)
		{
			//divide
			int q = (p + r) / 2;
			//conquer
			sort(a,p,q);
			sort(a,q+1,r);
			//combine
			merge(a,p,q,r);
		}
	}
	/*
	prints contents of array
	@param a[]
	@return void
	*/
	public void print(int a[])
	{
		String result = Arrays.toString(a).replace(",", "").replace("[", "").replace("]", "");
		System.out.println(result);
	}
	
	public static void main(String[] args) 
	{
		MergeSort ms1 = new MergeSort();
		MergeSort ms2 = new MergeSort();
		MergeSort ms3 = new MergeSort();
		MergeSort ms4 = new MergeSort();
		MergeSort ms5 = new MergeSort();
		
		//printing unsorted array
		System.out.println("Unsorted Array");
		int a[] = {4, 5, 1, 7, 3, 3, 8};
		ms1.print(a);
		
		//printing sorted array
		System.out.println("Sorted Array");
		//passing array into sort method
		ms1.sort(a, 0, a.length-1);
		ms1.print(a);
		//printing comparison count should be 14
		System.out.println("Number of Comparisons: " + compCount);
		
		
		ms1.resetCounter();
		
		//printing unsorted array
		System.out.println("\nUnsorted Array");
		int b[] = {1, 2, 1};
		ms2.print(b);
		
		//printing sorted array
		System.out.println("Sorted Array");
		//passing array into sort method
		ms2.sort(b, 0, b.length-1);
		ms2.print(b);
		//printing comparison count should be 3
		System.out.println("Number of Comparisons: " + compCount);
		
		
		ms2.resetCounter();
		
		//printing unsorted array
		System.out.println("\nUnsorted Array");
		int c[] = {1};
		ms3.print(c);
		
		//printing sorted array
		System.out.println("Sorted Array");
		//passing array into sort method
		ms3.sort(c, 0, c.length-1);
		ms3.print(c);
		//printing comparison count should be 0
		System.out.println("Number of Comparisons: " + compCount);
		
		
		ms3.resetCounter();
		
		
		//printing unsorted array
		System.out.println("\nUnsorted Array");
		int d[] = {5, 5, 5, 5};
		ms4.print(d);
		
		//printing sorted array
		System.out.println("Sorted Array");
		//passing array into sort method
		ms4.sort(d, 0, d.length-1);
		ms4.print(d);
		//printing comparison count should be 4
		System.out.println("Number of Comparisons: " + compCount);
		
		
		ms4.resetCounter();
		
		//printing unsorted array
		System.out.println("\nUnsorted Array");
		int e[] = {10, -3, -800, 1, 16, 0};
		ms5.print(e);
		
		//printing sorted array
		System.out.println("Sorted Array");
		//passing array into sort method
		ms5.sort(e, 0, e.length-1);
		ms5.print(e);
		//printing comparison count should be 11
		System.out.println("Number of Comparisons: " + compCount);
		
		
		
	}

}
