package com.yujin.demo;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.yujin.demo.iterator.Iterator;

public class Base64 {
    public static String getBase64(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    // 解密
    public static String getFromBase64(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Encode: " + getBase64("abcdefg"));
        System.out.println("decode: " + getFromBase64(getBase64("abcdefg")));
        
        String keyFilename = "key.data";
        String algorithm = "DES";

        // 生成密匙
        SecureRandom sr = new SecureRandom();
        KeyGenerator kg = KeyGenerator.getInstance( algorithm );
        kg.init( sr );
        SecretKey key = kg.generateKey();
        
        // 把密匙数据保存到文件
        //Util.writeFile( keyFilename, key.getEncoded();
        
        Collection c = new HashSet();
        Iterator iterator = (Iterator)c.iterator();
        Map cc = new HashMap();
        
    }
}
