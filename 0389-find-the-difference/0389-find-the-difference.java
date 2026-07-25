class Solution {
    public char findTheDifference(String s, String t) {
        char ans =0;
        for(int c : s.toCharArray()){
            ans ^= c;
        }
        for(int c : t.toCharArray()){
            ans ^=c;
        }
        return ans;
    }
}