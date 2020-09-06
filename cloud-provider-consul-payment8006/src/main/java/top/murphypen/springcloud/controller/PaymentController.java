package top.murphypen.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
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

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment param = new Payment();
        param.setId(id);
        Payment payment = paymentService.queryPaymentLimit1(param);
        if (payment == null) {
            return new CommonResult<>(444, "端口" + serverPoint + "未找到", null);
        } else {
            return new CommonResult<>(200, "端口" + serverPoint + "success", payment);
        }
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
