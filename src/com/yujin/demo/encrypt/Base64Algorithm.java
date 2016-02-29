package com.yujin.demo.encrypt;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Base64����������������ڴ���8Bit�ֽڴ���ı��뷽ʽ֮һ��
 * Base64�����������HTTP�����´��ݽϳ��ı�ʶ��Ϣ��
 * ���磬��Java PersistenceϵͳHibernate�У��Ͳ�����Base64����һ���ϳ���Ψһ��ʶ����һ��Ϊ128-bit��UUID��
 * ����Ϊһ���ַ���������HTTP����HTTP GET URL�еĲ�����
 * ������Ӧ�ó����У�Ҳ������Ҫ�Ѷ��������ݱ���Ϊ�ʺϷ���URL���������ر����е���ʽ��
 * ��ʱ������Base64������в��ɶ��ԣ�������������ݲ��ᱻ����������ֱ�ӿ�����
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
     * ����
     * 
     * @param bstr
     * @return String
     */
    public static String encode(byte[] bstr) {
        return new sun.misc.BASE64Encoder().encode(bstr);
    }

    /**
     * ����
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
        System.out.println("ͨ�����䷽ʽ��");
        try {
            System.out.println("����: " + encodeBase64(msg.getBytes()));
            System.out.println("����: " + decodeBase64(encodeBase64(msg.getBytes())));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("ֱ����sun��˾�ṩ��BASE64Decoder�෽ʽ��");
        System.out.println("����: " + encode(msg.getBytes()));
        System.out.println("����: " + decode(encode(msg.getBytes())));
        
    }
}
