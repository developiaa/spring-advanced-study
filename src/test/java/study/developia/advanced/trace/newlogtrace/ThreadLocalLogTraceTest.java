package study.developia.advanced.trace.newlogtrace;

import org.junit.jupiter.api.Test;
import study.developia.advanced.trace.TraceStatus;

class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void begin_end_level() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status1);
        trace.end(status2);
    }

    @Test
    void begin_exception() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status1, new IllegalStateException());
        trace.exception(status2, new IllegalStateException());
    }

}