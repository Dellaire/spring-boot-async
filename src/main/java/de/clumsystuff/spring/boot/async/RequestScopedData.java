package de.clumsystuff.spring.boot.async;

import org.springframework.stereotype.Component;

@Component
public class RequestScopedData {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
