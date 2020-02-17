import java.util.*;
public class mincost {

	
	public static int min(int a,int b,int c)
	{
		if(a<b)
		{
			return a<c?a:c;
		}
		else
			return b<c?b:c;
		
	}
	  public static int mincost(int[][]cost,int m,int n)
	  {
		  if(m<0|| n<0)
			  return Integer.MAX_VALUE;
		  
		  else if(m==0 && n==0)
			  return cost[m][n];
		  
		  else
			  return cost[m][n]+min(mincost(cost,m-1,n-1),
					  				mincost(cost,m,n-1)	,
					  				mincost(cost,m-1,n));
		  
	  }
	  public static int  mincost_dp(int [][]cost,int m,int n)
	  {
		  int tc[][]=new int[3][3];
		  tc[0][0]=cost[0][0];
		  for(int i=1;i<=m;i++)
		  {
			  tc[i][0]=cost[i][0]+tc[i-1][0];
		  }
		  for(int j=1;j<=n;j++)
		  {
			  tc[0][j]=cost[0][j]+tc[0][j-1];
		  }
		  for(int i=1;i<=m;i++)
		  {
			  for(int j=1;j<=n;j++)
			  {
				  tc[i][j]=cost[i][j]+min(tc[i-1][j-1],tc[i-1][j],tc[i][j-1]);
			  }
		  }
		  return tc[m][n];
	  }
		public static void main(String []args)
		{
			int [][]cost={{1,2,3},
							{4,8,2},
							{1,5,3}};
			int c1=mincost(cost,2,2);
			System.out.print("Using recursion the mincost is "+c1);
			int c2=mincost_dp(cost,2,2);
			System.out.print("Using DP the mincost is "+c2);

			
		}
}
