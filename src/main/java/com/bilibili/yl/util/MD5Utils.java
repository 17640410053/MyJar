package com.bilibili.yl.util;

import java.security.MessageDigest;

public class MD5Utils {

    private static final String hexDigIts[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * MD5加密
     *
     * @param origin      字符
     * @param charsetName 编码
     * @return String
     */
    public static String MD5Encode(String origin, String charsetName) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (null == charsetName || "".equals(charsetName))
                origin = byteArrayToHexString(md.digest(origin.getBytes()));
            else origin = byteArrayToHexString(md.digest(origin.getBytes(charsetName)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return origin.toUpperCase();
    }


    private static String byteArrayToHexString(byte b[]) {
        StringBuilder resultSb = new StringBuilder();
        for (byte aB : b) {
            resultSb.append(byteToHexString(aB));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }
}