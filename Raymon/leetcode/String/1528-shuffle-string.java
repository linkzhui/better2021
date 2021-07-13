class Solution {
    public String restoreString(String s, int[] indices) {
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            while (indices[i] != i) {
                char temp = array[indices[i]];
                array[indices[i]] = array[i];
                array[i] = temp;
                int tempIndices = indices[i];
                indices[i] = ixndices[indices[i]];
                indices[tempIndices] = tempIndices;
            }
        }
        return String.valueOf(array);
    }
}
