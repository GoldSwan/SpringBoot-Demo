package com.swan.springbootdev.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class MessageSendService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageSendService.class);
	
	@Async
	public ListenableFuture<String> sendMessageASync() {	
		try {
			LOGGER.info("sendMessageASync : ASync start.");
			Thread.sleep(5000);
			LOGGER.info("sendMessageASync : ASync end.");		
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		return new AsyncResult<String>("ASync result value");
	}
	public void sendMessageSync() {
		try {
			LOGGER.info("sendMessageSync : Sync start.");
			Thread.sleep(5000);
			LOGGER.info("sendMessageSync : Sync end.");
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
