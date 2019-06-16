package com.xiaoquan.compus.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class MD5Util {
      /**
        * 采用MD5方式加密密码
     * @param password 需要加密的地方
     * @return 加密后的字符串
     */
    public static String md5(String password){
        //定义加密的方式
        try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        //将密码转换成字节数组，放入加密方式中
        md.update(password.getBytes());
        //将密码的字节数据加密，变成新字节数组
        byte[] bys = md.digest();
        BASE64Encoder encoder = new BASE64Encoder();
        //将借数组重新编码，并返回
        return encoder.encode(bys);
        } catch (Exception e) {
            e.printStackTrace();
        }
          return null;
    }

    public static void main(String[] args) {
        System.out.println(md5("123456"));
    }
}
