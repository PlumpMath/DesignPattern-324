package com.yujin.demo.factory;

public class MSMFactory implements Provider{

	@Override
	public Sender produce() {
		return new MSMSender();
	}

}
