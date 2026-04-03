	class Pair {
	
	String val;
	int Timestamp;
	public Pair(String val, int timestamp) {
		super();
		this.val = val;
		Timestamp = timestamp;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public int getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(int timestamp) {
		Timestamp = timestamp;
	}

}

	class TimeMap {
		Map<String,List<Pair>> map=new HashMap<>();
    public TimeMap() {
		map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        if(!map.containsKey(key)){
            List<Pair> times=new ArrayList<>();
            times.add(new Pair(value,timestamp));
            map.put(key,times);
        }else{
        	List<Pair> times=map.get(key);
        	times.add(new Pair(value,timestamp));
            map.put(key,times);
        }
        
    }
    
    public String get(String key, int timestamp) {
        List<Pair> val=map.getOrDefault(key,new ArrayList<>());
        int i=0;int j=val.size()-1;
        String result="";
        while(i<=j) {
        	int mid=i+(j-i)/2;
        	if(val.get(mid).getTimestamp()<=timestamp) {
        		result=val.get(mid).getVal();
        		i=mid+1;
        	}else{
        		j=mid-1;
        	}     	
        }

        return result;
    }
	}