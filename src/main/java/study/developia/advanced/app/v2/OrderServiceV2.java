package study.developia.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.developia.advanced.trace.LogTrace.LogTraceV2;
import study.developia.advanced.trace.TraceId;
import study.developia.advanced.trace.TraceStatus;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final LogTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {

        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId,"OrderServiceV1.orderItem()");
            orderRepository.save(traceId, itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }
}
