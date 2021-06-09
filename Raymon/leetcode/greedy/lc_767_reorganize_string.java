package greedy;

import java.util.PriorityQueue;

public class lc_767_reorganize_string {
    //把每个character出现的frequency存在一个int array里面
    //然后创建一个max heap来存这些character的freq
    //sb: 储存result
    //然后遍历pq，
    // 1. 当pq里面之后一个元素的时候，判断sb是不是空，
    //      如果sb不为空，判断sb里面最后一个元素是不是和当前元素相同
    //      如果sb为空
    //          判断最后元素是不是还剩1个
    //2.  每次从priority里面拿出两个元素，然后通过这两个元素来string，直到其中一个元素的count变为0
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (Character c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        PriorityQueue<CharCount> pq = new PriorityQueue<>((a, b) -> (b.count - a.count));
        for(int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                pq.add(new CharCount((char) (i + 'a'),freq[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                CharCount cur = pq.poll();
                if (sb.length() > 0 && sb.charAt(sb.length() -1) == cur.val) {
                    return "";
                } else if (cur.count > 1) {
                    return "";
                }
                return sb.append(cur.val).toString();
            }
            else {
                CharCount first = pq.poll();
                CharCount second = pq.poll();
                while (first.count != 0 && second.count != 0) {
                    sb.append(first.val).append(second.val);
                    first.count--;
                    second.count--;
                }
                if (first.count != 0) {
                    pq.add(first);
                }
                if (second.count != 0) {
                    pq.add(second);
                }
            }
        }
        return sb.toString();
    }

    class CharCount{
        char val;
        int count;
        public CharCount(char val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
