package com.zsc.wxapp.exservices;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ApiHeader {

    /**
     * 计算网关所需的请求头
     * @param token 用户 token
     * @param passid 用户 paasid
     * @return 网关所需的请求头
     */
    public static Map<String, String> generateHeader(String token, String passid) {
        HashMap<String, String> headers = new HashMap<>(4);

        // 随机生成字符串
        String nonce = UUID.randomUUID().toString().replace("-", "");

        // 秒级时间戳
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);

        // 被签名的认证信息
        String authorization = timestamp + token + nonce + timestamp;

        // 计算 sha256 签名
        String signature = sha256(authorization);

        // 组装请求头
        headers.put("x-tobacco-paasid", passid);
        headers.put("x-tobacco-timestamp", timestamp);
        headers.put("x-tobacco-nonce", nonce);
        headers.put("x-tobacco-signature", signature);

        return headers;
    }

    /**
     * 计算签名
     * @param str 被签名的内容
     * @return 从内容生成的摘要签名
     */
    public static String sha256(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";

        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
            encodeStr = byteToHex(hash);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encodeStr;
    }

    /**
     * 将字节数组转换为十六进制字符串
     * @param bytes
     * @return
     */
    private static String byteToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();

        for (byte aByte : bytes) {
            String strHex = Integer.toHexString(aByte & 0xFF);
            sb.append((strHex.length() == 1) ? "0" + strHex : strHex);
        }

        return sb.toString().trim();
    }
}