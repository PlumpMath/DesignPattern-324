package com.yujin.demo.file;

import java.security.AccessController;

import sun.security.action.GetPropertyAction;

/**
 * ����ļ��ı��룬�磺GBK,Unicode, UTF-8�ȵ�
 * @author yujin
 *
 */
public class CharSetForFile {

    public static void main(String[] args) {
        String csn = AccessController.doPrivileged(
                new GetPropertyAction("file.encoding"));
        System.out.println("csn: " + csn);
    }
}
