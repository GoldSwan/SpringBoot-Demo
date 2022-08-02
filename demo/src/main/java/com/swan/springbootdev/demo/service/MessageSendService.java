package com.swan.springbootdev.demo.service;

import java.util.concurrent.CompletableFuture;

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
	@Async
	public CompletableFuture<String> sendMessageASyncByCompletableFuture1() {	
		//supplyAsync 사용 방법
		/*
		return CompletableFuture.supplyAsync(()->{
			try {
				LOGGER.info("sendMessageASync(CompletableFuture1) : ASync start.");
				Thread.sleep(5000);
				LOGGER.info("sendMessageASync(CompletableFuture1) : ASync end.");		
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			return "ASync(CompletableFuture1) result value";
		});
		*/
		//completedFuture 사용 방법
		try {
			LOGGER.info("sendMessageASync(CompletableFuture1) : ASync start.");
			Thread.sleep(5000);
			LOGGER.info("sendMessageASync(CompletableFuture1) : ASync end.");		
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture("ASync(CompletableFuture1) result value");		
	}	
	@Async
	public CompletableFuture<String> sendMessageASyncByCompletableFuture2(String str) {	
		try {
			LOGGER.info("sendMessageASync(CompletableFuture2) : ASync start. before callback value:"+str);
			Thread.sleep(5000);
			LOGGER.info("sendMessageASync(CompletableFuture2) : ASync end.");		
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture("ASync(CompletableFuture2) result value");
	}
	@Async
	public CompletableFuture<String> sendMessageASyncByCompletableFuture3(String str) {	
		try {
			LOGGER.info("sendMessageASync(CompletableFuture3) : ASync start. before callback value:"+str);
			Thread.sleep(5000);
			LOGGER.info("sendMessageASync(CompletableFuture3) : ASync end.");		
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture("ASync(CompletableFuture3) result value");
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
