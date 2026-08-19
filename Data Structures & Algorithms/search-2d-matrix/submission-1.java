class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int targetRow = 0;
        int cols = matrix[0].length;

        for(int i=0;i<matrix.length;i++){
            if(target >= matrix[i][0] && target <= matrix[i][cols-1]){
                targetRow = i;
                break;
            }
        }

        int i=0 , j=cols-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(matrix[targetRow][mid] == target) return true;
            else if(target < matrix[targetRow][mid]) j=mid-1;
            else i=mid+1;
        }

        return false;
    }
}
