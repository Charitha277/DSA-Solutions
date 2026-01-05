class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int negCount = 0;
        for(int[] row : matrix){
        for(int val : row){
            if(val < 0) negCount++;
            sum += Math.abs(val);
            min = Math.min(min, Math.abs(val));
        }
        }
        if(negCount % 2 == 1) {
            sum -= 2 * min;
        }
        return sum;
    }
}