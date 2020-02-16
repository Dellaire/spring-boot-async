package de.clumsystuff.spring.boot.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    private AsyncStuff asyncStuff;
    
    @Autowired
	private ExceptionHandler exceptionHandler;

    @RequestMapping("/asyncOk")
    public String asyncOk() {

        this.asyncStuff.asyncOk("data");

        return "async result";
    }

	@RequestMapping("/asyncError")
	public String asyncError() {

		this.asyncStuff.asyncError("data");

		return "async result";
	}
	
	@RequestMapping("/futureError")
	public String futureError() {

		CompletableFuture.supplyAsync(() -> {
			try {
				return this.asyncStuff.futureError("data");
			} catch (Exception e) {
				this.exceptionHandler.handleUncaughtException(e, null, null);
				throw new CompletionException(e);
			}
		});

		return "async result";
	}
}
