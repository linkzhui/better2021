package greedy;

public class lc_738_monotone_increasing_digits {
    int num[] = new int[10];

    //32 -> 29
    //332 -> 299
    //232 -> 299
    //132 - > 99

    //我们发现一个规律，从右往左走，每次发现当前的数字不满足monotone increasing digits，我们就把current index value - 1, 然后current index往右的数字全部变成9，就可以产生一组新的数字，是当前index的最大monotone increasing digits
    public int monotoneIncreasingDigits(int n) {
        if (n < 10) {
            return n;
        }
        int count = 0;
        while (n > 0) {
            int cur_num = n % 10;
            n = n / 10;
            if (count == 0) {
                num[count] = cur_num;
            } else {
                if (cur_num <= num[count-1]) {
                    num[count] = cur_num;
                } else {
                    helper(count, cur_num);
                }
            }
            count++;
        }
        int result = 0;
        for (int i = 0; i < count; i++) {
            result += num[i] * Math.pow(10, i);
        }
        return result;

    }

    private void helper(int index, int cur_num) {
        num[index] = cur_num - 1;
        for (int i = index - 1; i >= 0; i--) {
            num[i] = 9;
        }
    }
}
