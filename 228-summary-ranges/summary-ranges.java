import java.util.*;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0, n = nums.length;

        while (i < n) {
            int start = i;
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            if (start == i) {
                res.add(String.valueOf(nums[i]));
            } else {
                res.add(nums[start] + "->" + nums[i]);
            }
            i++;
        }

        return res;
    }
}
