package de.clumsystuff.spring.boot.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
public class AsyncStuff {

	@Autowired
	private RequestScopedData requestScopedData;

	public Future<String> useFuture(RequestScopedData requestScopedData) {

		return CompletableFuture.supplyAsync(() -> {

			try {
				RequestContextHolder.setRequestAttributes(new RequestScopeAttributes());
				this.requestScopedData = requestScopedData;

				System.out.println("### (1) ###");
				Thread.sleep(2000);
				System.out.println("### (2) - " + this.requestScopedData.getData() + " ###");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			return "data";
		});
	}

	@Async
	public Future<String> useAsync(RequestScopedData requestScopedData) {

		RequestContextHolder.setRequestAttributes(new RequestScopeAttributes());
		this.requestScopedData = requestScopedData;

		try {
			System.out.println("### (1) ###");
			Thread.sleep(2000);
			System.out.println("### (2) - " + this.requestScopedData.getData() + " ###");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return CompletableFuture.completedFuture("data");
	}
}
