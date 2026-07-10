class Solution {
    	public boolean validTree(int n, int[][] edges) {
		
        if(edges.length!=n-1) return false;

		List<List<Integer>> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(new ArrayList<>());
		}
		for(int[] e:edges) {
			list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
		}
		boolean[] visited = new boolean[n];
        if(dfsCycleCheck(list,visited,0,-1)) return false;
		
        for(boolean b:visited){
            if(!b) return false;
        }

		return true;

    }

	private boolean dfsCycleCheck(List<List<Integer>> list, boolean[] visited, int i,int parent) {
	
		visited[i]=true;
		
		for(int v:list.get(i)) {
            if(v==parent) continue;
            if(visited[v]) return true;
			if(dfsCycleCheck(list,visited,v,i))
				return true;
		}
		
		return false;
	}
}