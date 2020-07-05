package top.murphypen.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import model.CommonResult;
import model.Payment;
import top.murphypen.springcloud.service.PaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

	@Resource
	private PaymentService paymentService;

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
			return new CommonResult<>(444, "未找到", null);
		} else {
			return new CommonResult<>(200, "success", payment);
		}
	}
}
