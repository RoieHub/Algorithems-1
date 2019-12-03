
public class AlgoTest

{
	
    private  static void testRandomArray()
    {
    	for(int size = 3 ; size < 40 ; size++)
    	{
    		int[] ans = Algorithems.makeRandomInt_array(size);
    		System.out.print("size = "+size );//printing the size
    		for(int j = 0 ; j < size ; j++ )//printing every element
    		{

    			System.out.println(ans[j]+ ",");
    		}
    	System.out.println();
    	}
    }
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		testRandomArray();

	}

}
