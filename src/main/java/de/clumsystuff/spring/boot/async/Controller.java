package de.clumsystuff.spring.boot.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

	@Autowired
	private AsyncStuff asyncStuff;

	@Autowired
	private RequestScopedData requestScopedData;
	
	@RequestMapping("/future")
	public String callWithValue() throws Exception {
		
		this.requestScopedData.setData("data");
		this.asyncStuff.useFuture();
		
		return "future result";
	}
	
	@RequestMapping("/async")
	public String callWithoutValue() {

		this.requestScopedData.setData("data");
		this.asyncStuff.useAsync();
		
		return "async result";
	}
}
