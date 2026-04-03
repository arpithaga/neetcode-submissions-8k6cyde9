class Solution {
    public int findKthLargest(int[] nums, int k) {

		int l = 0;
		int r = nums.length - 1;
		k = nums.length - k;
		return quickSelect(nums, l, r, k);

	}

	private int quickSelect(int[] nums, int l, int r, int k2) {

		if (l == r)
			return nums[l];

		int p = l;
		int pivot = nums[r];

		for (int i = l; i < r; i++) {

			if (nums[i] <= pivot) {
				swap(nums, p, i);
				p++;
			}

		}

		swap(nums, p, r);

		if (p == k2)
			return nums[p];

		if (p > k2) {
			r = p - 1;
			return quickSelect(nums, l, r, k2);
		} else {
			l = p + 1;
			return quickSelect(nums, l, r, k2);
		}

	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
