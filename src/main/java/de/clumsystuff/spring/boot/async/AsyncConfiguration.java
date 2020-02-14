package de.clumsystuff.spring.boot.async;

import org.slf4j.MDC;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Map;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfiguration implements AsyncConfigurer {

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

        return new ExceptionHandler();
    }

    /*public TaskDecorator createAsyncTaskDecorator() {

        return runnable -> {

            RequestAttributes context =
                    RequestContextHolder.currentRequestAttributes();
            Map<String, String> contextMap = MDC.getCopyOfContextMap();

            return () -> {
                try {
                    RequestContextHolder.setRequestAttributes(context);
                    MDC.setContextMap(contextMap);
                    runnable.run();
                } finally {
                    MDC.clear();
                    RequestContextHolder.resetRequestAttributes();
                }
            };
        };
    }

    @Override
    @Bean
    public Executor getAsyncExecutor() {

        ThreadPoolTaskExecutor poolExecutor = new ThreadPoolTaskExecutor();
        poolExecutor.setTaskDecorator(createAsyncTaskDecorator());
        poolExecutor.initialize();

        return poolExecutor;
    }*/
}
