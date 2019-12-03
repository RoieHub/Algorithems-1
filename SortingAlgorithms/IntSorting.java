package SortingAlgorithms;


public class IntSorting
{
	public static void swap(int a , int b)
	{
		int temp = a ;
		a = b ;
		b = temp;
	}
	//O(n^2)
	public static void selectionSort( int [] a)
	{
		int length = a.length;
		int Min_Idx ;
		for ( int i = 0 ; i < length ; i++ )//where the pivot is
		{
			Min_Idx = i;
			for( int j = i ; j < length ; j++)
			{
				if(a[j] < a[Min_Idx])
				{
					int temp = a[Min_Idx];
					a[Min_Idx] = a[j];
					a[j] = temp;
				}


			}

		}

	}
	
	public static void boubleSort(int a[])
	{
		int length = a.length;
		boolean flag = true;
		int i = 1;
		while( i < length && flag)//finish if you went n^2 times or the array is sorted
		{
			flag = false;
			for (int j = 1 ; j < length ; j++)
				if(a[j]<a[j-1])
				{
					int temp = a[j]; 
					a[j] = a[j-1];
					a[j-1] = temp;
					flag = true;
				}
			i++;
		}

	}
	
	public static void insertionSort(int a[])
	{
		int key,j;
		for( int i = 1 ; i < a.length ; i++)
		{
			key = a[i];
			//select the first unsorted element
			j = i-1;
			while( j >= 0 && a[j] > key )
				//shift all elements to the right
			{
				a[j+1] = a[j];
				j = j-1;		
			}
			a[j+1]=key;
			//this inserts the unsorted element to its corrected position
		}
	}
	
	
	public static void countingSort(int a[])
	{
		int range = 0;
		for(int i = 0 ; i < a.length ; i++)//finding the max bound of the "a" array
			if(a[i] > range )
				range = a[i];
		int indexArr[] = new int [range+1];
		//new array which will count how many time every ellemnt in a appears
		for(int i = 0 ; i < a.length ;i++)
			indexArr[a[i]]++;
		//summing up the next elements for further correct placment in the new sortedArray
		for(int i = 1 ; i < indexArr.length ; i++)
			indexArr[i]=indexArr[i]+indexArr[i-1];
		
		int sortedArray[] = new int [a.length];
		for(int i = 0 ; i < a.length ; i++)
		{
			sortedArray[indexArr[a[i]]-1] = a[i];
			--indexArr[a[i]];
		}
		//the new  sorted and returned array
		
		for(int i = 0 ; i < a.length ; i++)
		a[i] = sortedArray[i];		
	}
	
	public static int digit(int m , int d)
	{
		for(int i = 0 ; i < d ; i++)
			m = m/10;
		return m%10;
	}
	public static int[] radixSort(int[] a,int maxLength)
	{
		for(int i = 0 ; i < maxLength ; i++)
		{
			int [] B = new int[a.length];
			int position = 0;
			for( int k = 0 ; k < 10 ; k++)
			{
				for( int j = 0 ; j < a.length ; j++)
				{
					int x =  digit(a[j] , i);
							if(x==k)
								B[position++] = a[j];
				}
			}
			for( int x = 0 ; x < a.length ;x++)
				a[x] = B[x];
		}
		
		return a;
	}
	public static void merge (int array1[] , int start , int mid ,int end)
	{
		int i = mid-start+1;
		int j = end-(mid);
		int newArray[] = new int[end-start+1];
		int index1 = 0;
		int index2 = 1;
		int newArrayIndex = 0; 
		while(index1 < i && index2 < (j+1))
		{
			if(array1[start+index1] < array1[mid+index2])
			{
				newArray[newArrayIndex]=array1[start+index1];index1++;
			}
			else 
			{
				newArray[newArrayIndex]=array1[mid+index2];index2++;
			}
				newArrayIndex++;
		}
		while(index1 < i)
		{
			newArray[newArrayIndex]=array1[index1+start];index1++;
			newArrayIndex++;
		}
		while(index2 < j+1)
		{
			newArray[newArrayIndex]=array1[index2+mid];index2++;
			newArrayIndex++;
		}
		for( int k = 0 ; k < (end-start+1) ; k++)
			array1[start+k] = newArray[k];
		
	}
	
	public static void mergeSort(int[] array , int start , int end)
	{
		
		if(end > start)
		{	
		int middle = (end + start)/2;
		 mergeSort(array, start, middle);
		 mergeSort(array, middle+1 , end);
		merge(array ,start ,middle ,end);
		}
		
		
	}

	public static int partition(int[] array , int low , int high)
	{
		int i = low;
		int j = high;
		int pivot = array[low];
		while(i<j)
		{
			do 
			{
				i++;
			}while(array[i]>=pivot);
			while(array[j]<pivot)
			{
				j--;
			}
			if(i > j)
			{	
				//swap array[i] and array [j]
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		//swap array [low] and array [j]
		int temp = array[low];
		array[low] = array[j];
		array[j] = temp;
		
		return j ;//partitioning position;
	}
	public static void quickSort(int array[])
	{
		int low = 0;
		int high = array.length -1;
	}
	public static void quickSort(int array[], int low , int high)
	{
		if(low < high)
		{
			int j = partition(array,low,high);
			quickSort(array , low , j);
			quickSort(array , j+1 , high);
		}
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//int a[] = new int[] {9,7,8,5,4,6,2,3,1};
		//selectionSort(a);
		//boubleSort(a);
		//insertionSort(a);
		//countingSort(a);
		int b[] = new int[] {1,4,1,2,7,5,2};
		quickSort(b);
	
		for(int i = 0 ; i<= b.length-1 ; i++)
			System.out.print("    "+b[i]+"  ,  ");
	/*	int was = 76543;
		int[] c = new int[] {170,45,75,90,802,24,2,66};
		int[] c1 = new int[] {170,45,75,90,802,24,2,66};
		long  startMerge = System.nanoTime();
		mergeSort(c,0,c.length-1);
		long  endMerge = System.nanoTime();
		quickSort(c1,0,c1.length-1);
		long  endQuick = System.nanoTime();
		//for(int i = 0 ; i < c.length ; i++)
			//System.out.println(c[i]);
		//System.out.println(digit(was,2));		
		System.out.println("merge sort took a fucking  "+(endMerge-startMerge)+ " ms , while quicky took only "+ (endQuick-endMerge));
*/	}

}
