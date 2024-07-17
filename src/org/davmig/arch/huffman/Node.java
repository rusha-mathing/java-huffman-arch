package org.davmig.arch.huffman;

public class Node {
    private Character data = null;
    private final boolean leaf;
    private final int count;
    private Node left = null;
    private Node right = null;

    public Node(char data, int count) {
        this.data = data;
        this.count = count;
        this.leaf = true;
    }

    public Node(Node left, Node right) {
        assert left != null && right != null;
        this.left = left;
        this.right = right;
        this.count = left.count + left.count;
        this.leaf = false;
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

    public boolean isLeaf() {
        return leaf;
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
