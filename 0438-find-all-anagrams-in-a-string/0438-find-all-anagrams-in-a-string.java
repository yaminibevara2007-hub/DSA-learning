class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans= new ArrayList<>();
        if(p.length()>s.length()){
            return ans;
        }
        int [] freq =new int[26];
        for(int i=0;i<p.length();i++){
            freq[p.charAt(i)-'a']++;
        }
        int left =0;
        int count=p.length();
        for(int right=0;right<s.length();right++){
            if(freq[s.charAt(right)-'a']>0){
                count--;
            }
            freq[s.charAt(right)-'a']--;
        
        if(right-left+1 >p.length()){
           if(freq[s.charAt(left)-'a']>=0){
            count++;
           }
           freq[s.charAt(left)-'a']++;
           left++;
        }
             if(count==0){
                ans.add(left);
             }
        }
             return ans;
    }
}