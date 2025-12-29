class Solution {
    Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed)
            map.computeIfAbsent(s.substring(0,2), k -> new ArrayList<>())
               .add(s.charAt(2));
        return dfs(bottom, "");
    }

    boolean dfs(String cur, String next) {
        if (cur.length() == 1) return true;
        if (next.length() == cur.length() - 1)
            return dfs(next, "");

        String key = cur.substring(next.length(), next.length() + 2);
        if (!map.containsKey(key)) return false;

        for (char c : map.get(key))
            if (dfs(cur, next + c)) return true;

        return false;
    }
}
