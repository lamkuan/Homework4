package com.network;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class DirectBitmap {
    private int size; // Bitmap的大小
    private BitSet bits; // 存储Bitmap的位集合
    private Map<Integer, Integer> hashFunctions; // 存储Hash函数

    public DirectBitmap(int size) {
        this.size = size;
        this.bits = new BitSet(size);
        this.hashFunctions = new HashMap<>();
    }

    // 添加Hash函数
    public void addHashFunction(int m, int a, int b) {
        hashFunctions.put(m, (a * size + b) % m);
    }

    // 基于流标识更新Bitmap的位
    public void update(int flowId) {
        for (int m : hashFunctions.keySet()) {
            int bitIndex = hashFunctions.get(m) ^ flowId;
            bits.set(Math.abs(bitIndex % size));
        }
    }

    // 统计Bitmap中为1的位的数量
    public int getCount() {
        return bits.cardinality();
    }
}
