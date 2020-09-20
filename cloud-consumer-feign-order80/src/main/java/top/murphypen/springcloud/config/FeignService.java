package top.murphypen.springcloud.config;

import model.CommonResult;
import model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface FeignService {

    @GetMapping("/payment/create")
    public CommonResult create(Payment payment);

    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id);
}
