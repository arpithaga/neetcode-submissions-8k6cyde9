class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        Set<List<Integer>> results =new HashSet<>();
        while(i<nums.length)
        {
            int j=i+1,k=nums.length-1;
            while(j<k)
            {
                if(nums[j]+nums[k]==-nums[i])
                {
                    results.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;k--;
                }else if(nums[j]+nums[k]>-nums[i]){
                    k--;
                }else
                {
                    j++;
                }
            }
            i++;
        }

        return results.stream().collect(Collectors.toList());
    }
}
