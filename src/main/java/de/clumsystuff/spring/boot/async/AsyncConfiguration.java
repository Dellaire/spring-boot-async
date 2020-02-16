package de.clumsystuff.spring.boot.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AsyncConfiguration implements AsyncConfigurer {

	@Autowired
	private ExceptionHandler exceptionHandler;

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

		return this.exceptionHandler;
	}

	/*
	 * public TaskDecorator createAsyncTaskDecorator() {
	 * 
	 * return runnable -> {
	 * 
	 * RequestAttributes context = RequestContextHolder.currentRequestAttributes();
	 * Map<String, String> contextMap = MDC.getCopyOfContextMap();
	 * 
	 * return () -> { try { RequestContextHolder.setRequestAttributes(context);
	 * MDC.setContextMap(contextMap); runnable.run(); } finally { MDC.clear();
	 * RequestContextHolder.resetRequestAttributes(); } }; }; }
	 * 
	 * @Override
	 * 
	 * @Bean public Executor getAsyncExecutor() {
	 * 
	 * ThreadPoolTaskExecutor poolExecutor = new ThreadPoolTaskExecutor();
	 * poolExecutor.setTaskDecorator(createAsyncTaskDecorator());
	 * poolExecutor.initialize();
	 * 
	 * return poolExecutor; }
	 */
}
