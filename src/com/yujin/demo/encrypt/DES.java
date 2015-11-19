package com.yujin.demo.encrypt;

import java.security.Key;
import javax.crypto.Cipher;

/**
 * DESȫ��ΪData Encryption Standard�������ݼ��ܱ�׼����һ��ʹ����Կ���ܵĿ��㷨
 * 
 * DES���ܺͽ��ܹ���,���Զ��ַ������м��ܺͽ��ܲ��� ��
 * @author yujin
 *
 */
public class DES {
    
    /** �ַ���Ĭ�ϼ�ֵ */
    private static String strDefaultKey = "national";
    /** ���ܹ��� */
    private Cipher encryptCipher = null;
    /** ���ܹ��� */
    private Cipher decryptCipher = null;
    
    /**
     * Ĭ�Ϲ��췽����ʹ��Ĭ����Կ
     */
    public DES() throws Exception {
        this(strDefaultKey);
    }

    /**
     * ָ����Կ���췽��
     * 
     * @param strKeyָ������Կ
     * @throws Exception
     */
    public DES(String strKey) throws Exception {
        // Security.addProvider(new com.sun.crypto.provider.SunJCE());
        Key key = getKey(strKey.getBytes());
        encryptCipher = Cipher.getInstance("DES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, key);
        decryptCipher = Cipher.getInstance("DES");
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
    }


    /**
     * ��byte����ת��Ϊ��ʾ16����ֵ���ַ����� �磺byte[]{8,18}ת��Ϊ��0813�� ��public static byte[]
     * hexStr2ByteArr(String strIn) ��Ϊ�����ת������
     * 
     * @param arrB ��Ҫת����byte����
     * @return ת������ַ���
     * @throws Exception
     *             �������������κ��쳣�������쳣ȫ���׳�
     */
    public static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        // ÿ��byte�������ַ����ܱ�ʾ�������ַ����ĳ��������鳤�ȵ�����
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // �Ѹ���ת��Ϊ����
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // С��0F������Ҫ��ǰ�油0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * ����ʾ16����ֵ���ַ���ת��Ϊbyte���飬 ��public static String byteArr2HexStr(byte[] arrB)
     * ��Ϊ�����ת������
     * 
     * @param strIn
     *            ��Ҫת�����ַ���
     * @return ת�����byte����
     */
    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        // �����ַ���ʾһ���ֽڣ������ֽ����鳤�����ַ������ȳ���2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    /**
     * �����ֽ�����
     * 
     * @param arrB
     *            ����ܵ��ֽ�����
     * @return ���ܺ���ֽ�����
     */
    public byte[] encrypt(byte[] arrB) throws Exception {
        return encryptCipher.doFinal(arrB);
    }

    /**
     * �����ַ���
     * 
     * @param strIn
     *            ����ܵ��ַ���
     * @return ���ܺ���ַ���
     */
    public String encrypt(String strIn) throws Exception {
        return byteArr2HexStr(encrypt(strIn.getBytes()));
    }

    /**
     * �����ֽ�����
     * 
     * @param arrB
     *            ����ܵ��ֽ�����
     * @return ���ܺ���ֽ�����
     */
    public byte[] decrypt(byte[] arrB) throws Exception {
        return decryptCipher.doFinal(arrB);
    }

    /**
     * �����ַ���
     * 
     * @param strIn
     *            ����ܵ��ַ���
     * @return ���ܺ���ַ���
     */
    public String decrypt(String strIn) throws Exception {
        return new String(decrypt(hexStr2ByteArr(strIn)));
    }

    /**
     * ��ָ���ַ���������Կ����Կ������ֽ����鳤��Ϊ8λ ����8λʱ���油0������8λֻȡǰ8λ
     * 
     * @param arrBTmp ���ɸ��ַ������ֽ�����
     * @return ���ɵ���Կ
     */
    private Key getKey(byte[] arrBTmp) throws Exception {
        // ����һ���յ�8λ�ֽ����飨Ĭ��ֵΪ0��
        byte[] arrB = new byte[8];
        // ��ԭʼ�ֽ�����ת��Ϊ8λ
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        // ������Կ
        Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
        return key;
    }

    public static void main(String[] args) {
        try {
            String test1 = "987654321";
            DES des1 = new DES();// ʹ��Ĭ����Կ
            System.out.println("����ǰ���ַ���" + test1);
            System.out.println("���ܺ���ַ���" + des1.encrypt(test1));
            System.out.println("���ܺ���ַ���" + des1.decrypt(des1.encrypt(test1)));

            String test2 = "123456789";
            DES des2 = new DES("leeme32nz");// �Զ�����Կ
            System.out.println("����ǰ���ַ���" + test2);
            System.out.println("���ܺ���ַ���" + des2.encrypt(test2));
            System.out.println("���ܺ���ַ���" + des2.decrypt(des2.encrypt(test2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
