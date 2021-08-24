import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Task55 {
    //https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

    @Test
    public void task55() {
        String word1 = "hello";
        String word2 = "world";
        Assertions.assertEquals("YES", twoStrings(word1, word2));

    }

    //to slow for test 4, 5
    public String twoStringsSlow(String word1, String word2) {

        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();

        for (char value : word1Array) {
            for (char c : word2Array) {
                if (value == c) {
                    return "Yes";
                }
            }
        }

        return "No";
    }


    public String twoStrings(String word1, String word2) {
        for (char char1 : "abcdefghijklmnopqrstuvxyz".toCharArray()) {
            if(word1.indexOf(char1) > -1 && word2.indexOf(char1) > -1) {
                return "YES";
            }
        }

        return "NO";
    }

    //To slow 3,4,5
    public String twoStringsSlow2(String word1, String word2) {

        List<String> characterList1 = Arrays.asList(word1.split(""));
        Set<String> characterSet1 = new HashSet<>(characterList1);

        Set<String> characterSet2 = new HashSet<>(Arrays.asList(word2.split("")));


        for (String letter : characterList1) {
            for ( String letter2 : characterSet2) {
                if(letter.equals(letter2))
                    return "YES";
            }

        }

        return "NO";
    }

}

