package top.murphypen.springcloud.service.fallback;

import model.CommonResult;
import org.springframework.stereotype.Component;
import top.murphypen.springcloud.service.OrderService;

@Component
public class OrderServiceFallBack implements OrderService {
    @Override
    public CommonResult getPaymentOkById(Long id) {
        return new CommonResult<>(500, getCurrentThread() + "查询" + id + "时异常，来自全局", null);
    }

    @Override
    public CommonResult getPaymentTimeoutById(Long id) {
        return new CommonResult<>(500, getCurrentThread() + "查询" + id + "时异常，来自全局", null);
    }

    public String getCurrentThread() {
        return "当前线程:[" + Thread.currentThread().getId() + "]" + Thread.currentThread().getName() + ";";
    }
}
