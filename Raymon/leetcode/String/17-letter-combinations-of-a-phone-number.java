class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letterArray= new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> list = new LinkedList<>();
        if (digits.length() == 0) {
            return list;
        }
        list.add("");
        for(Character num : digits.toCharArray()) {
            String strLetter = letterArray[Character.getNumericValue(num)];
            int size = list.size();
            for (int i = 0 ; i < size; i++) {
                String subSolution = list.removeFirst();
                for (Character letter : strLetter.toCharArray()) {
                    list.addLast(subSolution + letter);
                }
            }

        }
        return list;
    }
}
