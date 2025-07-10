class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String repeat = word;
        while(sequence.contains(repeat)){
            count++;
            repeat += word;
        }
        return count;
    }
}