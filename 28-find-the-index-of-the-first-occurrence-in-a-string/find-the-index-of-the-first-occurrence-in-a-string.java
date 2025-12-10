class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(m>n) return -1;
        int i =0,j=0;
        while(i<n){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j==m) return i-m;
            }else{
                i = i-j+1;
                j=0;
            }
        }
        return -1;
    }
}