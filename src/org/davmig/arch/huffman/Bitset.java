package org.davmig.arch.huffman;

public class Bitset {
    String code;

    public Bitset(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Bitset{" +
                "code='" + code + '\'' +
                '}';
    }
}

