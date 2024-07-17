package org.davmig.arch.huffman;

import java.util.*;
import java.util.stream.Collectors;

public class NodeUtil {
    public static Map<Character, Integer> countSymbolOccurrences(CharSequence sequence) {
        return sequence
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(c -> 1)));
    }

    public static Queue<Node> makeNodes(CharSequence sequence) {
        Queue<Node> result = new PriorityQueue<>(Comparator.comparingInt(Node::getCount));
        Map<Character, Integer> occurrence = countSymbolOccurrences(sequence);
        occurrence.forEach((character, count) -> result.add(new Node(character, count)));
        return result;
    }

    public static Node buildHuffmanTree(CharSequence sequence) {
        Queue<Node> nodes = makeNodes(sequence);
        while (nodes.size() > 1) {
            Node parent = new Node(nodes.poll(), nodes.poll());
            nodes.add(parent);
        }
        return nodes.poll();
    }

    public static Map<Character, String> generateCodes(Node root) {
        Map<Character, String> codes = new HashMap<>();
        generateCodesRecursive(root, "", codes);
        return codes;
    }

    private static void generateCodesRecursive(Node node, String code, Map<Character, String> codes) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            codes.put(node.getData(), code);
        }
        generateCodesRecursive(node.getLeft(), code + "0", codes);
        generateCodesRecursive(node.getRight(), code + "1", codes);
    }

    public static void main(String[] args) {
        String data = "abracadabra";
        Node root = buildHuffmanTree(data);
        System.out.println(generateCodes(root));
    }
}
