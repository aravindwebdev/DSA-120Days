import java.util.*;
class LongestRepeatingCharacterK{
    public static void main(String[] args){
        String str = "ABAB";
        int k = 2;
        System.out.println(longestRepeatingCharacter(str,k));
    }

    private static int longestRepeatingCharacter(String str, int k){
        int res =0;
        HashMap<Character,Integer> hMap = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            int max = 0;
            for(int j=i; j<str.length(); j++){
                hMap.put(str.charAt(j), hMap.getOrDefault(str.charAt(j),0)+1);
                max = Math.max(max, hMap.get(str.charAt(j)));
                if((j-i+1)-max <= k){
                    res = Math.max(res, j-i+1);
                }
            }
        }
        return res;
    }
}