class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        List<Integer>[] list=new List[nums.length+1];

        Map<Integer,Integer> counts=new HashMap<>();
        for(int i:nums)
        {
            counts.put(i,counts.getOrDefault(i,0)+1);
        }

        for(int i=0;i<list.length;i++)
        {
            list[i]=new ArrayList<>();
        }

        for(int key:counts.keySet())
        {
            list[counts.get(key)].add(key);
        }

        int c=0;
        int[] res=new int[k];
        for(int i=list.length-1;i>=0&&c<k;i--)
        {
            for(int d:list[i])
            {

                res[c]=d;
                c++;
            }
        }
        return res;
    }
}
