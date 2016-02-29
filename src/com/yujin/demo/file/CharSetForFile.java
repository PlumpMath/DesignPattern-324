package com.yujin.demo.file;

import java.security.AccessController;

import sun.security.action.GetPropertyAction;

/**
 * 获得文件的编码，如：GBK,Unicode, UTF-8等等
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
