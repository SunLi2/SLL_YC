package com.zsc.wxapp.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddressUtil {
    public static String getIpAddress() {
        return "127.0.0.1";
//        try {
//            InetAddress address = InetAddress.getLocalHost();
//            return address.getHostAddress();
//        } catch (UnknownHostException e) {
////            e.printStackTrace();
//            return "127.0.0.1"; // 或者抛出异常，根据你的需要
//        }
    }
}