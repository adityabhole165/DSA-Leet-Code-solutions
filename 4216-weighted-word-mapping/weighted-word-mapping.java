class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String result = "";

        for(int i =0;i< words.length; i++){
            int sum = 0;

            for(int j = 0; j< words[i].length(); j++){
                int index = words[i].charAt(j) - 'a';
                sum+= weights[index];
            }

            int mod = sum % 26;
            char mapped = (char)('z'-mod);
            result  += mapped;
        }
        return result;
    }
}