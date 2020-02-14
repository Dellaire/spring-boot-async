package de.clumsystuff.spring.boot.async;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class ExceptionHandler implements AsyncUncaughtExceptionHandler {

	@Autowired
	private RequestScopedData requestScopedData;

	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... params) {

		System.out.println(requestScopedData.getData());
	}
}
