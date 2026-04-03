class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer[] indices=new Integer[position.length];
		for(int i=0;i<position.length;i++) {
			indices[i]=i;
		}
		Arrays.sort(indices,(a,b)->position[b]-position[a]);
		
		double pre=0;
		int fleet=0;
		for(int i:indices) {
			double time=(double)(target-position[i])/speed[i];
			if(time>pre) {
				fleet+=1;
				pre=time;
			}
		}
		
		return fleet;
    }
	
}
