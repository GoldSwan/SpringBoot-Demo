package com.swan.springbootdev.demo.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swan.springbootdev.demo.service.MessageSendService;

@RestController
public class AsyncDemoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AsyncDemoController.class);
	
	@Autowired
	MessageSendService messageSendService;
	
	@GetMapping("/async")
	public String doAsync() {
		String str = "Do Async!";
		LOGGER.info(str);
		try {
		messageSendService.sendMessageASync().addCallback(new ListenableFutureCallback<String>() {
			@Override
			public void onSuccess(String result) {
				LOGGER.info("Callback success!");	
				LOGGER.info("result:"+result);
			}
			@Override
			public void onFailure(Throwable e) {
				LOGGER.info("Callback failure...");	
				LOGGER.info("Error message:"+e.getMessage());
			}
		});
		}catch(TaskRejectedException e) {
			//최대 Thread, QueueCapacity 초과시 발생하는 TaskRejectedException 처리
			LOGGER.info("요청 수용량 초과로 인해 비동기 요청이 실패했습니다.");
		}
		return String.format(str);
	}	

	@GetMapping("/async/completablefuture")
	public String doAsyncCompletableFuture() throws InterruptedException, ExecutionException {
		String str = "Do Async!";
		LOGGER.info(str);
		CompletableFuture<String> sendMessage = CompletableFuture.completedFuture("");
		
		try {
			//CompletableFuture를 이용한 콜백 중첩 예제
			sendMessage = messageSendService.sendMessageASyncByCompletableFuture1()
					                        .thenCompose(messageSendService::sendMessageASyncByCompletableFuture2)
											.thenCompose(messageSendService::sendMessageASyncByCompletableFuture3);
		}catch(TaskRejectedException e) {
			//최대 Thread, QueueCapacity 초과시 발생하는 TaskRejectedException 처리
			LOGGER.info("요청 수용량 초과로 인해 비동기 요청이 실패했습니다.");
		}
		return sendMessage.get();
	}
	
	@GetMapping("/sync")
	public String doSync() {
		String str = "Do Sync!";
		LOGGER.info(str);
		messageSendService.sendMessageSync();
		return String.format(str);
	}
}
