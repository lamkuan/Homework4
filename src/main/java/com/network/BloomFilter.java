package com.network;

import java.util.BitSet;
import java.util.Random;

public class BloomFilter {
    private BitSet bitSet;
    private int bitSetSize;
    private int numOfHashFuncs;
    private Random random = new Random();

    public BloomFilter(int bitSetSize, int numOfHashFuncs) {
        this.bitSetSize = bitSetSize;
        this.numOfHashFuncs = numOfHashFuncs;
        this.bitSet = new BitSet(bitSetSize);
    }

    public void add(String element) {
        for (int i = 0; i < numOfHashFuncs; i++) {
            int hash = hash(element, i);
            bitSet.set(hash);
        }
    }

    public boolean contains(String element) {
        for (int i = 0; i < numOfHashFuncs; i++) {
            int hash = hash(element, i);
            if (!bitSet.get(hash)) {
                return false;
            }
        }
        return true;
    }

    private int hash(String element, int index) {
        String str = element + index;
        int hash = str.hashCode() % bitSetSize;
        return Math.abs(hash);
    }
}