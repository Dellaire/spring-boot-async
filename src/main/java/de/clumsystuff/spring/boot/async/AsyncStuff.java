package de.clumsystuff.spring.boot.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
public class AsyncStuff {

	@Autowired
	private RequestScopedData requestScopedData;

	@Async
	public Future<String> asyncOk(String data) {

		this.requestScopedData.setData(data);

		try {
			System.out.println("### (1) ###");
			Thread.sleep(2000);
			System.out.println("### (2) - " + this.requestScopedData.getData() + " ###");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return CompletableFuture.completedFuture(this.requestScopedData.getData());
	}

	@Async
	public CompletableFuture<String> asyncError(String data) {

		this.requestScopedData.setData(data);

		try {
			System.out.println("### (1) ###");
			Thread.sleep(2000);
			throw new RuntimeException("some error");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return CompletableFuture.completedFuture(this.requestScopedData.getData());
	}

	public String futureError(String data) throws Exception {

		this.requestScopedData.setData(data);

		System.out.println("### (1) ###");
		Thread.sleep(2000);
		if (true) {
			throw new RuntimeException("some error");
		}

		return this.requestScopedData.getData();
	}
}
