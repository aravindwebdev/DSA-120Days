class Perutation {
    public static boolean checkInclusion(String s1, String s2) {
        //brute force - O(n^2)
        int l1 = s1.length();
        int l2 = s2.length();
        int[] count1 = new int[26];
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        for (int i = 0; i <= l2 - l1; i++) {
            int[] count2 = new int[26];
            System.out.println(s2.substring(i, i + l1));
            for (int j = 0; j < l1; j++) {
                count2[s2.charAt(i + j) - 'a']++;
            }

            if (matches(count1, count2)) return true;
        }
        return false;
    }

    static boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion(s1, s2));
    }
}