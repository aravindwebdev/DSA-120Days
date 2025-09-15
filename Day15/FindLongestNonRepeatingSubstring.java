public class FindLongestNonRepeatingSubstring{
    public static void main(String[] args){
        Sting  str = "abcabcdc";
        System.out.println(firstLongestNonRepeat(str));
    }
    
    private static int firstLongestNonRepeat(String str){
        int[] seen = new int[256];
        int start = 0;
        int max = 0;

        for(int i=0; i<s.length(); i++){
            char currentCharacter = s.charAt(i);
            if(seen[currentCharacter] > start){
                start = seen[currentCharacter];
            }
            seen[currentCharacter]=i+1;
            max = Math.max(max, i+1-start);
        }
        return max;
    }
}
}