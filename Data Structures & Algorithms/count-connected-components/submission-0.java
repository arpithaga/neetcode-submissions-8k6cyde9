class Solution {
    int count=0;
    public int countComponents(int n, int[][] edges) {
    	
    	List<List<Integer>> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(new ArrayList<>());
		}
		for(int[] e:edges) {
			list.get(e[0]).add(e[1]);
			list.get(e[1]).add(e[0]);
		}
    	
    	
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,visited,list,-1);
            }
        }
        
        return count;
    }

	private void dfs(int i, boolean[] visited, List<List<Integer>> list, int parent) {
		
		if(i>=visited.length) {
			return;
		}
		
		visited[i]=true;
		
		for(int p:list.get(i)) {
			if(p==parent || visited[p]) continue;
			dfs(p,visited,list,i);
		}
		
	}
}