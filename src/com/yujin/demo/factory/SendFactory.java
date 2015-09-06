package com.yujin.demo.factory;

public class SendFactory {
	
	/**
	 * 简单工厂模式
	 * @param type
	 * @return
	 */
	public Sender produce(String type) {
		if ("mail".equals(type)) {
			return new MailSender();
		} else if ("sms".equals(type)) {
			return new MSMSender();
		} else {
			System.out.println("Please input right type");
			return null;
		}
	}
	
	/**
	 * 多个工厂方法模式
	 * @return
	 */
	public Sender produceMail() {
		return new MailSender();
	}
	
	public Sender produceMSMSender() {
		return new MSMSender();
	}
	
	/**
	 * 静态工厂方法模式
	 */
	
	public static Sender produceMail2() {
		return new MailSender();
	}
	
	public static Sender produceMSMSender2() {
		return new MSMSender();
	}
}
