package com.network;

import org.jnetpcap.*;
import org.jnetpcap.packet.*;
import org.jnetpcap.protocol.network.*;
import com.network.*;
import org.jnetpcap.nio.*;
import org.jnetpcap.protocol.tcpip.Tcp;
import org.apache.commons.codec.digest.MurmurHash3;

public class ExtractPackets {
    public static final int L = 65536; // 直接位图数组长度
    public static final DirectBitmap bitmap = new DirectBitmap(L);

    // 哈希函数，使用 MurmurHash3 算法
    public static int hash(int srcIp, int dstIp, int srcPort, int dstPort, int protocol) {
        byte[] data = new byte[16];
        data[0] = (byte)(srcIp & 0xFF);
        data[1] = (byte)((srcIp >> 8) & 0xFF);
        data[2] = (byte)((srcIp >> 16) & 0xFF);
        data[3] = (byte)((srcIp >> 24) & 0xFF);
        data[4] = (byte)(dstIp & 0xFF);
        data[5] = (byte)((dstIp >> 8) & 0xFF);
        data[6] = (byte)((dstIp >> 16) & 0xFF);
        data[7] = (byte)((dstIp >> 24) & 0xFF);
        data[8] = (byte)(srcPort & 0xFF);
        data[9] = (byte)((srcPort >> 8) & 0xFF);
        data[10] = (byte)(dstPort & 0xFF);
        data[11] = (byte)((dstPort >> 8) & 0xFF);
        data[12] = (byte)(protocol & 0xFF);
        data[13] = (byte)((protocol >> 8) & 0xFF);
        data[14] = data[15] = 0;
        return MurmurHash3.hash32x86(data, 0, 16, 0) % L;
    }
}