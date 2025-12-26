class Solution {
    public int bestClosingTime(String s) {
        int y = 0, score = 0, ans = 0;
        for (char c : s.toCharArray()) if (c == 'Y') y++;
        int min = y;

        for (int i = 0; i < s.length(); i++) {
            score += (s.charAt(i) == 'N') ? 1 : -1;
            if (y + score < min) {
                min = y + score;
                ans = i + 1;
            }
        }
        return ans;
    }
}
