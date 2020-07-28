package effectivejava.chapter7.item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortForeWays {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(args);

        Collections.sort(words, new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
            
        });
        System.out.println("1.");
        System.out.println(words);

        //
        Collections.shuffle(words);
        Collections.sort(words, (s1,s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("2. ");
        System.out.println(words);

        //
        Collections.shuffle(words);
        Collections.sort(words, Comparator.comparingInt(String::length));
        System.out.println("3. ");
        System.out.println(words);

        //
        Collections.shuffle(words);
        words.sort(Comparator.comparingInt(String::length));
        System.out.println("4. ");
        System.out.println(words);
        
    }
}