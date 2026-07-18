class Solution {
    public String foreignDictionary(String[] words) {
        List<Set<Integer>> list = new ArrayList<>();

		for(int i=0;i<26;i++){
			list.add(new HashSet<>());
		}
		
		boolean[] exists = new boolean[26];
		int[] indegree = new int[26];
		
		for(String w:words) {
			for(char c:w.toCharArray()) {
				exists[c-'a']=true;
			}
		}

		for(int i=0;i<words.length-1;i++){
			String w1 = words[i];
			String w2 = words[i+1];

			if(w1.length()>w2.length() && w1.startsWith(w2))
			{
				return "";
			}

			int minLength = Math.min(w1.length(),w2.length());
			for(int j=0;j<minLength;j++){
				if(w1.charAt(j) != w2.charAt(j)){
					int from =w1.charAt(j)-'a';
					int to =w2.charAt(j)-'a';
					if(list.get(from).add(to)){
						indegree[to]++;
					}
					break;
				}
			}

		}

		Queue<Integer> queue = new ArrayDeque<>();
		int total=0;
		for(int i=0;i<indegree.length;i++) {
			if(exists[i] && indegree[i]==0) {
				queue.add(i);
			}			
			if(exists[i]) total++;
		}

		StringBuilder sb = new StringBuilder();
		int count=0;
		
		while(!queue.isEmpty()) {
			
			int n= queue.poll();
			count++;
			
			sb.append((char)(n+'a'));
			
			for(int p:list.get(n)) {
				indegree[p]--;
				if(exists[p] && indegree[p]==0) {
					queue.add(p);
				}				
			}			
		}

		return count==total?sb.toString():""; 
    }
}
