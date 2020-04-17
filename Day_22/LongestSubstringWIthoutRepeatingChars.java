class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")||s==null)
            return 0;
        int start=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max_len=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++) {
            char key=s.charAt(i);
            map.put(key, map.getOrDefault(key,0)+1);
            while(map.get(key)>1) {
                char start_key=s.charAt(start);
                map.put(start_key,map.get(start_key)-1);
                start++;
            }
            max_len=Math.max(max_len,i-start+1);
        }
        return max_len;
        
    }
}
