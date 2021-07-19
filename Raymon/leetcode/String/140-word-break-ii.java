class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        HashMap<String, List<List<String>>> map = new HashMap<>();
        helper(s, map, wordSet);
        List<String> result = new ArrayList<>();
        for(List<String> list : map.get(s)) {
            StringBuilder sb = new StringBuilder();
            String prefix = "";
            for (String element : list) {
                sb.insert(0, prefix).insert(0, element);
                prefix = " ";
            }
            result.add(sb.toString());
        }
        return result;
    }

    private void helper(String s, HashMap<String, List<List<String>>> map, HashSet<String> wordSet) {
        if (s.equals("")) {
            List<List<String>> result = new LinkedList<>();
            result.add(new LinkedList<String>());
            map.put("", result);
            return;
        }
        if (map.containsKey(s)) {
            return;
        }

        List<List<String>> solutions = new ArrayList<List<String>>();
        map.put(s, solutions);
        for (int i = 0; i < s.length(); i++) {
            String subString = s.substring(0, i+1);
            if (wordSet.contains(subString)) {
                helper(s.substring(i+1), map, wordSet);
                List<List<String>> subResult = map.get(s.substring(i+1));
                for(List<String> subList : subResult) {
                    List<String> currentList = new LinkedList<>(subList);
                    currentList.add(subString);
                    map.get(s).add(currentList);
                }
            }
        }
    }
}
