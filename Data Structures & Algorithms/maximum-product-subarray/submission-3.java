class Solution {
    public int maxProduct(int[] nums) {
       int maxProduct = nums[0];
		int minProduct = nums[0];
		int max = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int curr = nums[i];
			
			if(curr<0) {
				int temp = maxProduct;
				maxProduct = minProduct;
				minProduct = temp;
			}
			
			maxProduct = Math.max(curr, curr*maxProduct);
			minProduct = Math.min(curr, curr*minProduct);
			
			
			max = Math.max(max, maxProduct);
		}

		return max; 
    }
}
