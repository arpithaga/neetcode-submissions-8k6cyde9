class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs) {
        	int[] counts=new int[26];
        	for(char c:s.toCharArray()) {
        		counts[c-'a']++;
        	}
        	map.computeIfAbsent(Arrays.toString(counts), a->new ArrayList<>()).add(s);
        }    
        return new ArrayList<>(map.values());
    }
}
