package effectivejava.chapter7.item43;

import java.util.Map;
import java.util.TreeMap;

public class Freq {
    
    public static void main(String[] args) {
        Integer.sum(2, 5);


        Map<String, Integer> frequencyTable = new TreeMap<>();

        for (String s : args) {
            frequencyTable.merge(s, 1, (count, incr) -> count + incr);
        }
        System.out.println(frequencyTable);

        //
        // frequencyTable.clear();
        for (String s : args) {
            frequencyTable.merge(s, 1, Integer::sum);

        }
        System.out.println(frequencyTable);
    }
}