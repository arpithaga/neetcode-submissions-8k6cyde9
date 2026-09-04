class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] times = new double[position.length][2];
		
		for(int i=0;i<position.length;i++) {
			times[i][0]=position[i];
			times[i][1]=(double)(target-position[i])/speed[i];
		}
		Arrays.sort(times,(a,b)->Double.compare(a[0], b[0]));
		
        double lastTime=0;
        int count=0;
        for(int i=position.length-1;i>=0;i--) {
        	double t=times[i][1];
        	
        	if(t>lastTime) {
                count++;
                lastTime=t;
            }
        	
        } 
        
        return count;
    }
}
