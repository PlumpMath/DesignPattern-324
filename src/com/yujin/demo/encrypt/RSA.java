package com.yujin.demo.encrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;

import javax.crypto.Cipher;

public class RSA {
    
    static HashMap<String, Object> map = null;


    /**
     * ���ɹ�Կ��˽Կ
     * 
     * @throws NoSuchAlgorithmException
     *
     */
    public static HashMap<String, Object> getKeys()
            throws NoSuchAlgorithmException {
        HashMap<String, Object> map = new HashMap<String, Object>();
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        map.put("public", publicKey);
        map.put("private", privateKey);
        return map;
    }

    /**
     * ʹ��ģ��ָ������RSA��Կ
     * ע�⣺���˴�������Ĭ�ϲ�λ��ʽ��ΪRSA/None/PKCS1Padding����ͬJDKĬ�ϵĲ�λ��ʽ���ܲ�ͬ����AndroidĬ����RSA
     * /None/NoPadding��
     * 
     * @param modulus ģ
     * @param exponent ָ��
     * @return
     */
    public static RSAPublicKey getPublicKey(String modulus, String exponent) {
        try {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * ʹ��ģ��ָ������RSA˽Կ
     * ע�⣺���˴�������Ĭ�ϲ�λ��ʽ��ΪRSA/None/PKCS1Padding����ͬJDKĬ�ϵĲ�λ��ʽ���ܲ�ͬ����AndroidĬ����RSA
     * /None/NoPadding��
     * 
     * @param modulus ģ
     * @param exponent ָ��
     * @return
     */
    public static RSAPrivateKey getPrivateKey(String modulus, String exponent) {
        try {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * ��Կ����
     * 
     * @param data
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String data, RSAPublicKey publicKey)
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        // ģ��
        int key_len = publicKey.getModulus().bitLength() / 8;
        // �������ݳ��� <= ģ��-11
        String[] datas = splitString(data, key_len - 11);
        String mi = "";
        // ������ĳ��ȴ���ģ��-11��Ҫ�������
        for (String s : datas) {
            mi += bcd2Str(cipher.doFinal(s.getBytes()));
        }
        return mi;
    }
    /**
     * ˽Կ����
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String encryptByPrivateKey(String data, RSAPrivateKey privateKey) 
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        //ģ��
        int key_len = privateKey.getModulus().bitLength()/8;
        //�������ݳ���<=ģ��-11
        String[] datas = splitString(data, key_len-11);
        String mi = "";
        // ������ĳ��ȴ���ģ��-11��Ҫ���������
        for (String str : datas) {
            mi += bcd2Str(cipher.doFinal(str.getBytes()));
        }
        return mi;
    }
    /**
     * ˽Կ����
     * 
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String data,
            RSAPrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        // ģ��
        int key_len = privateKey.getModulus().bitLength() / 8;
        byte[] bytes = data.getBytes();
        byte[] bcd = ASCII_To_BCD(bytes, bytes.length);
        System.err.println(bcd.length);
        // ������ĳ��ȴ���ģ����Ҫ�������
        String ming = "";
        byte[][] arrays = splitArray(bcd, key_len);
        for (byte[] arr : arrays) {
            ming += new String(cipher.doFinal(arr));
        }
        return ming;
    }

    /**
     * ��Կ����
     * @param data
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String decryptByPublicKey(String data, RSAPublicKey publicKey) 
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        // ģ��
        int key_len = publicKey.getModulus().bitLength() / 8;
        byte[] bytes = data.getBytes();
        byte[] bcd = ASCII_To_BCD(bytes, bytes.length);
        System.err.println(bcd.length);
        // ������ĳ��ȴ���ģ����Ҫ�������
        String ming = "";
        byte[][] arrays = splitArray(bcd, key_len);
        for (byte[] arr : arrays) {
            ming += new String(cipher.doFinal(arr));
        }
        return ming;
    }
    /**
     * ASCII��תBCD��
     * 
     */
    public static byte[] ASCII_To_BCD(byte[] ascii, int asc_len) {
        byte[] bcd = new byte[asc_len / 2];
        int j = 0;
        for (int i = 0; i < (asc_len + 1) / 2; i++) {
            bcd[i] = asc_to_bcd(ascii[j++]);
            bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));
        }
        return bcd;
    }

