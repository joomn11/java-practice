package effectivejava.chapter7.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Freq {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);

        Map<String, Long> freq = new HashMap<>();
        Map<String, Long> freq1 = new HashMap<>();
        try (Stream<String> words = new Scanner(file).tokens()) {
            words.forEach(word -> {
                freq.merge(word.toLowerCase(), 1L, Long::sum);
            });
        }

        try (Stream<String> words = new Scanner(file).tokens()) {
            freq1 = words.collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        }
        
        

        List<String> topTem = freq1.keySet().stream()
            .sorted(Comparator.comparing(freq1::get).reversed())
            .limit(10)
            .collect(Collectors.toList());
        
        System.out.println(topTem);    
    }
}