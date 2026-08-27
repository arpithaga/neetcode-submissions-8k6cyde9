class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n=matrix.length-1;
        int top=0,left=0,bottom=matrix.length-1,right=matrix[0].length-1;

        while (top <= bottom && left <= right) {
            for(int q=top;q<=right;q++){
                result.add(matrix[top][q]);
            }
            top++;
            
            for(int q=top;q<=bottom;q++){
                result.add(matrix[q][right]);
            }
            right--;
            
            if(top<=bottom){
            for(int q=right;q>=left;q--){
                result.add(matrix[bottom][q]);
            }
            bottom --;
            }
            
            if(left<=right){
            for(int q=bottom;q>=top;q--){
                result.add(matrix[q][left]);
            }
            left++;  
            }       
     
        }

        return result;
    }
}
