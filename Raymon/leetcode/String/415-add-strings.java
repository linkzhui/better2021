class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int s1 = num1.length() -1;
        int s2 = num2.length() -1;
        while (s1 >= 0 || s2 >= 0) {
            //需要判断下有没有出界的问题，如果出界的话就是0
            int c1;
            if (s1 >= 0) {
                c1 = num1.charAt(s1) - '0';
                s1--;
            } else {
                c1 = 0;
            }
            int c2;
            if (s2 >= 0) {
                c2 = num2.charAt(s2) - '0';
                s2--;
            } else {
                c2 = 0;
            }

            int remain = (c1 + c2 + carry) % 10;
            carry = (c1 + c2 + carry) / 10;
            sb.insert(0, remain);
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
