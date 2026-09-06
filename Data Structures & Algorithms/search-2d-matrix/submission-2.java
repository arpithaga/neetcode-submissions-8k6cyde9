class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0,r=matrix.length*matrix[0].length-1;

        while(l<=r){
            int mid=l+(r-l)/2;

            int x=mid/matrix[0].length;
            int y=mid%matrix[0].length;

            if(matrix[x][y]==target) return true;

            if(matrix[x][y]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return false;
    }
}
