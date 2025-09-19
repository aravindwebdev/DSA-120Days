import java.util.*;
class LongestRepeatingCharacterK{
    public static void main(String[] args){
        String str = "ABAB";
        int k = 2;
        System.out.println(longestRepeatingCharacter(str,k));
    }

    private static int longestRepeatingCharacter(String str, int k){
        int res = 0, l = 0, max = 0;
        HashMap<Character,Integer> count = new HashMap<>();
        for(int r=0; r<s.length(); r++){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r),0)+1);
            max = Math.max(max, count.get(s.charAt(r)));

            while((r-l+1)-max > k){
                count.put(s.charAt(l), count.get(s.charAt(l))-1);
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}