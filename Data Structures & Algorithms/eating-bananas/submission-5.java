class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int l=1,r=Arrays.stream(piles).max().getAsInt();
		int res=r;
		while(l<=r) {
			
			int mid= l+(r-l)/2;
			
			long total=0;
			
			for(int i:piles) {
				total+=Math.ceil((double)i/mid);
			}
			
			
			if(total<=h) {
				res=mid;
				r=mid-1;
			}else {
				l=mid+1;
			}
			
		}
		
		return res;

    }
}
