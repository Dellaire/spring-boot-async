package de.clumsystuff.spring.boot.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    private AsyncStuff asyncStuff;

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
}
