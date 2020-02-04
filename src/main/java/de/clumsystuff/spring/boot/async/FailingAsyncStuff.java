package de.clumsystuff.spring.boot.async;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class FailingAsyncStuff {

	@Async
	public void noReturnValue() {

		if (true) {
			throw new RuntimeException("async exception");
		}
	}

	@Async
	public CompletableFuture<String> returnValue() {

		if (true) {
			throw new RuntimeException("async exception");
		}
		
		return CompletableFuture.supplyAsync(() -> "result");
	}
}
