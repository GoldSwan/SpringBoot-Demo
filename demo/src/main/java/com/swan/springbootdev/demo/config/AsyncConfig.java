package com.swan.springbootdev.demo.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig extends AsyncConfigurerSupport{

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);//기본 실행 대기 중인 Thread 갯수
		executor.setMaxPoolSize(5);//동시 동작 최대 Thread 갯수
		executor.setQueueCapacity(2);//MaxPoolSize를 초과하는 요청이 올경우 나중에 처리하기 위해 요청 정보를 임시로 저장해두기 위한 큐 수용량 설정
		executor.setThreadNamePrefix("swan-async-");//SpringBoot가 생성하는 스레드 접두사 설정
		executor.initialize();
		return executor;
	}
	
}
