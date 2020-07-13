import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.function.BiFunction;

public class task54 {
    //https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
    @Test
    public void task54() {
        String[] magazine =  {"give", "me", "one", "grand", "today", "night"}; //yes
        String[] note =  {"give", "one", "grand", "today"};

        String[] magazine2 = {"two", "times", "three", "is", "not", "four"}; // No
        String[] note2 = {"two", "times", "two", "is", "four"};

        Assertions.assertEquals("yes", ransomNote(magazine, note));
        Assertions.assertEquals("no", ransomNote(magazine2, note2));
        System.out.println(ransomNote(magazine, note));
        System.out.println(ransomNote(magazine2, note2));
    }

    private String ransomNote(String[] magazine, String[] note) {
        HashMap<Integer, String> words = new HashMap<>();
        words.put(1, "test");
        //System.out.println(words.get(1));
        //System.out.println(words.entrySet());
        BiFunction<String, String, String> customMerge = (val1, val2) -> val1 + val2 + "derp";
        //System.out.println(customMerge.apply("1", "derp"));
        words.merge(2, "test", customMerge);
        words.merge(2, "test",  (v1, v2) -> v1.equals(v2) ? "yes" : "no"); /*{
            if (v1.equals(v2)) {
                return "yes";
            } else {
                return "no";
            }
        });*/
        words.merge(3, "test", customMerge);
        System.out.println(words.entrySet());
        words.replace(1, "test", "new 1");
        words.replace(3, "new 3");
        words.forEach((integer, string) -> System.out.println(integer + " " + string));

        return "yes";
    }
}
