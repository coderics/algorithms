package problems;

import java.util.Comparator;
import java.util.List;

public class StringByAlphabeticallyOrdered {

    /**
     * Retrieves longest word
     */
    public String retrieveLongest(List<String> list) {
        return list.stream().filter(s -> isAlphabeticallyOrdered(s))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }

    /**
     * Retrieves shortest word
     */
    public String retrieveShortest(List<String> list) {
        return list.stream().filter(s -> isAlphabeticallyOrdered(s))
                .min(Comparator.comparingInt(String::length))
                .orElse(null);
    }

    /**
     * @param s String
     * @return true if {@param s} is ordered alphabetically, otherwise returns false
     */
    private static boolean isAlphabeticallyOrdered(String s) {
        boolean var = false;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && s.charAt(i + 1) > s.charAt(i)) {
                var = true;
            } else if (i + 1 < s.length() && s.charAt(i + 1) < s.charAt(i)) {
                var = false;
                break;
            }
        }
        return var;
    }

}
