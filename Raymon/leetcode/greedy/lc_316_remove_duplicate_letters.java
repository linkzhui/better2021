package greedy;

public class lc_316_remove_duplicate_letters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> lastSeenIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character chr = s.charAt(i);
            lastSeenIndex.put(chr, i);
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character chr = s.charAt(i);
            if (!set.contains(chr)) {
                while (!stack.isEmpty() && stack.peek() > chr && lastSeenIndex.get(chr) > i) {
                    set.remove(stack.pop());
                }
                stack.add(chr);
                set.add(chr);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
