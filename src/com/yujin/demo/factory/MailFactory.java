package com.yujin.demo.factory;

public class MailFactory implements Provider{

	@Override
	public Sender produce() {
		return new MailSender();
	}

}
