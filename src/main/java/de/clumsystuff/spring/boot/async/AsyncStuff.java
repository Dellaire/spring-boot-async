package de.clumsystuff.spring.boot.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncStuff {

	@Autowired
	private RequestScopedData requestScopedData;

	public Future<String> useFuture() {

		return CompletableFuture.supplyAsync(() -> {

			try {
				System.out.println("### (1) ###");
				Thread.sleep(5000);
				//System.out.println("### (2) - " + this.requestScopedData.getData() + " ###");
				System.out.println("### (2) ###");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			return "data";
		});
	}

	@Async
	public Future<String> useAsync() {

		try {
			System.out.println("### (1) ###");
			Thread.sleep(5000);
			//System.out.println("### (2) - " + this.requestScopedData.getData() + " ###");
			System.out.println("### (2) ###");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return CompletableFuture.completedFuture("data");
	}
}
