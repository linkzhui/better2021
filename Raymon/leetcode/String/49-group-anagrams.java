class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        if (strs.length == 0) {
            result.add(new LinkedList<>());
            return result;
        }
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (char element: str.toCharArray()) {
                counts[element - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < counts.length; i++) {
                sb.append(counts[i]).append("_");
            }
            List<String> subList = hashMap.getOrDefault(sb.toString(), new ArrayList<>());
            subList.add(str);
            if (subList.size() == 1) {
                hashMap.put(sb.toString(), subList);
            }
        }
        for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
