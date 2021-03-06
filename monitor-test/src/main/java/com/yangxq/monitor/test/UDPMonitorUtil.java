package com.yangxq.monitor.test;

import com.yangxq.monitor.common.utils.DaemonThread;
import com.yangxq.monitor.common.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP监控
 */
public class UDPMonitorUtil {

    private static final Logger log = LoggerFactory.getLogger(UDPMonitorUtil.class);

    private static ThreadLocal<DatagramSocket> UDP_SOCKET = new
            ThreadLocal<DatagramSocket>() {
                @Override
                protected DatagramSocket initialValue() {
                    DatagramSocket client = null;
                    try {
                        client = new DatagramSocket();
                        client.setSoTimeout(500);
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                    return client;
                }
            };


    /**
     * 发送调用量包
     *
     * @param opsHost 调用量地址
     * @param opsPort 调用量端口
     * @param key     业务主键
     * @param num     调用数量
     */
    public static void sendPacketOps(String opsHost, int opsPort, int key, Long num) {
        String packet = "IM-==-" + DateUtil.getNowSecond() + "-==-" + key + "-==-" + num;
        sendPacket(opsHost, opsPort, packet);
    }

    /**
     * 发送延时包
     *
     * @param delayHost 延迟地址
     * @param delayPort 延迟端口
     * @param key       业务主键
     * @param delayTime 延迟时间(单位毫秒)
     */
    public void sendPacketDelay(String delayHost, int delayPort, int key, Long delayTime) {
        String packet = "IM-==-" + DateUtil.getFormatTime() + "-==-" + key + "-==-" + delayTime;
        sendPacket(delayHost, delayPort, packet);
    }

    private static void sendPacket(String host, int port, String packet) {
        try {
//            DatagramSocket client = new DatagramSocket();
//            client.setSoTimeout(1000);

            DatagramSocket client = UDP_SOCKET.get();
            byte[] sendBuf;
            sendBuf = packet.getBytes("utf-8");
            InetAddress addr = InetAddress.getByName(host);
//            InetAddress addr = InetAddress.getByName("127.0.0.1");
            DatagramPacket sendPacket
                    = new DatagramPacket(sendBuf, sendBuf.length, addr, port);
            client.send(sendPacket);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
//        TestUdp testUdp = new TestUdp();

        int[] delayBusinessIds = {876, 878};
        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < delayBusinessIds.length; i++) {
                for (int j = 0; j < 10; j++) {
                    TestUdp testUdp = new TestUdp("error--" + j, delayBusinessIds[i], 20021);
                    testUdp.start();
                }
            }
        }
        int[] businessIds = {875, 877, 879, 881, 925, 880, 882};
        for (int m = 0; m < 10; m++) {
            for (int k = 0; k < businessIds.length; k++) {
                for (int i = 0; i < 10; i++) {
                    TestUdp testUdp = new TestUdp("transfer--" + i, businessIds[k], 20020);
                    testUdp.start();
                }
            }
        }


        new DaemonThread().start();
    }
}

class TestUdp extends Thread {

    private int bussinessId;
    private int port;

    public TestUdp(String i, int businessId, int port) {
        this.setName("transfer-" + i);
        this.bussinessId = businessId;
        this.port = port;
    }

    public void run() {
        int index = 0;
        System.out.println(this.getName());
        do {
            index++;
            System.out.println(this.getName() + "--index--" + index);
            UDPMonitorUtil.sendPacketOps("127.0.0.1", port, bussinessId, 1L);
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (index < 1000);
    }
}