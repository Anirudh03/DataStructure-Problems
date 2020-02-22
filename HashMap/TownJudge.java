class Solution {

  //Approach 1:
    public int findJudge(int N, int[][] trust) {
    
        if(trust.length==0)
            return 1;
        
        //town array to maintain the key and its associated values in list
        HashMap<Integer,List<Integer>> town=new HashMap<>();
        
        for(int[]t:trust)
        {
            
            List<Integer> l=town.getOrDefault(t[0],new ArrayList<>());
            l.add(t[1]);
            town.put(t[0],l);
            
        }
        //trustcount map is  to get the values of townmap 
        //mapping the values and its corresponding count
        HashMap<Integer,Integer> trustCount=new HashMap<>();
        for(List<Integer>l:town.values())
        {
            for(Integer i:l)
            {
                int num=trustCount.getOrDefault(i,0)+1;
                trustCount.put(i,num);
            }
        }
        System.out.print("the trust count is"+trustCount);
        
        for(Map.Entry<Integer,Integer> entry:trustCount.entrySet())
        {
            if(entry.getValue()==N-1&&!town.containsKey(entry.getKey()))
            {
                return entry.getKey();
            }
        }
        return -1;
}
  Approach 2:
  public int findJudge(int N, int[][] trust) {
        
        if (N == 0) return -1;
        if (N == 1) return 1;
        if (N > 1 && trust.length == 0) return -1;
        
        int[] count = new int[N+1];
        for (int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
}