    public static byte asc_to_bcd(byte asc) {
        byte bcd;

        if ((asc >= '0') && (asc <= '9'))
            bcd = (byte) (asc - '0');
        else if ((asc >= 'A') && (asc <= 'F'))
            bcd = (byte) (asc - 'A' + 10);
        else if ((asc >= 'a') && (asc <= 'f'))
            bcd = (byte) (asc - 'a' + 10);
        else
            bcd = (byte) (asc - 48);
        return bcd;
    }

    /**
     * BCDת�ַ���
     */
    public static String bcd2Str(byte[] bytes) {
        char temp[] = new char[bytes.length * 2], val;

        for (int i = 0; i < bytes.length; i++) {
            val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
            temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');

            val = (char) (bytes[i] & 0x0f);
            temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
        }
        return new String(temp);
    }

    /**
     * ����ַ���
     */
    public static String[] splitString(String string, int len) {
        int x = string.length() / len;
        int y = string.length() % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        String[] strings = new String[x + z];
        String str = "";
        for (int i = 0; i < x + z; i++) {
            if (i == x + z - 1 && y != 0) {
                str = string.substring(i * len, i * len + y);
            } else {
                str = string.substring(i * len, i * len + len);
            }
            strings[i] = str;
        }
        return strings;
    }

    /**
     * �������
     */
    public static byte[][] splitArray(byte[] data, int len) {
        int x = data.length / len;
        int y = data.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        byte[][] arrays = new byte[x + z][];
        byte[] arr;
        for (int i = 0; i < x + z; i++) {
            arr = new byte[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(data, i * len, arr, 0, y);
            } else {
                System.arraycopy(data, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }


    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            map = getKeys();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        save("e:\\aaa.txt");//�����ɵĹ�Կ��˽Կ�����������Ա��´�ʹ�á�
//        open("e:\\aaa.txt");//���ļ���ȡ��Կ��˽Կ�����������ļ���
        // ���ɹ�Կ��˽Կ
        RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
        RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");

        // ģ
        String modulus = publicKey.getModulus().toString();
        System.out.println("ģ: " + modulus);
        // ��Կָ��
        String public_exponent = publicKey.getPublicExponent().toString();
        System.out.println("��Կָ��: " + public_exponent);
        // ˽Կָ��
        String private_exponent = privateKey.getPrivateExponent().toString();
        System.out.println("˽Կָ��: " + private_exponent);
        // ����
        String ming = "123456789";
        // ʹ��ģ��ָ�����ɹ�Կ��˽Կ
        RSAPublicKey pubKey = getPublicKey(modulus, public_exponent);
        RSAPrivateKey priKey = getPrivateKey(modulus, private_exponent);
        try {
            // ���ܺ������
            String mi = encryptByPublicKey(ming, pubKey);
            System.err.println("����: " + mi);
            // ���ܺ������
            ming = decryptByPrivateKey(mi, priKey);
            System.err.println("����: " + ming);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private static void save(String path){  
        FileOutputStream fos = null; 
        ObjectOutputStream oos = null; 
        File f = new File(path); 
        try { 
            fos = new FileOutputStream(f); 
            oos = new ObjectOutputStream(fos); 
            oos.writeObject(map);    //�����ڲ���ΪҪ����java���� 
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }finally{ 
            try { 
                oos.close(); 
                fos.close(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        }    
    } 
     
    private static void open(String path){ 
        FileInputStream fis = null; 
        ObjectInputStream ois = null;    
        File f = new File(path); 
        try { 
            fis = new FileInputStream(f); 
            ois = new ObjectInputStream(fis); 
//            javaObject object = (javaObject)ois.readObject();//ǿ������ת�� 
//            myPanel.repaint(); 
            HashMap<String, Object> map = (HashMap)ois.readObject();
            RSA.map = map;
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } catch (ClassNotFoundException e) { 
            e.printStackTrace(); 
        }finally{ 
            try { 
                ois.close(); 
                fis.close(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
    } 
}

