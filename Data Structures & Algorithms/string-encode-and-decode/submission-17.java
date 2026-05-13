class Solution {

    public String encode(List<String> strs) {
        StringBuilder res=new StringBuilder();
        for(String s:strs){
            res.append(s.length());
            res.append("#");
            res.append(s);
        }

        return res.toString();
    }

    public List<String> decode(String str) {

        List<String> res=new ArrayList<>();
        int i=0;
        while(i<str.length()){
            if(Character.isDigit(str.charAt(i))) {
            	String count=str.substring(i,str.indexOf('#', i, str.length()));        	
            	int startIndex = i+count.length()+1;
				res.add(str.substring(startIndex,(startIndex+Integer.parseInt(count))));
            	i+=count.length()+1+Integer.parseInt(count);
            }
        }

        return res;
    }
}
