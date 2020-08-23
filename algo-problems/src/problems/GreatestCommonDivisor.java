package problems;

/*
    PROBLEM: leetcode.com/problems/greatest-common-divisor-of-strings/
 */
class GreatestCommonDivisor {

    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            return str1;
        } else if (str2.length() > str1.length()) {
            return gcdOfStrings(str2, str1);
        } else if (str1.startsWith(str2)) {
            int gcdLength = gcdOfTwoNums(str1.length(), str2.length());
            String commonPrefix = str2.substring(0, gcdLength);
            if (str1.split(commonPrefix).length != 0) return "";
            return commonPrefix;
        } else {
            return "";
        }
    }

    private int gcdOfTwoNums(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        for (int i = min; i >= 1; i--) {
            if (max % i == 0 && min % i == 0)
                return i;
        }
        return 1;
    }
}
