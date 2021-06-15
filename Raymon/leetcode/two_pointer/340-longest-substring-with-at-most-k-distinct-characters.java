class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int startIndex = 0;
        int length = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char element = array[i];
            Integer elementCount = map.get(element);
            if (elementCount == null) {
                map.put(element, 1);
                count++;
            } else {
                map.put(element, elementCount + 1);
            }
            while (count > k) {
                elementCount = map.get(s.charAt(startIndex));
                if (elementCount != 1) {
                    map.put(s.charAt(startIndex), elementCount - 1);
                } else {
                    map.remove(s.charAt(startIndex));
                    count--;
                }
                startIndex++;
            }
            length = Math.max(i - startIndex + 1, length);
        }
        return length;
    }
}
