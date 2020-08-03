package effectivejava.chapter7.item47;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubList {
    
    public static <E> Stream<List<E>> of(List<E> list) {
        return Stream.concat(Stream.of(Collections.emptyList()), 
                prefixes(list).flatMap(SubList::suffixes));
    }

    private static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1, list.size())
                .mapToObj(end -> list.subList(0, end));
    }

    private static <E> Stream<List<E>> suffixes(List<E> list) {
        return IntStream.range(0, list.size())
                .mapToObj(start -> list.subList(start, list.size()));
    }

    public static <E> Stream<List<E>> of1(List<E> list) {
        return IntStream.range(0, list.size())
                    .mapToObj(start -> IntStream.rangeClosed(start + 1, list.size())
                        .mapToObj(end -> list.subList(start, end)))
                    .flatMap(x -> x);
    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList(args);
        // SubList.of(list).forEach(System.out::println);
        SubList.of1(list).forEach(System.out::println);

        Objects.requireNonNull(args, ":");
        Objects.checkIndex(3, 9);
    }
}