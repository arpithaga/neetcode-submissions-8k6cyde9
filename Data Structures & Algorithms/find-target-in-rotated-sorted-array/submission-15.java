class Solution {
    public int search(int[] nums, int target) {

		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
            if (nums[mid] == target)
				return mid;
			else if (nums[mid] > nums[r]) {
                int binarySearch = binarySearch(nums, target, l,mid-1);
				if (binarySearch != -1)
					return binarySearch;
				l = mid + 1;
			} else {
				int binarySearch = binarySearch(nums, target, mid+1,r);
				if (binarySearch != -1)
					return binarySearch;
                r=mid;
			}
		}
		return nums[l]==target?l:-1;
	}

	public int binarySearch(int[] nums, int target, int l, int r) {
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}
}
