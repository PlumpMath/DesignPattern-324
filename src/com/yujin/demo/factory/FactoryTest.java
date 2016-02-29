package com.yujin.demo.factory;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Set;

import javax.lang.model.SourceVersion;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;

public class FactoryTest {

	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		/**
		 * 简单工厂方法模式
		 */
		Sender send = factory.produce("mail");
		send.send();
		
		/**
		 * 多个工厂方法模式
		 */
		Sender send2 = factory.produceMail();
		send2.send();
		
		/**
		 * 静态工厂方法
		 */
		Sender send3 = SendFactory.produceMSMSender2();
		send3.send();
		/**
		 * 抽象工厂方法
		 */
		Provider provider = new MailFactory();
		Sender send4 = provider.produce();
		send4.send();
		
	}
}
