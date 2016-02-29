package com.yujin.demo.encrypt;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Base64是网络上最常见的用于传输8Bit字节代码的编码方式之一。
 * Base64编码可用于在HTTP环境下传递较长的标识信息。
 * 例如，在Java Persistence系统Hibernate中，就采用了Base64来将一个较长的唯一标识符（一般为128-bit的UUID）
 * 编码为一个字符串，用作HTTP表单和HTTP GET URL中的参数。
 * 在其他应用程序中，也常常需要把二进制数据编码为适合放在URL（包括隐藏表单域）中的形式。
 * 此时，采用Base64编码具有不可读性，即所编码的数据不会被人用肉眼所直接看到。
 * 
 * @author yujin
 *
 */
public class Base64Algorithm {
    /***
     * encode by Base64
     */
    public static String encodeBase64(byte[]input) throws Exception{
        Class clazz=Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method mainMethod= clazz.getMethod("encode", byte[].class);
        mainMethod.setAccessible(true);
         Object retObj=mainMethod.invoke(null, new Object[]{input});
         return (String)retObj;
    }
    /***
     * decode by Base64
     */
    public static String decodeBase64(String input) throws Exception{
        Class clazz=Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method mainMethod= clazz.getMethod("decode", String.class);
        mainMethod.setAccessible(true);
         Object retObj=mainMethod.invoke(clazz, input);
         byte[] bt = (byte[])retObj;
         String result = "";
         for (int i = 0; i < bt.length; i++) {
             result+=(char)bt[i];
         }
         return result;
    }
    
    /**
     * 编码
     * 
     * @param bstr
     * @return String
     */
    public static String encode(byte[] bstr) {
        return new sun.misc.BASE64Encoder().encode(bstr);
    }

    /**
     * 解码
     * 
     * @param str
     * @return string
     */
    public static String decode(String str) {
        byte[] bt = null;
        try {
            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
            bt = decoder.decodeBuffer(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = "";
        for (int i = 0; i < bt.length; i++) {
            result += (char)bt[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String msg = "7JwoflA5l6LBdraydBo7h_n1zGuuqWzD81uxOW-F47kq_djIrPf9TH3VzghwIRUFzkkNQWmj55fIXjFIud1MDq";
        System.out.println("通过反射方式：");
        try {
            System.out.println("加密: " + encodeBase64(msg.getBytes()));
            System.out.println("解密: " + decodeBase64(encodeBase64(msg.getBytes())));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("直接用sun公司提供的BASE64Decoder类方式：");
        System.out.println("加密: " + encode(msg.getBytes()));
        System.out.println("解密: " + decode(encode(msg.getBytes())));
        
    }
}
