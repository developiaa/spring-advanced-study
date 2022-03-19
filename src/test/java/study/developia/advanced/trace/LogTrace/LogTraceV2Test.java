package study.developia.advanced.trace.LogTrace;

import org.junit.jupiter.api.Test;
import study.developia.advanced.trace.TraceStatus;

class LogTraceV2Test {

    @Test
    void begin_end() {
        LogTraceV2 trace = new LogTraceV2();
        TraceStatus status1 = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2 ");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception() {
        LogTraceV2 trace = new LogTraceV2();
        TraceStatus status1 = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
        trace.exception(status2, new IllegalAccessException());
        trace.exception(status1, new IllegalAccessException());
    }

}