class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i=1;
        int j=Arrays.stream(piles).max().getAsInt();
        int res=j;
        while(i<=j){
        	int speed=((i+j)/2);
            long time=0;
            for(int p:piles){
                time+=Math.ceil((double)p/speed);
            }
            
            if(time<=h) {
            	res=speed;
            	j=speed-1;
            }else {
            	i=speed+1;
            }
        }
        
        return res;
    }
}
