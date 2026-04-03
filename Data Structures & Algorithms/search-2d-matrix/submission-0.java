class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS=matrix.length,COLS=matrix[0].length;
        int i=0,j=ROWS*COLS-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            int r= mid/COLS;
            int c= mid%COLS;
            if(matrix[r][c]==target){
                return true;
            }

            if(matrix[r][c]>target){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        
        return false;
    }
}
