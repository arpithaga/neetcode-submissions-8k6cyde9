	class TimeMap {

	    
	    Map<String,String[]> map=new HashMap<>();
	    public TimeMap() {
	        map=new HashMap<>();
	    }
	    
	    public void set(String key, String value, int timestamp) {

	        if(!map.containsKey(key)){
	            String[] times=new String[1001];
	            times[timestamp]=value;
	            map.put(key,times);
	        }else{
                String[] t=map.get(key);
                t[timestamp]=value;
                map.put(key,t);
            }
	        
	    }
	    
	    public String get(String key, int timestamp) {
            String[] val=map.get(key);
            if(timestamp>=1000) timestamp=1000;
            if(val!=null){
	        for(int p=timestamp;p>=0;p--){
                if(val[p]!=null && val[p]!="")
                   return val[p];
            }
            }

            return "";
	    }
	}