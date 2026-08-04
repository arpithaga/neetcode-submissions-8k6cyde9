class Solution {
    
    public int uniquePaths(int m, int n) {
        int[] grid = new int[m];
        Arrays.fill(grid,1);
        for(int j=1;j<n;j++){
            for(int i=1;i<m;i++){
                grid[i]=grid[i-1]+grid[i];
            }
         }
        

        return grid[m-1];
    }
}
