class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        List<Integer>[] freq=new List[nums.length+1];
        Map<Integer,Integer> counts=new HashMap<>();

        for(int p:nums)
        {
            counts.put(p,counts.getOrDefault(p,0)+1);
        }
        
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for(Integer key:counts.keySet())
        {
            freq[counts.get(key)].add(key);
        }

        
        System.out.println(Arrays.toString(freq));
        int count=0;
        int[] res=new int[k];
        for(int n=freq.length-1;n>=0&& count<k;n--)
        {
            for(int f:freq[n])
            {
                res[count++] = f;
                if (count == k) {
                    return res;
                }
            }

            

        }

        return res;

    }
}
