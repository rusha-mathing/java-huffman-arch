package org.davmig.arch.huffman;

public class Node {
    private final char data;
    private final int count;

    public Node(char data, int count) {
        this.data = data;
        this.count = count;
    }

    public char getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", count=" + count +
                '}';
    }
}
