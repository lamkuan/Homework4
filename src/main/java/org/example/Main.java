package org.example;

import com.network.BloomFilter;
import org.jnetpcap.Pcap;
import org.jnetpcap.nio.JMemory;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.protocol.network.*;
import com.network.ExtractPackets;
import org.jnetpcap.protocol.tcpip.Tcp;

import static org.jnetpcap.Pcap.openOffline;

public class Main {
    public static void main(String[] args) {
        String fileName = "test.pcap";
        StringBuilder errbuf = new StringBuilder();

        ExtractPackets extractPackets = new ExtractPackets();

        // 打开 PCAP 文件
        Pcap pcap = openOffline(fileName, errbuf);
        if (pcap == null) {
            System.err.println(errbuf);
            return;
        }

        System.out.println("Hello");

//        // 循环遍历每个分组
//        PcapPacket packet = new PcapPacket(JMemory.POINTER);
//        while (pcap.nextEx(packet) == Pcap.NEXT_EX_OK) {
//            Tcp tcp = new Tcp();
//            if (packet.hasHeader(tcp)) {
//                // 分组时间
//                long timestamp = packet.getCaptureHeader().timestampInMillis();
//
//                // 源 IP 地址、目的 IP 地址、源端口、目的端口、协议
//                int srcIp = packet.getUByte(26) << 24 | packet.getUByte(27) << 16 | packet.getUByte(28) << 8 | packet.getUByte(29);
//                int dstIp = packet.getUByte(30) << 24 | packet.getUByte(31) << 16 | packet.getUByte(32) << 8 | packet.getUByte(33);
//                int srcPort = tcp.source();
//                int dstPort = tcp.destination();
//                int protocol = tcp.destination();
//
//                // 分组大小
//                int size = packet.size();
//
//                // 映射到直接位图数组
//                int index = extractPackets.hash(srcIp, dstIp, srcPort, dstPort, protocol);
////                bitmap.update(index);
//
//                // 输出分组数据信息
//                System.out.println("Time:\t" + timestamp);
//                System.out.println("SrcIP:\t" + srcIp);
//                System.out.println("DstIP:\t" + dstIp);
//                System.out.println("SrcPort:\t" + srcPort);
//                System.out.println("DstPort:\t" + dstPort);
//                System.out.println("Protocol:\t" + protocol);
//                System.out.println("Size:\t" + size);
//                System.out.println();
//            }
//        }
//
//        // 关闭 PCAP 文件
//        pcap.close();
    }
}