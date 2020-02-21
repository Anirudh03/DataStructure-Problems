/*When we drop an egg from a floor x, 
there can be two cases (1) The egg breaks (2) The egg doesn’t break.

1) If the egg breaks after dropping from xth floor,
then we only need to check for floors lower than x with remaining eggs; 
so the problem reduces to x-1 floors and n-1 eggs
2) If the egg doesn’t break after dropping from the xth floor, then we only need to check 
for floors higher than x; so the problem reduces to k-x floors and n eggs.
*/
public class eggdrop {

	public static int max(int a,int b)
	{
		return a>b?a:b;
	}
	public static int breakegg(int n,int k)
	{
		if(k==1 ||k==0)
			return k;
		
		if(n==1)
			return k;
		
		int temp=Integer.MAX_VALUE;
		
		int res,i;
		for(i=1;i<=k;i++)
		{
			 res=Math.max(breakegg(n-1,i-1),breakegg(n,k-i));
					if(res<temp)
					{
						temp=res;
					}
		}
		return temp+1;
	}
	public static void main(String []args)
	{
		// k is the number of floors
		// n is the number of eggs.
		int n=2;
		int k=10;
		int trail=breakegg(n,k);
		System.out.print(trail);
	}
}
