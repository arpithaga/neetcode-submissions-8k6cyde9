class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  res=new ArrayList<>();
        permutations(nums,new ArrayList<>(),res);
        return res;
    }

    public void permutations(int[] nums,List<Integer> current,List<List<Integer>>  res){
            if(current.size()==nums.length){
                res.add(new ArrayList<>(current));
                return;
            }

            for(int i:nums){
                if(current.contains(i)) continue;
                current.add(i);
                permutations(nums,current,res);
                current.remove(current.size()-1);
            }
    }
}
