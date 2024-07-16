package org.davmig.arch.huffman;

import java.util.*;
import java.util.stream.Collectors;

public class NodeUtil {
    private static Map<Character, Integer> countSymbolOccurrences(CharSequence sequence) {
        return sequence
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(c -> 1)));
    }

    private static Queue<Node> makeNodes(CharSequence sequence) {
        Queue<Node> result = new PriorityQueue<>(Comparator.comparingInt(Node::getCount));
        Map<Character, Integer> occurrence = countSymbolOccurrences(sequence);
        occurrence.forEach((character, count) -> result.add(new Node(character, count)));
        return result;
    }

    public static Node buildHuffmanTree(CharSequence sequence) {
        Queue<Node> nodes = makeNodes(sequence);
        System.out.println(nodes);
        while (nodes.size() > 1) {
            Node parent = new Node(nodes.poll(), nodes.poll());
            nodes.add(parent);
            System.out.println(nodes);
        }

        return nodes.poll();
    }

    public static void main(String[] args) {
        String data = "aaaabbc".repeat(2000);
        System.out.println(data.length());
        long start = System.nanoTime();
        System.out.println(buildHuffmanTree(data));
        long end = System.nanoTime();
        System.out.println((end - start) / 1_000_000_000.0);
    }
}
