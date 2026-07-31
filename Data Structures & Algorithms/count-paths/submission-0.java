class Solution {
    Integer[][] visited;
	public int uniquePaths(int m, int n) {
        visited = new Integer[m][n];
		return dpUniquePaths(0,0,m,n);
    }

	private int dpUniquePaths(int i, int j, int m, int n) {
		
		if(i==m-1 || j==n-1) {
			return 1;
		}

        if(i>=m || j>=n) {
			return 0;
		}
		
		if(visited[i][j]!=null) return visited[i][j];
				
		int right = dpUniquePaths(i+1,j,m,n);
		int down = dpUniquePaths(i,j+1,m,n);
		
		return visited[i][j]=right+down;
	}
}
