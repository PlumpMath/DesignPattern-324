package com.yujin.demo.encrypt;

import java.security.AccessController;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.security.action.GetPropertyAction;

public class TestRSA {
    static String data = "abcdefghijklmnopqrstuvwxyz1234567890abcdefg";
    public static void main(String[] args) {
        Base64Algorithm base64 = new Base64Algorithm();
        RSA rsa = new RSA();
        try {
            HashMap<String, Object> keyMap = rsa.getKeys();
            RSAPublicKey publicKey = (RSAPublicKey)keyMap.get("public");
            RSAPrivateKey privateKey = (RSAPrivateKey)keyMap.get("private");
            /**
             * π´‘øº”√‹£¨ÀΩ‘øΩ‚√‹
             */
            System.out.println("π´‘øº”√‹£¨ÀΩ‘øΩ‚√‹");
            String encryptData = rsa.encryptByPublicKey(data, publicKey);
            System.out.println("publicKey encryptData: " + encryptData);
            BASE64Encoder encoder = new BASE64Encoder();
            String base64Encode = encoder.encode(encryptData.getBytes());
            System.out.println("BASE64Encoder: " + base64Encode);
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] base64Decode = decoder.decodeBuffer(base64Encode);
            String result = "";
            for (int i = 0; i < base64Decode.length; i++) {
                result += (char)base64Decode[i];
            }
            System.out.println("BASE64Decoder: " + result);
//            String decryptData = rsa.decryptByPrivateKey(encryptData, privateKey);
            String decryptData = rsa.decryptByPrivateKey(result, privateKey);
            System.out.println("privateKey decryptData: " + decryptData);
            /**
             * ÀΩ‘øº”√‹£¨π´‘øΩ‚√‹
             */
            System.out.println("ÀΩ‘øº”√‹£¨π´‘øΩ‚√‹");
            String encryptData2 = rsa.encryptByPrivateKey(data, privateKey);
            System.out.println("privateKey encryptData2: " + encryptData2);
            String decryptData2 = rsa.decryptByPublicKey(encryptData2, publicKey);
            System.out.println("publicKey decryptData2: " + decryptData2);
       
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
