import java.util.Arrays;

//Longest Substring without repeating characters in a given string
public class LSWRC {
	
	public static int lengthOfLongestSubstring(String str)
	{
		int[] seen=new int[128];
		Arrays.fill(seen,-1);
		int i=0,j=0,max=0;
		while(j<str.length())
		{
			char c=str.charAt(j);
			if(seen[c]>=i)
			{
				i=seen[c]+1;
			}
			seen[c]=j;
			j++;
			
			max=Math.max(max, j-i);
			
		}
		return max;
	}
	
	public static void main(String []args)
	{
		String s="abcabcbb";
		int k=lengthOfLongestSubstring(s);
		System.out.println("The length is "+k);
	}
}
