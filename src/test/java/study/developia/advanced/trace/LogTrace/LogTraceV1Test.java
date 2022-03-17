package study.developia.advanced.trace.LogTrace;

import org.junit.jupiter.api.Test;
import study.developia.advanced.trace.TraceStatus;

import static org.junit.jupiter.api.Assertions.*;

class LogTraceV1Test {

    @Test
    void begin_end() {
        LogTraceV1 trace = new LogTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.end(status);
    }

    @Test
    void begin_exception() {
        LogTraceV1 trace = new LogTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalAccessException());
    }

}