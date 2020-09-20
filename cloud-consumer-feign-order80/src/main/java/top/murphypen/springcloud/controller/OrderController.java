package top.murphypen.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import model.CommonResult;
import model.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.murphypen.springcloud.config.FeignService;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderController {

    @Resource
    private FeignService feignService;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        log.info("ddd");
        return feignService.create(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        log.info(">>>getPayment:{}", id);
        return feignService.getPayment(id);
    }



}
