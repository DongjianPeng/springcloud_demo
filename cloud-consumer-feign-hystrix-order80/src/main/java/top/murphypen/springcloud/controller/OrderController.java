package top.murphypen.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import model.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.murphypen.springcloud.service.OrderService;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @HystrixCommand(fallbackMethod = "getPaymentTimeoutByIdFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    }, defaultFallback = "getPaymentTimeoutByIdDefaultFallBack")
    @GetMapping("/consumer/payment/get/ok/{id}")
    public CommonResult getPaymentOk(@PathVariable("id") Long id) {
        log.info(">>>getPayment:{}", id);
        return orderService.getPaymentOkById(id);
    }


    @HystrixCommand(fallbackMethod = "getPaymentTimeoutByIdFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    }, defaultFallback = "getPaymentTimeoutByIdDefaultFallBack")
    @GetMapping("/consumer/payment/get/timeout/{id}")
    public CommonResult getPaymentTimeout(@PathVariable("id") Long id) {
        log.info(">>>getPayment:{}", id);
        return orderService.getPaymentTimeoutById(id);
    }


    public CommonResult getPaymentTimeoutByIdFallBack(Long id) {
        return new CommonResult<>(500, getCurrentThread() + "查询" + id + "时异常", null);
    }

    public CommonResult getPaymentTimeoutByIdDefaultFallBack(Long id) {
        return new CommonResult<>(500, getCurrentThread() + "查询" + id + "时异常", null);
    }

    public String getCurrentThread() {
        return "当前线程:[" + Thread.currentThread().getId() + "]" + Thread.currentThread().getName() + ";";
    }

}
