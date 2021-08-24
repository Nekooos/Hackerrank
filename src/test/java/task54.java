import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

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
        Hashtable<String, Integer> magazineHash = new Hashtable<>();

        for(String word: magazine){
            magazineHash.put(word, magazineHash.getOrDefault(word ,0) +1);
        }

        for(String word: note){
            if(magazineHash.getOrDefault(word,0)==0) {
                magazineHash.entrySet().stream().forEach(s -> System.out.println(s));
                return "no";
            }
            else
                magazineHash.put(word, magazineHash.get(word)-1);
        }
        return "yes";

    }
}
