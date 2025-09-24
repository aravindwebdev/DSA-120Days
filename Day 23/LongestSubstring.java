import java.util.*;
class LongestSubstring{
    public static void main(String[] args){
        String s1 = "abcabcdbbcc";
        String s2 = "bbbbb";
        String s3 = "abc";
        System.out.print(findSubString(s1));
    }    
    private static int findSubString(String s){
        if(s.isEmpty()) return -1;
        int left = 0;
        int max = 0;
        Set<Character> seen = new HashSet<>();

        for(int right = 0; right < s.length(); right++){
            while(seen.contains(s.charAt(right))){
                seen.remove(s.charAt(left));
                left++;
            }
        seen.add(s.charAt(right));
        max = Math.max(max, right-left +1);
        }
        return max;
    }
}