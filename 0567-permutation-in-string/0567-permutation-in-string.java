class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int freq[] = new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        int left=0,matched=0;
        for(int right=0;right<s2.length();right++){
            char ch = s2.charAt(right);
            if(freq[ ch -'a']>0){
                matched++;
            }
            freq[s2.charAt(right)-'a']--;
            if(right-left+1>s1.length()){
                char leftChar = s2.charAt(left);
                if(freq[leftChar-'a']>=0){
                    matched--;
                }
                freq[leftChar-'a']++;
                left++;
            }
            if(matched == s1.length()){
                return true;
            }
        }
        return false;
    }
}