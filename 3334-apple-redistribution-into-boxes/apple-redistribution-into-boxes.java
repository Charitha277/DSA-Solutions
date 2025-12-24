class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalapples = 0;
        for(int a : apple){
            totalapples += a;
        }
        Arrays.sort(capacity);

        int boxesused = 0;
        for(int i=capacity.length-1;i>=0;i--){
            totalapples -= capacity[i];
            boxesused++;
            if (totalapples<=0){
                break;
            }
        } 
        return boxesused;
           }
}