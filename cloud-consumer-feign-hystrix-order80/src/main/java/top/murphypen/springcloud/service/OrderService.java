package top.murphypen.springcloud.service;

import model.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.murphypen.springcloud.service.fallback.OrderServiceFallBack;

@Component
@FeignClient(value = "cloud-payment-service", fallback = OrderServiceFallBack.class)
public interface OrderService {

    @GetMapping(value = "/payment/get/ok/{id}")
    public CommonResult getPaymentOkById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/get/timeout/{id}")
    public CommonResult getPaymentTimeoutById(@PathVariable("id") Long id);
}
