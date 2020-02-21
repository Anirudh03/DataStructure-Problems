/*Iterative approach(This will handle negative numbers as well)
1)we will have two variables say max_so_far and max_until_now.we will
intialize both the variables with first element of array a[0];
2)we  loop through the array and we will assign max_until_now=Math.max(a[i],max_until_now+a[i]);
3) we check if (max_so_far<max_until_now) max_so_far=max_until_now or max_so_far=Math.max(max_until_now,max_so_far);
4) we return max_so_far
*/
import java.util.*;
public class kandane {

	
	public static int kandanes(int[]arr)
	{
		int max_so_far=arr[0];
		int curr_max=arr[0];
		
		for(int i=1;i<arr.length;i++)
		{
			curr_max=Math.max(arr[i], curr_max+arr[i]);
			max_so_far=Math.max(curr_max,max_so_far);
		}
		return max_so_far;
	}
	public static void main(String []args)
	{
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
        System.out.print("Largest continous array sum"+kandanes(a));
	}
}
