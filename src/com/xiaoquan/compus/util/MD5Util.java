package com.xiaoquan.compus.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class MD5Util {
      /**
        * ����MD5��ʽ��������
     * @param password ��Ҫ���ܵĵط�
     * @return ���ܺ���ַ���
     */
    public static String md5(String password){
        //������ܵķ�ʽ
        try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        //������ת�����ֽ����飬������ܷ�ʽ��
        md.update(password.getBytes());
        //��������ֽ����ݼ��ܣ�������ֽ�����
        byte[] bys = md.digest();
        BASE64Encoder encoder = new BASE64Encoder();
        //�����������±��룬������
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
