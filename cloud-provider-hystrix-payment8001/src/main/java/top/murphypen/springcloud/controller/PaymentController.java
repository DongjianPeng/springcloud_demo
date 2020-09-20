package top.murphypen.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import model.CommonResult;
import model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import top.murphypen.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPoint;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.insertPayment(payment);
        log.info(">>>>插入结果:{}", result);
        if (result > 0) {
            return new CommonResult<>(200, "success", result);
        } else {
            return new CommonResult(444, "插入失败");
        }
    }

    @HystrixCommand(fallbackMethod = "getPaymentTimeoutByIdFallBack")
    @GetMapping(value = "/payment/get/ok/{id}")
    public CommonResult getPaymentOkById(@PathVariable("id") Long id) {
        Payment param = new Payment();
        param.setId(id);
        long a = 10 / id;
        Payment payment = paymentService.queryPaymentLimit1(param);
        if (payment == null) {
            return new CommonResult<>(444, getCurrentThread() + "端口" + serverPoint + "未找到", null);
        } else {
            return new CommonResult<>(200, getCurrentThread() + "端口" + serverPoint + "success", payment);
        }
    }

    @HystrixCommand(fallbackMethod = "getPaymentTimeoutByIdFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    })
    @GetMapping(value = "/payment/get/timeout/{id}")
    public CommonResult getPaymentTimeoutById(@PathVariable("id") Long id) throws InterruptedException {
        Payment param = new Payment();
        param.setId(id);
        Payment payment = paymentService.queryPaymentLimit1(param);
        TimeUnit.SECONDS.sleep(2);
        if (payment == null) {
            return new CommonResult<>(444, getCurrentThread() + "端口" + serverPoint + "未找到", null);
        } else {
            return new CommonResult<>(200, getCurrentThread() + "端口" + serverPoint + "success", payment);
        }
    }

    public CommonResult getPaymentTimeoutByIdFallBack(Long id) {
        return new CommonResult<>(500, getCurrentThread() + "查询" + id + "时异常", null);
    }

    public String getCurrentThread() {
        return "当前线程:[" + Thread.currentThread().getId() + "]" + Thread.currentThread().getName() + ";";
    }

    @GetMapping(path = {"/discovery/service/{serviceId}", "/discovery/service"})
    public Object getDiscovery(@PathVariable(required = false) String serviceId) {
        log.info("serviceId:{}", serviceId);
        if (serviceId != null && !serviceId.isEmpty()) {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            return JSONObject.toJSONString(instances);
        }
        List<String> services = discoveryClient.getServices();
        return Arrays.toString(services.toArray(new String[0]));
    }
}
