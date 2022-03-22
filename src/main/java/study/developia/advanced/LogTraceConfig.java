package study.developia.advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.developia.advanced.trace.newlogtrace.LogTrace;
import study.developia.advanced.trace.newlogtrace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
