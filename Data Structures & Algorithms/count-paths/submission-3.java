class Solution {
    Integer[][] grid;
    public int uniquePaths(int m, int n) {
        grid = new Integer[m+1][n+1];
        return dfsUnique(0,0,m,n);
    }

    public int dfsUnique(int i, int j, int m, int n){
        if(i>=m || j>=n) return 0;

        if(i==m-1 || j>=n-1) return 1;
        
        if(grid[i][j]!=null) return grid[i][j];

        int w=dfsUnique(i,j+1,m,n)+dfsUnique(i+1,j,m,n);

        return grid[i][j]=w;
    }
}
