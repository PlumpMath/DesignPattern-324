package com.yujin.demo.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class DaemonThread implements Runnable {

    @Override
    public void run() {
        System.out.println("进入守护线程");
        writToFile();
        System.out.println("退出守护线程");
    }
    
    void writToFile() {
        OutputStream out = null;
        try {
            File file = new File("/home/yujin/test/daemo.txt");
            out = new FileOutputStream(file, true);
            int count = 0;
            while (count < 999) {
                out.write(("\t\rword" + count).getBytes());
                System.out.println("守护线程" + Thread.currentThread().getName() + "向文件写入了word" + count++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("----finally-1-----");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("----finally-2-----");
            try {
                out.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                System.out.println("----finally-3-----");
            }
        }
    }
    
}
/**
 * 守护线程与用户线程的演示
 * 一旦所有用户线程都结束运行,守护线程也会随JVM一起结束工作.
 * @author yujin
 *
 */
public class DaemonThreadDemo {

    public static void main(String[] args) {
        System.out.println("程序进入主线程" + Thread.currentThread().getName());
        DaemonThread daemon = new DaemonThread();
        Thread th = new Thread(daemon);
        th.setDaemon(true);
        th.start();
        System.out.println("程序退出主线程" + Thread.currentThread().getName());
        
    }
}
