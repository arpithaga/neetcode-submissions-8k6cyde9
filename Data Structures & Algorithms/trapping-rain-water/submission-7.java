class Solution {
    public int trap(int[] height) {
        int sum = 0;
		int left = 0, right = height.length - 1;
		int lMax = 0, rMax = 0;
		while (left < right) {
			lMax = Math.max(lMax, height[left]);
			rMax = Math.max(rMax, height[right]);
			if (height[left] < height[right]) {
				int w = Math.min(lMax, rMax) - height[left];
				if (w < 0)
					w = 0;
				sum += w;
				left++;
			} else {
				int w = Math.min(lMax, rMax) - height[right];
				if (w < 0)
					w = 0;
				sum += w;
				right--;
			}

		}

		return sum;
    }
}
