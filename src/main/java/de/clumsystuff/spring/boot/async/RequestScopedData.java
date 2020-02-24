package de.clumsystuff.spring.boot.async;

import org.springframework.stereotype.Component;

@Component
public class RequestScopedData {

    private ThreadLocal<String> data = new ThreadLocal<>();

    public String getData() {
        return this.data.get();
    }

    public void setData(String data) {
        this.data.set(data);
    }
}
