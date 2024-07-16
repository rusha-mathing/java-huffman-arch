package org.davmig.arch.huffman;

public class Node {
    private Character data = null;
    private final int count;
    private Node left = null;
    private Node right = null;

    public Node(char data, int count) {
        this.data = data;
        this.count = count;
    }

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
        this.count = left.count + left.count;
    }

    public Character getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public String toString() {
        if (data == null) {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        } else {
            return "Node{" + data + "," + count + "}";
        }
    }
}
