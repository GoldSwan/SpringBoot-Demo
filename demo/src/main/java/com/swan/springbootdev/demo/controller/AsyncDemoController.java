package com.swan.springbootdev.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
		return String.format(str);
	}	

	@GetMapping("/sync")
	public String doSync() {
		String str = "Do Sync!";
		LOGGER.info(str);
		messageSendService.sendMessageSync();
		return String.format(str);
	}
}
