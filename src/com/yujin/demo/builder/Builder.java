package com.yujin.demo.builder;

import java.util.ArrayList;

import com.yujin.demo.factory.MSMSender;
import com.yujin.demo.factory.MailSender;
import com.yujin.demo.factory.Sender;

public class Builder {

	private ArrayList<Sender> list = new ArrayList<Sender>();
	
	public void produceMailSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new MailSender());
		}
	}
	
	public void produceMsmSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new MSMSender());
		}
	}
}
