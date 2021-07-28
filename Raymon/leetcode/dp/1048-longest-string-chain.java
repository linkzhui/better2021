class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a,b) -> (a.length() - b.length()));
        int result = 1;
        for (String word : words) {
            int max = 0;
            for(int i = 0; i < word.length(); i++) {
                StringBuffer sb = new StringBuffer(word);
                sb.deleteCharAt(i);
                int curMax = map.getOrDefault(sb.toString(), 0);
                max = Math.max(max, curMax);
            }
            max++;
            map.put(word, max);
            result = Math.max(max, result);
        }
        return result;
    }
}
