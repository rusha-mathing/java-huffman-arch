package org.davmig.arch.huffman;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class NodeUtil {
    public static Map<Character, Integer> countSymbolOccurrences(CharSequence sequence) {
        return sequence
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(c -> 1)));
    }

    public static Queue<Node> makeNodes(CharSequence sequence) {
        Queue<Node> result = new PriorityQueue<>(Comparator.comparingInt(Node::getCount).reversed());
        Map<Character, Integer> occurrence = countSymbolOccurrences(sequence);
        occurrence.forEach((character, count) -> result.add(new Node(character, count)));
        return result;
    }

    public static void main(String[] args) {
        String data = "Hello".repeat(2000);
        System.out.println(data.length());
        long start = System.nanoTime();
        for (int i = 0; i < 1000; ++i) {
            countSymbolOccurrences(data);
        }
        System.out.println(makeNodes(data));
        long end = System.nanoTime();
        System.out.println((end - start) / 1_000_000_000.0);
    }
}
