import java.util.*;
public class twoSum {

	public  List<Integer> bruteSum(int []nums,int target)
	{
		List<Integer> list=new ArrayList<Integer>();
		//brute force
		for(int i=0;i<nums.length;i++)
		{
			for(int j=i+1;j<nums.length;j++)
			{
				if(nums[i]+nums[j]==target)
				{
					list.add(i);
					list.add(j);
					break;
				}
			}
		}
		return list;
		//the method time complexity is O(n^2);
	}
	public List<Integer> optSum(int []nums,int target)
	{
		List<Integer> list=new ArrayList<Integer>();
		HashMap<Integer,Integer> myMap=new HashMap<Integer,Integer>();
		int complement=0;
		///using complement technique so that the 
		//time complexity is O(n);
		for(int i=0;i<nums.length;i++)
		{
			complement=target-nums[i];
			if(myMap.containsKey(complement))
			{
				list.add(myMap.get(complement));
				list.add(i);
				return list;
			}
			else
			{
				myMap.put(nums[i],i);
			}
		}
		return list;
	}
	public static void main(String []args)
	{
		int [] nums= {2, 7, 11, 15};
		twoSum obj=new twoSum();
		List<Integer> list=new ArrayList();
		 list=obj.bruteSum(nums,9);
			System.out.println(list);

		 list=obj.optSum(nums,9);
			System.out.println(list);

	}
}
																																												
