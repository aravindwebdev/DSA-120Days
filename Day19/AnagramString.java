class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 > l2) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(char c : s1.toCharArray()){
            count1[c - 'a']++;
        }

        for(int i=0; i<l1; i++){
                count2[s2.charAt(i) - 'a']++;
        }
            if (matches(count1, count2)) return true;

            for(int i=l1; i<l2; i++){
                count2[s2.charAt(i)-'a']++;
                count2[s2.charAt(i-l1)-'a']--;
                if(matches(count1,count2)) return true;
            }
            return false;
        } 

    boolean matches (int[] arr1, int[] arr2){
        for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}