/*
Base Case: if the row and col are zero then we return 0;
if row or col are zero we return 1.

The cell (m,n) can be reached from two cells.
        i) The one above it  (m-1,n)
        2) The one on the left side(m,n-1)
        if the are p1 ways of reaching (m-1,n) and p2 ways of
        reaching (m,n-1) then we have p1+p2 unique ways to reach (m,n) via
        (m-1,n) and (m,n-1).This defines our recrurison.
        
        return numOfPaths(m-1,n)+numOfPaths(m,n-1);
        
        The time complexity is exponential.
 */

public class totalpath {

	public static int numberOfPaths(int m,int n)
	{
		if(m==1 ||n==1)
			return 1;
		
		return numberOfPaths(m-1,n)+numberOfPaths(m,n-1);
	}
	public static int numberOfPaths_1(int m,int n)
	{
		int[][] cache=new int[m][n];
		for(int i=0;i<m;i++)
		{
			cache[i][0]=1;
		}
		for(int i=0;i<n;i++)
		{
			cache[0][i]=1;
		}
		for(int i=1;i<m;i++)
		{
			for(int j=1;j<n;j++)
			{
				cache[i][j]=cache[i-1][j]+cache[i][j-1];
			}
		}
		return cache[m-1][n-1];
	}
	public static void main(String[]args)
	{
        System.out.println(numberOfPaths(3, 3)); 
        System.out.println(numberOfPaths_1(3, 3)); 


	}
}
