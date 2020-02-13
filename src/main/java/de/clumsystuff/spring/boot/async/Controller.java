package de.clumsystuff.spring.boot.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

	@Autowired
	private FailingAsyncStuff failingAsyncStuff;

	@Autowired
	private RequestScopedData requestScopedData;
	
	@RequestMapping("/value")
	public String callWithValue() throws Exception {
		
		return this.failingAsyncStuff.returnValue().get();
	}
	
	@RequestMapping("/noValue")
	public void callWithoutValue() {

		this.requestScopedData.setData("data");
		this.failingAsyncStuff.noReturnValue();
	}
}
