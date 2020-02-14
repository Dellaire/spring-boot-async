package de.clumsystuff.spring.boot.async;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class ExceptionHandler implements AsyncUncaughtExceptionHandler {

	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... params) {

		System.out.println("### ### ###");
		System.out.println("### ### ###");
		System.out.println("### ### ###");
		System.out.println("### ### ###");
		System.out.println("### ### ###");
		System.out.println("### ### ###");
	}
}
